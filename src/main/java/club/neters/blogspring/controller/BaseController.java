package club.neters.blogspring.controller;

import club.neters.blogspring.model.dto.SysUserDTO;

public class BaseController {

    /**
     * 获取用户信息
     * token
     * @return
     */
    public SysUserDTO getLoginUser(){
        SysUserDTO sysUserDto=new SysUserDTO();
        sysUserDto.setAccount("admin");
        sysUserDto.setPassword("admin");
        return  sysUserDto;
    }


}
