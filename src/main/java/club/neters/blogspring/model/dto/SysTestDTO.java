package club.neters.blogspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysTestDTO {
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

}
