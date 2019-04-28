package com.permission.controller;

import com.permission.common.ApplicationContextHelper;
import com.permission.common.JsonData;
import com.permission.exception.ParamException;
import com.permission.exception.PermissionException;
import com.permission.mapper.SysAclMapper;
import com.permission.model.SysAcl;
import com.permission.util.BeanValidator;
import com.permission.util.JsonUtils;
import com.permission.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new PermissionException("test exception");
        // return JsonData.success("hello,permission");
    }

    @RequestMapping("/validator.json")
    @ResponseBody
    public JsonData validator(TestVo vo) throws ParamException {
        log.info("validator");
        SysAclMapper sysAclMapper = ApplicationContextHelper.popBean(SysAclMapper.class);
        SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(1);
        log.info(JsonUtils.objtoString(sysAcl)+"哈哈");
        BeanValidator.check(vo);
        return JsonData.success("test validator");

    }
}
