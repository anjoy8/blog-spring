package club.neters.blogspring.model.entity.bs;

import club.neters.blogspring.core.annotation.EntityDoc;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author laozhang
 * @date 2021/06/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    /**
     * 主键 唯一标识
     * mybatis-plus自动生成UUID格式id
     */
    @EntityDoc(note = "主键")
    @TableId(type = IdType.ASSIGN_UUID)
    protected String code;

    /**
     * 是否有效
     */
    @EntityDoc(note = "是否有效")
    @TableField(fill = FieldFill.INSERT)
    protected Integer valid;

    /**
     * 创建时间
     */
    @EntityDoc(note = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    protected Date createTime;

    /**
     * 更新时间
     */
    @EntityDoc(note = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date updateTime;

}
