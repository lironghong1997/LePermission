package com.permission.controller;

import com.permission.common.JsonData;
import com.permission.service.SysDeptService;
import com.permission.util.BeanValidator;
import com.permission.vo.DeptVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lironghong
 * @version 1.0.0
 * @date 2019/4/29 16:17
 * @description
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {
    @Autowired
    SysDeptService sysDeptService;

    @PostMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptVo deptVo) {

        BeanValidator.check(deptVo);
        sysDeptService.save(deptVo);
        return JsonData.success();
    }
}
