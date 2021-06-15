package club.neters.blogspring.controller;

import club.neters.blogspring.model.dto.UserInfoDto;
import club.neters.blogspring.model.dto.ResponseBean;
import club.neters.blogspring.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author laozhang
 * @date 2021/06/12
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    private final IUserInfoService userInfoService;

    @Autowired
    public UserInfoController(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    /**
     * 列表查询
     *
     * @param bean 请求参数
     * @return 用户列表
     */
    @ResponseBody
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseBean<List<UserInfoDto>> listPage(UserInfoDto bean) {
        return userInfoService.findList(bean);
    }

}
