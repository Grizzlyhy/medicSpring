package com.zhou.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
@Getter
@Setter
public class User implements Serializable {
private static final long serialVersionUID=1L;
    @TableId
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;
    @ApiModelProperty(value = "用户账号")
    @TableField("user_account")
    private String userAccount;
    @ApiModelProperty(value = "用户密码")
    @TableField("user_pwd")
    private String userPwd;

    @ApiModelProperty(value = "用户角色")
    @TableField("user_role")
    private Integer userRole;

    @ApiModelProperty(value = "用户科室，根据科室推荐")
    @TableField("user_department")
    private String userDepartment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("deleted")
    private Boolean deleted;


    public static final String USER_ID = "user_id";

    public static final String USER_PWD = "user_pwd";

    public static final String USER_ROLE = "user_role";

    public static final String USER_DEPARTMENT = "user_department";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED = "deleted";

}
