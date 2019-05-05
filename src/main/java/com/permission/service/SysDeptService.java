package com.permission.service;

import com.google.common.base.Preconditions;
import com.permission.exception.ParamException;
import com.permission.mapper.SysDepeMapper;
import com.permission.model.SysDepe;
import com.permission.util.BeanValidator;
import com.permission.util.LevelUtil;
import com.permission.vo.DeptVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author lironghong
 * @version 1.0.0
 * @date 2019/4/29 16:23
 * @description
 */
@Service
public class SysDeptService {
    @Autowired
    SysDepeMapper sysDepeMapper;

    public void save(DeptVo deptVo) {
        BeanValidator.check(deptVo);
        if (checkExist(deptVo.getParentId(),deptVo.getName(),deptVo.getId())){
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDepe sysDepe = SysDepe.builder().name(deptVo.getName()).parentId(deptVo.getParentId()).seq(deptVo.getSeq()).remark(deptVo.getRemark()).build();
        sysDepe.setLevle(LevelUtil.levelroolcalc(getLevel(deptVo.getParentId()), deptVo.getParentId()));
        sysDepe.setOperator("system");//TODO
        sysDepe.setOperateIp("127.0.0.1");//TODO
        sysDepe.setOperateTime(new Date());

        sysDepeMapper.insertSelective(sysDepe);
    }

    public void update(DeptVo deptVo) {
        BeanValidator.check(deptVo);
        if (checkExist(deptVo.getParentId(),deptVo.getName(),deptVo.getId())){
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        //判断更新的部门是否存在
        SysDepe before = sysDepeMapper.selectByPrimaryKey(deptVo.getId());
        Preconditions.checkNotNull(before,"待更新部门不存在");
        SysDepe after = SysDepe.builder().id(deptVo.getId()).name(deptVo.getName()).parentId(deptVo.getParentId()).seq(deptVo.getSeq()).remark(deptVo.getRemark()).build();
        after.setLevle(LevelUtil.levelroolcalc(getLevel(deptVo.getParentId()),deptVo.getParentId()));
        after.setOperator("system-update");//TODO
        after.setOperateIp("127.0.0.1");//TODO
        after.setOperateTime(new Date());
    }
    @Transactional
    public void updateWithChild(SysDepe befor, SysDepe after){
        //判断是否需要更新子部门
        String newlevleperfix = after.getLevle();
        String oldlevleprfix = befor.getLevle();
        if (!after.getLevle().equals(befor.getLevle())){
            //处理子部门
            List<SysDepe> deptlist = sysDepeMapper.getChildDeptListByLevel(befor.getLevle());
            if (CollectionUtils.isNotEmpty(deptlist)){
                for (SysDepe sysDepe : deptlist){
                    String levle = sysDepe.getLevle();
                    //返回指定字符串在此字符串中第一次出现处的索引
                    if (levle.indexOf(oldlevleprfix) == 0) {
                        //substring返回字符串的子字符串第一个参数起始位置(包括),第二个参数结束位置(不包括)
                        levle = newlevleperfix + levle.substring(oldlevleprfix.length());
                        sysDepe.setLevle(levle);
                    }
                }
                sysDepeMapper.batchUpdateLevle(deptlist);
            }
        }
        sysDepeMapper.updateByPrimaryKey(after);
    }

    //检查部门是否重复
    private boolean checkExist(Integer parentId, String deptname,Integer deptId) {
        //TODO:
        return sysDepeMapper.countByNameAndParentId(parentId,deptname,deptId) > 0;
    }

    private String getLevel(Integer deptid){
        SysDepe sysDepe = sysDepeMapper.selectByPrimaryKey(deptid);
        if (sysDepe == null) {
            return null;
        }
        return sysDepe.getLevle();
    }
}
