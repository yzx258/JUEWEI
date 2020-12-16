package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：用户表 的实体类
 * @date ： 2020-12-16 18:28:14
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_configuration_user")
public class JwConfigurationUser extends Model<JwConfigurationUser> {

private static final long serialVersionUID=1L;

@ApiModelProperty("主ID")
@TableId(value = "id", type = IdType.ASSIGN_UUID)
private String id;


                            
    
                    
    
        
        /**
         * 创建人 创建人
         */
        @ApiModelProperty("创建人 创建人")
        @TableField(fill = FieldFill.INSERT)
        private String createBy;

        

    
                    
    
        
        /**
         * 创建时间 创建时间
         */
        @ApiModelProperty("创建时间 创建时间")
        @TableField(fill = FieldFill.INSERT)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createTime;

        

    
                    
    
        
        /**
         * 更新人 更新人
         */
        @ApiModelProperty("更新人 更新人")
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private String lastModifiedBy;

        

    
                    
    
        
        /**
         * 更新时间 更新时间
         */
        @ApiModelProperty("更新时间 更新时间")
        @TableField(fill = FieldFill.INSERT_UPDATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date updateTime;

        

    
                    
    
        
        /**
         * 门店ID
         */
        @ApiModelProperty("门店ID")
        private String shopId;
        

    
                    
    
        
        /**
         * 用户名称 用户名称
         */
        @ApiModelProperty("用户名称 用户名称")
        private String userName;
        

    
                    
    
        
        /**
         * 联系电话 联系电话
         */
        @ApiModelProperty("联系电话 联系电话")
        private String userMobile;
        

    
                    
    
        
        /**
         * 用户编号 用户编号
         */
        @ApiModelProperty("用户编号 用户编号")
        private String userNo;
        

    
                    
    
        
        /**
         * 用户账号
         */
        @ApiModelProperty("用户账号")
        private String userAccount;
        

    
                    
    
        
        /**
         * 用户密码 用户密码
         */
        @ApiModelProperty("用户密码 用户密码")
        private String userPwd;
        

    
                    
    
        
        /**
         * 是否删除 是否删除
         */
        @ApiModelProperty("是否删除 是否删除")
        private int isDel;
        

    }
