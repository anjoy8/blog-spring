package club.neters.blogspring.mapper;

import club.neters.blogspring.model.entity.bs.SysUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * user info mapper
 *
 * @author laozhang
 * @date 2021/06/12
 */
@Repository
public interface UserInfoMapper extends BaseMapper<SysUserInfo> {
}
