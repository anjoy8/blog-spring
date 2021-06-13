package club.neters.blogspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    /**
     * 主键 唯一标识
     */
    private String code;

    /**
     * 是否有效
     */
    private Integer valid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 账号 唯一
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 用于加密密码的盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
     */
    private String status;

    /**
     * 审核状态
     */
    private String approveStatus;

    /**
     * 审核结果
     */
    private String approveResult;

    /**
     * 验证码 登录用
     */
    private String verifyCode;

    /**
     * 客户端机器标识 校验登录验证码用
     */
    private String keyCode;

    /**
     * 用户 code 集合
     */
    private List<String> userCodeList;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 该用户所属角色列表
     */
    private List<String> roleCodeList;
}
