package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Guestbook;
import club.neters.blogspring.mapper.GuestbookMapper;
import club.neters.blogspring.service.IGuestbookService;
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
public class GuestbookServiceImpl extends ServiceImpl<GuestbookMapper, Guestbook> implements IGuestbookService {

}
