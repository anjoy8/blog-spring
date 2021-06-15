package club.neters.blogspring.service.impl;

import club.neters.blogspring.mapper.UserInfoMapper;
import club.neters.blogspring.model.dto.ResponseBean;
import club.neters.blogspring.model.dto.UserInfoDto;
import club.neters.blogspring.model.entity.bs.SysUserInfo;
import club.neters.blogspring.service.IUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息 Service 实现类
 *
 * @author laozhang
 * @date 2021/06/12
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, SysUserInfo> implements IUserInfoService {


    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public ResponseBean<List<UserInfoDto>> findList(UserInfoDto bean) {
        LambdaQueryWrapper<SysUserInfo> wrapper = createWrapper(bean);

        // 数据处理
        List<SysUserInfo> list = userInfoMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return ResponseBean.ok(new ArrayList<>());
        }
        List<UserInfoDto> restList = new ArrayList<>();
        list.forEach(v -> {
            UserInfoDto item = new UserInfoDto();
            BeanUtils.copyProperties(v, item);
            restList.add(item);
        });
        return ResponseBean.ok(restList);
    }

    /**
     * 整理查询条件
     *
     * @param bean 入参
     */
    private LambdaQueryWrapper<SysUserInfo> createWrapper(UserInfoDto bean) {

        LambdaQueryWrapper<SysUserInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUserInfo::getTdIsDelete, 0);

        // 自定义条件
        if (bean != null) {

            if (!ObjectUtils.isEmpty(bean.getUID())) {
                wrapper.eq(SysUserInfo::getUID, bean.getUID());
            }

            if (!ObjectUtils.isEmpty(bean.getName())) {
                wrapper.like(SysUserInfo::getName, bean.getName());
            }

            if (StringUtils.isNotBlank(bean.getULoginName())) {
                wrapper.eq(SysUserInfo::getULoginName, bean.getULoginName());
            }

            if (StringUtils.isNotBlank(bean.getURealName())) {
                wrapper.eq(SysUserInfo::getURealName, bean.getURealName());
            }

        }

        return wrapper;
    }
}
