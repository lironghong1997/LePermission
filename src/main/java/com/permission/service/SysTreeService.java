package com.permission.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.permission.mapper.SysDepeMapper;
import com.permission.model.SysDepe;
import com.permission.util.LevelUtil;
import com.permission.vo.DeptLevleVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/4/30 17:41
 * @description: 计算树结构
 */
@Service
public class SysTreeService {

    @Autowired
    SysDepeMapper sysDepeMapper;

    public List<DeptLevleVo> deptTrees() {
        List<SysDepe> allDept = sysDepeMapper.getAllDept();

        List<DeptLevleVo> voList = Lists.newArrayList();

        for (SysDepe sysdep : allDept) {
            DeptLevleVo adapt = DeptLevleVo.adapt(sysdep);
            voList.add(adapt);
        }
        return deptlistToTree(voList);
    }

    //递归将Tree组装起来
    public List<DeptLevleVo> deptlistToTree(List<DeptLevleVo> volevleList) {
        if (CollectionUtils.isEmpty(volevleList)) {
            return Lists.newArrayList();
        }
        //level -> [dept1,dept2] Multimap相当于 Map<String,List<Object>>
        Multimap<String, DeptLevleVo> levleVoMultimap = ArrayListMultimap.create();

        List<DeptLevleVo> rootlist = Lists.newArrayList();

        for (DeptLevleVo deptLevleVo : volevleList) {
            levleVoMultimap.put(deptLevleVo.getLevle(),deptLevleVo);
            if (LevelUtil.ROOT.equals(deptLevleVo.getLevle())) {
                rootlist.add(deptLevleVo);
            }
        }
        //对rootlist进行排序 按照seq从小到大进行排序
        Collections.sort(rootlist, new Comparator<DeptLevleVo>() {
            @Override
            public int compare(DeptLevleVo o1, DeptLevleVo o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        //递归生成树
         transformDeptTree(rootlist,LevelUtil.ROOT,levleVoMultimap);
         return rootlist;

    }

    //递归排序
    /*
    * levle: 0
    * levle 0.1
    * levle 0.2
    * */
    public void transformDeptTree(List<DeptLevleVo> deptLevleVos,String levle,Multimap<String, DeptLevleVo> levleVoMultimap){
        for (int i = 0; i < deptLevleVos.size(); i++) {
            //遍历该层的没个元素
            DeptLevleVo deptLevleVo = deptLevleVos.get(i);
            //处理当前层级的数据
            String nextlevle = LevelUtil.levelroolcalc(levle,deptLevleVo.getId());
            //处理下一层
            List<DeptLevleVo> tempDeptList = (List<DeptLevleVo>) levleVoMultimap.get(nextlevle);
            if (CollectionUtils.isNotEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList, new Comparator<DeptLevleVo>() {
                    @Override
                    public int compare(DeptLevleVo o1, DeptLevleVo o2) {
                        return o1.getSeq() - o2.getSeq();
                    }
                });
                //设置下一层部门
                deptLevleVo.setDeptLevlelist(tempDeptList);
                //进入到下一层
                transformDeptTree(tempDeptList,nextlevle,levleVoMultimap);
            }
        }
    }
}
