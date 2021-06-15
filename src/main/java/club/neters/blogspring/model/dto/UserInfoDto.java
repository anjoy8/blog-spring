package club.neters.blogspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 系统用户表
 *
 * @author laozhang
 * @date 2021/06/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDto {

    private Integer uID;

    private String uLoginName;


    private String uRealName;

    private Integer uStatus;

    private String uRemark;

    protected Date uCreateTime;

    protected Date uUpdateTime;

    private String name;

    private Integer sex;

    private Integer age;

    protected Date birth;

    private String addr;


    /**
     * 手机号
     */
    private String phone;


    /**
     * 验证码 登录用
     */
    private String verifyCode;


    /**
     * 新密码
     */
    private String newPassword;

}
