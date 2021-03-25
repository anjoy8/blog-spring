package club.neters.blogspring.controller;

import club.neters.blogspring.model.dto.ResponseBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController extends BaseController {
    @ResponseBody
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public ResponseBean getVerifyCode() {
        return ResponseBean.ok(getLoginUser());
    }
}
