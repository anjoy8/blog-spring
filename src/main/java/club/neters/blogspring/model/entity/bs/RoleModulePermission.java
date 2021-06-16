package club.neters.blogspring.model.entity.bs;

import club.neters.blogspring.core.annotation.EntityDoc;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户模块菜单关系表
 *
 * @author laozhang
 * @date 2021/06/16
 */
@EqualsAndHashCode(callSuper = false)
@EntityDoc(note = "用户模块菜单关系表", isClass = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("RoleModulePermission")
public class RoleModulePermission extends BaseEntity {

    @EntityDoc(note = "RoleId")
    @TableField("RoleId")
    private Integer RoleId;

    @EntityDoc(note = "ModuleId")
    @TableField("ModuleId")
    private Integer ModuleId;

    @EntityDoc(note = "PermissionId")
    @TableField("PermissionId")
    private Integer PermissionId;

}
