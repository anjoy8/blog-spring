package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.OperateLog;
import club.neters.blogspring.mapper.OperateLogMapper;
import club.neters.blogspring.service.IOperateLogService;
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
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements IOperateLogService {

}
