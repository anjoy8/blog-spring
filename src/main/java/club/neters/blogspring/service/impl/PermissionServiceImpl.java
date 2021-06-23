package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Permission;
import club.neters.blogspring.mapper.primary.PermissionMapper;
import club.neters.blogspring.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laozhang
 * @since 2021-06-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
