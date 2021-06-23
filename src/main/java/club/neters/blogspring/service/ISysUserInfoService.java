package club.neters.blogspring.service;

import club.neters.blogspring.model.entity.bs.SysUserInfo;
import club.neters.blogspring.model.query.user.UserInfoQuery;
import club.neters.blogspring.model.vo.user.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laozhang
 * @since 2021-06-23
 */
public interface ISysUserInfoService extends IService<SysUserInfo> {

    List<UserInfoVo> findList(UserInfoQuery query);

    SysUserInfo findOne(String name, String pass);
}
