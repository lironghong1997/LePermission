package com.permission.controller;

import com.permission.beans.PageQuery;
import com.permission.beans.PageResult;
import com.permission.common.JsonData;
import com.permission.model.SysUser;
import com.permission.service.SysUserService;
import com.permission.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/5/7 17:18
* @description:
*/
@Controller
@RequestMapping("/sys/user")
public class SysuUserController {

    @Autowired
    SysUserService userService;
    @PostMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserVo userVo) {
        userService.save(userVo);
        return JsonData.success();
    }
    @PostMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserVo userVo) {
        userService.update(userVo);
        return JsonData.success();
    }

    //分页显示用户
    @PostMapping("/userlist.json")
    @ResponseBody
    public JsonData page(@RequestParam("deptid") Integer deptid, PageQuery pageQuery){
        PageResult<SysUser> userResultList = userService.getPageByDeptId(deptid, pageQuery);
        return JsonData.success(userResultList);
    }
}
