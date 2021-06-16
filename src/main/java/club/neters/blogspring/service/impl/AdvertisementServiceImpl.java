package club.neters.blogspring.service.impl;

import club.neters.blogspring.model.entity.bs.Advertisement;
import club.neters.blogspring.mapper.AdvertisementMapper;
import club.neters.blogspring.service.IAdvertisementService;
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
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements IAdvertisementService {

}
