package club.neters.blogspring.model.entity.bs;

import club.neters.blogspring.core.annotation.EntityDoc;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户信息表
 *
 * @author laozhang
 * @date 2021/06/12
 */
@EqualsAndHashCode(callSuper = true)
@EntityDoc(note = "系统用户", isClass = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_info")
public class UserInfoEntity extends BaseEntity {

    /**
     * 账号 唯一
     */
    @EntityDoc(note = "账号")
    private String account;

    /**
     * 密码
     */
    @EntityDoc(note = "密码")
    private String password;

    /**
     * 昵称
     */
    @EntityDoc(note = "昵称")
    private String name;

    /**
     * 用于加密密码的盐
     */
    @EntityDoc(note = "密码盐")
    private String salt;

    /**
     * 手机号
     */
    @EntityDoc(note = "手机号")
    private String phone;

    /**
     * 状态
     */
    @EntityDoc(note = "状态")
    private String status;

    /**
     * 审核状态
     */
    @EntityDoc(note = "审核状态")
    private String approveStatus;

    /**
     * 审核结果
     */
    @EntityDoc(note = "审核结果")
    private String approveResult;

}
