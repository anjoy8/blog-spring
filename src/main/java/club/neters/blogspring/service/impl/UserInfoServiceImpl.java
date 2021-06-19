package club.neters.blogspring.service.impl;

import club.neters.blogspring.mapper.UserInfoMapper;
import club.neters.blogspring.model.entity.bs.SysUserInfo;
import club.neters.blogspring.model.query.user.UserInfoQuery;
import club.neters.blogspring.model.vo.user.UserInfoVo;
import club.neters.blogspring.service.IUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserInfoVo> findList(UserInfoQuery query) {
        LambdaQueryWrapper<SysUserInfo> wrapper = createWrapper(query);

        // 数据处理
        List<SysUserInfo> list = userInfoMapper.selectList(wrapper);

        return list.stream().map(v -> {
            UserInfoVo item = new UserInfoVo();
            BeanUtils.copyProperties(v, item);
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public SysUserInfo findOne(String name, String pass) {
        LambdaQueryWrapper<SysUserInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUserInfo::getTdIsDelete, 0)
                .eq(SysUserInfo::getULoginName, name)
                .eq(SysUserInfo::getULoginPWD, pass.toUpperCase());
        return userInfoMapper.selectOne(wrapper);
    }

    /**
     * 整理查询条件
     *
     * @param query 入参
     */
    private LambdaQueryWrapper<SysUserInfo> createWrapper(UserInfoQuery query) {

        LambdaQueryWrapper<SysUserInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUserInfo::getTdIsDelete, 0);

        // 自定义条件
        if (query != null) {

            if (!ObjectUtils.isEmpty(query.getUID())) {
                wrapper.eq(SysUserInfo::getUID, query.getUID());
            }

            if (!ObjectUtils.isEmpty(query.getName())) {
                wrapper.like(SysUserInfo::getName, query.getName());
            }

            if (StringUtils.isNotBlank(query.getULoginName())) {
                wrapper.eq(SysUserInfo::getULoginName, query.getULoginName());
            }

            if (StringUtils.isNotBlank(query.getURealName())) {
                wrapper.eq(SysUserInfo::getURealName, query.getURealName());
            }

        }

        return wrapper;
    }
}
