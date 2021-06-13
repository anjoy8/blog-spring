package club.neters.blogspring.service;

import club.neters.blogspring.model.dto.ResponseBean;
import club.neters.blogspring.model.dto.UserInfoDto;
import club.neters.blogspring.model.entity.bs.UserInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户信息 Service 接口
 *
 * @author laozhang
 * @date 2021/06/12
 */
public interface IUserInfoService extends IService<UserInfoEntity> {
    /**
     * 查询列表
     *
     * @param bean
     * @return
     */
    ResponseBean findList(UserInfoDto bean);
}
