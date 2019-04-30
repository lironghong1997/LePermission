package com.permission.vo;

import com.google.common.collect.Lists;
import com.permission.model.SysDepe;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import java.util.List;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/4/30 17:29
 * @description: 层级返回结构
 */
@Data
public class DeptLevleVo extends SysDepe {

    private List<DeptLevleVo> deptLevlelist = Lists.newArrayList();

    public static DeptLevleVo adapt(SysDepe sysDepe) {
        DeptLevleVo deptLevleVo = new DeptLevleVo();
        /*
        * 完成两个类相同资源的拷贝
        * */
        BeanUtils.copyProperties(sysDepe,deptLevleVo);
        return deptLevleVo;
    }

}
