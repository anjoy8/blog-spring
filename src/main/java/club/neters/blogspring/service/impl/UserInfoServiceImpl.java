package club.neters.blogspring.service.impl;

import club.neters.blogspring.mapper.UserInfoMapper;
import club.neters.blogspring.model.dto.ResponseBean;
import club.neters.blogspring.model.dto.UserInfoDto;
import club.neters.blogspring.model.entity.bs.UserInfoEntity;
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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoService {


    private UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public ResponseBean<List<UserInfoDto>> findList(UserInfoDto bean) {
        LambdaQueryWrapper<UserInfoEntity> wrapper = createWrapper(bean);

        // 数据处理
        List<UserInfoEntity> list = userInfoMapper.selectList(wrapper);
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
     * @param bean
     * @return
     */
    private LambdaQueryWrapper createWrapper(UserInfoDto bean) {
        LambdaQueryWrapper<UserInfoEntity> wrapper = Wrappers.lambdaQuery();
        if (bean == null || bean.getValid() == null) {
            wrapper.eq(UserInfoEntity::getValid, 1);
        }

        // 自定义条件
        if (bean != null) {
            if (bean.getValid() != null) {
                wrapper.eq(UserInfoEntity::getValid, bean.getValid());
            }

            if (!ObjectUtils.isEmpty(bean.getCode())) {
                wrapper.eq(UserInfoEntity::getCode, bean.getCode());
            }

            if (!ObjectUtils.isEmpty(bean.getName())) {
                wrapper.like(UserInfoEntity::getName, bean.getName());
            }

            if (StringUtils.isNotBlank(bean.getAccount())) {
                wrapper.eq(UserInfoEntity::getAccount, bean.getAccount());
            }
            if (StringUtils.isNotBlank(bean.getPassword())) {
                wrapper.eq(UserInfoEntity::getPassword, bean.getPassword());
            }
            if (StringUtils.isNotBlank(bean.getStatus())) {
                wrapper.eq(UserInfoEntity::getStatus, bean.getStatus());
            }
            if (StringUtils.isNotBlank(bean.getApproveStatus())) {
                wrapper.eq(UserInfoEntity::getApproveStatus, bean.getApproveStatus());
            }
            if (StringUtils.isNotBlank(bean.getApproveResult())) {
                wrapper.eq(UserInfoEntity::getApproveResult, bean.getApproveResult());
            }
            if (CollectionUtils.isNotEmpty(bean.getUserCodeList())) {
                wrapper.in(UserInfoEntity::getCode, bean.getUserCodeList());
            }
        }

        return wrapper;
    }
}
