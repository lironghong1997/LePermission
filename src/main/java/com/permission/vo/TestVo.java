package com.permission.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/18 16:36
* @description:
*/
@Data
public class TestVo {
    @NotBlank
    private String msg;
    @NotNull
    private Integer id;
    //@NotEmpty
    private List<String> str;
}
