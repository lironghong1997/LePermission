package com.permission.service;

import com.google.common.base.Preconditions;
import com.permission.beans.PageQuery;
import com.permission.beans.PageResult;
import com.permission.exception.ParamException;
import com.permission.mapper.SysUserMapper;
import com.permission.model.SysUser;
import com.permission.util.BeanValidator;
import com.permission.util.MD5Util;
import com.permission.util.PasswordUtil;
import com.permission.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/5/7 17:34
 * @description:
 */

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    public void save(UserVo userVo) {
        BeanValidator.check(userVo);
        if (checkEmailExist(userVo.getMail(), userVo.getId())) {
            throw new ParamException("邮箱已存在");
        }
        if (checkTelPhoneExist(userVo.getTelephone(), userVo.getId())) {
            throw new ParamException("电话已存在");
        }
        //String password = PasswordUtil.randomPassword();
        String password = "123456";
        password = MD5Util.encrypt(password);
        SysUser sysUser = SysUser.builder().username(userVo.getUsername()).telephone(userVo.getTelephone()).mail(userVo.getMail())
                .password(password).deptId(userVo.getDeptId()).status(userVo.getStatus()).remark(userVo.getRemark()).build();
        sysUser.setOperator("user");
        sysUser.setOperaterIp("127.0.0.1");
        sysUser.setOperaterTime(new Date());
        //// TODO: sentemail
        sysUserMapper.insertSelective(sysUser);
    }

    public void update(UserVo userVo) {
        BeanValidator.check(userVo);
        if (checkEmailExist(userVo.getMail(), userVo.getId())) {
            throw new ParamException("邮箱已存在");
        }
        if (checkTelPhoneExist(userVo.getTelephone(), userVo.getId())) {
            throw new ParamException("电话已存在");
        }
        SysUser beforesysUser = sysUserMapper.selectByPrimaryKey(userVo.getId());
        Preconditions.checkNotNull(beforesysUser, "待更新用户不存在");
        SysUser aftersysUser = SysUser.builder().id(userVo.getId()).username(userVo.getUsername()).telephone(userVo.getTelephone()).mail(userVo.getMail())
                .password(beforesysUser.getPassword()).deptId(userVo.getDeptId()).status(userVo.getStatus()).remark(userVo.getRemark()).build();
        sysUserMapper.updateByPrimaryKeySelective(aftersysUser);
    }

    public boolean checkEmailExist(String mail, Integer userid) {
        return false;
    }

    public boolean checkTelPhoneExist(String telphone, Integer userid) {
        return false;
    }

    public PageResult<SysUser> getPageByDeptId(Integer deptid, PageQuery pageQuery){
        BeanValidator.check(pageQuery);
        int count = sysUserMapper.countByDeptId(deptid);
        if (count > 0) {
            List<SysUser> userList = sysUserMapper.getPageByDeptId(deptid, pageQuery);
            return PageResult.<SysUser>builder().total(count).date(userList).build();
        }
        return PageResult.<SysUser>builder().build();
    }
}
