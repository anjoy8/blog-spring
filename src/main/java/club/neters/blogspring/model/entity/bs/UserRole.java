package club.neters.blogspring.model.entity.bs;

import club.neters.blogspring.core.annotation.EntityDoc;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户角色关系表
 *
 * @author laozhang
 * @date 2021/06/16
 */
@EqualsAndHashCode(callSuper = false)
@EntityDoc(note = "用户角色关系表", isClass = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("UserRole")
public class UserRole extends BaseEntity {

    @EntityDoc(note = "UserId")
    @TableId(value = "UserId")
    private Integer UserId;

    @EntityDoc(note = "RoleId")
    @TableId(value = "RoleId")
    private Integer RoleId;

}
