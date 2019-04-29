package com.permission.service;

import com.permission.exception.ParamException;
import com.permission.mapper.SysDepeMapper;
import com.permission.model.SysDepe;
import com.permission.util.BeanValidator;
import com.permission.util.LevelUtil;
import com.permission.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        /*if (checkExist(deptVo.getParentId(),deptVo.getName(),deptVo.getId())){
            throw new ParamException("同一层级下存在相同名称的部门");
        }*/
        SysDepe sysDepe = SysDepe.builder().name(deptVo.getName()).parentId(deptVo.getParentId()).seq(deptVo.getSeq()).remark(deptVo.getRemark()).build();
        sysDepe.setLevle(LevelUtil.levelroolcalc(getLevel(deptVo.getParentId()), deptVo.getParentId()));
        sysDepe.setOperator("system");//TODO
        sysDepe.setOperateIp("127.0.0.1");//TODO
        sysDepe.setOperateTime(new Date());

        sysDepeMapper.insertSelective(sysDepe);
    }
    //检查部门是否重复
    private boolean checkExist(Integer patentId, String deptname,Integer deptId) {
        //TODO:
        return true;
    }

    private String getLevel(Integer deptid){
        SysDepe sysDepe = sysDepeMapper.selectByPrimaryKey(deptid);
        if (sysDepe == null) {
            return null;
        }
        return sysDepe.getLevle();
    }
}
