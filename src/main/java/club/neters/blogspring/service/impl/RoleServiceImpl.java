package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Role;
import club.neters.blogspring.mapper.RoleMapper;
import club.neters.blogspring.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laozhang
 * @since 2021-06-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
