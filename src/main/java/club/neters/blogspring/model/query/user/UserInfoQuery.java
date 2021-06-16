package club.neters.blogspring.model.query.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * user information query object
 *
 * @author wuare
 * @date 2021/6/16
 */
@Data
public class UserInfoQuery {

    @ApiModelProperty(value = "id")
    private Integer uID;

    @ApiModelProperty(value = "登录名")
    private String uLoginName;

    @ApiModelProperty(value = "真实名")
    private String uRealName;

    @ApiModelProperty(value = "名字")
    private String name;
}
