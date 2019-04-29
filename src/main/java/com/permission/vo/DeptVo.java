package com.permission.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
*@version 1.0.0
*@author lironghong
*@date 2019/4/29 16:07
*@description 
*/
@Data
public class DeptVo {
    private Integer id;
    @NotBlank(message = "部门名称不能为空")
    @Length(max = 15,min = 2,message = "部门名称最大长度15个字符，最小长度2个字符")
    private String name;
    private Integer parentId;
    @NotNull(message = "展示顺序不可以为空")
    private Integer seq;
    @Length(max = 150,message = "备注的长度不能超过150个字")
    private String remark;
}
