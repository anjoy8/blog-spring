package club.neters.blogspring.controller;

import club.neters.blogspring.model.dto.UserInfoDto;
import club.neters.blogspring.model.dto.ResponseBean;
import club.neters.blogspring.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    private final IUserInfoService _userInfoService;

    public UserInfoController(IUserInfoService userInfoService) {
        _userInfoService = userInfoService;
    }

    @GetMapping("/info")
    public String info(String id) {
        return "aaa";
    }

    /**
     * 列表查询
     *
     * @param bean
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseBean listPage(UserInfoDto bean) {
        var userBeans = _userInfoService.findList(bean);
        return ResponseBean.ok(userBeans);
    }

    @ApiOperation(value = "获取菜单详情", notes = "根据id获取菜单")
    @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "String", paramType = "query")
    @RequestMapping("get-by-id")
    public ResponseBean getById(@RequestParam("id") String id) {
        return ResponseBean.ok(null);
    }

}
