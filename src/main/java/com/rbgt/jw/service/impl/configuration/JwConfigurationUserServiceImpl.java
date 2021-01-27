package com.rbgt.jw.service.impl.configuration;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.user.AddUserDTO;
import com.rbgt.jw.base.enums.user.PositionTypeEnum;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.configuration.JwConfigurationUserDao;
import com.rbgt.jw.entity.configuration.JwConfigurationRole;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.entity.configuration.JwConfigurationUserRole;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.base.enums.role.RoleConstantEnum;
import com.rbgt.jw.service.configuration.JwConfigurationRoleService;
import com.rbgt.jw.service.configuration.JwConfigurationUserRoleService;
import com.rbgt.jw.service.configuration.JwConfigurationUserService;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.configuration.JwConfigurationUserSpec;
import com.rbgt.jw.base.spec.user.AddUserSpec;
import com.rbgt.jw.base.spec.user.UpdateUserPwdSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-14 18:35:58
 * @description ：用户表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationUserServiceImpl extends ServiceImpl<JwConfigurationUserDao, JwConfigurationUser> implements JwConfigurationUserService {

    @Autowired
    private JwShopService jwShopService;
    @Autowired
    private JwConfigurationUserRoleService jwConfigurationUserRoleService;
    @Autowired
    private JwConfigurationRoleService jwConfigurationRoleService;

    @Override
    public List<JwConfigurationUser> queryAll() {
        return this.baseMapper.selectList(null);
    }

    /**
     * 新增用户信息
     * @param addUserSpec
     * @return
     */
    @Override
    public JwConfigurationUser add(AddUserSpec addUserSpec) {
        // 判断是否更新操作
        if(StrUtil.isNotBlank(addUserSpec.getId())){
            log.info("更新用户信息 -> {}", JSON.toJSONString(addUserSpec));
            JwConfigurationUser jwConfigurationUser = this.baseMapper.selectById(addUserSpec.getId());
            if(ObjectUtil.isNull(jwConfigurationUser)){
                throw new BaseException(ResponseCode.USER_NOT_ERROR);
            }
            BeanUtil.copyProperties(addUserSpec,jwConfigurationUser,true);
            jwConfigurationUser.insertOrUpdate();
            // 清空角色
            jwConfigurationUserRoleService.remove(Wrappers.lambdaQuery(JwConfigurationUserRole.class)
                    .eq(JwConfigurationUserRole::getUserId,jwConfigurationUser.getId()));
            // 新增角色信息
            List<JwConfigurationUserRole> list = new ArrayList<>();
            // 判断是否有权限
            setUserRole(jwConfigurationUser,addUserSpec,list);
            // 批量插入角色信息
            jwConfigurationUserRoleService.batchAdd(list);
            return jwConfigurationUser;
        }
        log.info("新增用户信息 -> {}", JSON.toJSONString(addUserSpec));
        // 判断用户编号是否存在
        QueryWrapper<JwConfigurationUser> qe = new QueryWrapper<>();
        qe.eq("user_no",addUserSpec.getUserNo()).eq("is_del",0);
        JwConfigurationUser jwConfigurationUser = this.baseMapper.selectOne(qe);
        if(ObjectUtil.isNotNull(jwConfigurationUser)){
            throw new BaseException(ResponseCode.USER_NOT_ERROR3);
        }
        // 判断登录账号
        qe.clear();
        qe.eq("user_account",addUserSpec.getUserAccount()).eq("is_del",0);
        jwConfigurationUser = this.baseMapper.selectOne(qe);
        if(ObjectUtil.isNotNull(jwConfigurationUser)){
            throw new BaseException(ResponseCode.USER_NOT_ERROR4);
        }
        // 判断门店是否存在
        if (ObjectUtil.isNull(jwShopService.getById(addUserSpec.getShopId()))) {
            throw new BaseException(ResponseCode.SHOP_NOT_ERROR);
        }
        jwConfigurationUser = new JwConfigurationUser();
        BeanUtil.copyProperties(addUserSpec, jwConfigurationUser, true);
        // 新增用户信息
        jwConfigurationUser.insert();
        // 新增角色信息
        List<JwConfigurationUserRole> list = new ArrayList<>();
        // 判断是否有权限
        setUserRole(jwConfigurationUser,addUserSpec,list);
        // 批量插入角色信息
        jwConfigurationUserRoleService.batchAdd(list);
        return jwConfigurationUser;
    }

    /**
     * 设置角色权限
     * @param jwConfigurationUser
     * @param addUserSpec
     * @param list
     */
    private void setUserRole(JwConfigurationUser jwConfigurationUser, AddUserSpec addUserSpec, List<JwConfigurationUserRole> list) {
        // 是否店长
        if (PositionTypeEnum.SHOP_MANAGER.equals(addUserSpec.getPositionType())) {
            // 店长
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_MANAGER.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }else if(PositionTypeEnum.SHOP_ASSISTANT.equals(addUserSpec.getPositionType())){
            // 店员
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_ASSISTANT.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }else if(PositionTypeEnum.ADMINISTRATOR.equals(addUserSpec.getPositionType())){
            // 区域管理员
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.ADMINISTRATOR.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsConfiguration()) {
            // 存在配置权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_CONFIGURATION.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsStock()) {
            // 存在进货权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_STOCK.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsCargo()) {
            // 存在调货权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_CARGO.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsCheck()) {
            // 存在核对权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_CHECK.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsInventory()) {
            // 存在盘点权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_INVENTORY.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsInventoryCheck()) {
            // 存在盘点复盘权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_INVENTORY_ANALYSE.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
        if (addUserSpec.getIsDaily()) {
            // 存在盘点复盘权
            JwConfigurationRole byRoleLabel = jwConfigurationRoleService.findByRoleLabel(RoleConstantEnum.SHOP_DATA_STATISTICS.getCode());
            if (ObjectUtil.isNotNull(byRoleLabel) && StrUtil.isNotBlank(byRoleLabel.getId())) {
                JwConfigurationUserRole rl = new JwConfigurationUserRole();
                rl.setRoleId(byRoleLabel.getId());
                rl.setUserId(jwConfigurationUser.getId());
                list.add(rl);
            }
        }
    }

    /**
     * 逻辑删除数据
     * @param userId
     * @return
     */
    @Override
    public JwConfigurationUser delete(String userId) {
        List<JwConfigurationUser> userIds = this.baseMapper.selectList(new QueryWrapper<JwConfigurationUser>().eq("user_id", userId));
        if (CollectionUtil.isNotEmpty(userIds)) {
            JwConfigurationUser jwConfigurationUser = userIds.get(0);
            jwConfigurationUser.setIsDel(1);
            jwConfigurationUser.insertOrUpdate();
            return jwConfigurationUser;
        }
        return null;
    }

    /**
     * 分页查询
     * @param spec
     * @return
     */
    @Override
    public IPage<JwConfigurationUserDTO> search(JwConfigurationUserSpec spec) {
        IPage<JwConfigurationUserDTO> search = this.baseMapper.search(spec, spec.getPage());
        return search;
    }

    /**
     * 修改用户明密码
     * @param updateUserPwdSpec
     * @return
     */
    @Override
    public JwConfigurationUser updateUserPwd(UpdateUserPwdSpec spec) {
        // 判断新旧密码是否一致
        if(spec.getNewUserPwd().equals(spec.getUserPwd())){
            throw new BaseException(ResponseCode.USER_NOT_ERROR2);
        }
        // 查询用户信息，是否存在该用户
        JwConfigurationUser byId = this.getById(spec.getUserId());
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 修改用户密码
            byId.setUserPwd(spec.getNewUserPwd());
            byId.insertOrUpdate();
        }
        return byId;
    }

    /**
     * 根据用户ID获取详情
     * @param id
     * @return
     */
    @Override
    public AddUserDTO details(String id) {
        AddUserDTO addUserDTO = new AddUserDTO();
        JwConfigurationUser jwConfigurationUser = this.baseMapper.selectById(id);
        // 拷贝数据
        BeanUtil.copyProperties(jwConfigurationUser,addUserDTO,true);
        // 设置角色信息
        if(PositionTypeEnum.SHOP_ASSISTANT.equals(jwConfigurationUser.getPositionType()) || PositionTypeEnum.SHOP_MANAGER.equals(jwConfigurationUser.getPositionType())){
            // 店员或店长
            addUserDTO.setIsStock(true);
            addUserDTO.setIsCargo(true);
            addUserDTO.setIsCheck(true);
            addUserDTO.setIsInventory(true);
            addUserDTO.setIsInventoryCheck(true);
            addUserDTO.setIsBreakage(true);
            addUserDTO.setIsDaily(true);
            addUserDTO.setIsData(true);
        }else if(PositionTypeEnum.ADMINISTRATOR.equals(jwConfigurationUser.getPositionType())){
            // 区域管理员
            addUserDTO.setIsConfiguration(true);
            addUserDTO.setIsStock(true);
            addUserDTO.setIsCargo(true);
            addUserDTO.setIsCheck(true);
            addUserDTO.setIsInventory(true);
            addUserDTO.setIsInventoryCheck(true);
            addUserDTO.setIsBreakage(true);
            addUserDTO.setIsDaily(true);
            addUserDTO.setIsData(true);
        }
        return addUserDTO;
    }
}

