package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Topic;
import club.neters.blogspring.mapper.primary.TopicMapper;
import club.neters.blogspring.service.ITopicService;
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
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

}
