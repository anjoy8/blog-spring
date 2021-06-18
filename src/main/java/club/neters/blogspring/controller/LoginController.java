package club.neters.blogspring.controller;

import club.neters.blogspring.core.util.JwtUtils;
import club.neters.blogspring.model.vo.ApiResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 *
 * @author laozhang
 * @date 2021/06/19
 */
@Api(tags = "登录管理")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    /**
     * 登录
     */
    @ApiOperation(value = "获取令牌")
    @GetMapping(value = "/GetJwtToken")
    public ApiResultVo<String> getJwtToken() {
        Map<String, String> map = new HashMap<>();
        //请勿放用户的敏感信息，例如密码等
        map.put("userId", "111");
        map.put("username", "anson");
        map.put("role", "user");
        String token = JwtUtils.getToken(map);
        return ApiResultVo.ok(token); //前端可以存入localStorage
    }
}
