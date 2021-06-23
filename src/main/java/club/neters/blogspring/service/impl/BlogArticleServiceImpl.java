package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.BlogArticle;
import club.neters.blogspring.mapper.primary.BlogArticleMapper;
import club.neters.blogspring.service.IBlogArticleService;
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
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {

}
