package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Module;
import club.neters.blogspring.mapper.primary.ModuleMapper;
import club.neters.blogspring.service.IModuleService;
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
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

}
