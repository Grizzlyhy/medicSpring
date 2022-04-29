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
@ApiModel(value="Algorithm对象", description="")

public class Algorithm implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    @ApiModelProperty(value = "算法id")
    @TableField("algorithm_id")
    private Integer algorithmId;

    @ApiModelProperty(value = "算法名称")
    @TableField("algorithm_name")
    private String algorithmName;

    @ApiModelProperty(value = "算法存放URL")
    @TableField("algorithm_url")
    private String algorithmUrl;

    @ApiModelProperty(value = "算法背景介绍")
    @TableField("algorithm_background")
    private String algorithmBackground;

    @ApiModelProperty(value = "算法关键字")
    @TableField("algorithm_keyword")
    private String algorithmKeyword;

    @ApiModelProperty(value = "上传人")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "状态，是否通过审核，0未审核，1已审核，2未审核")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "点击量")
    @TableField("click_count")
    private Integer clickCount;
    @ApiModelProperty(value = "算法缺点")
    @TableField("algorithm_shortcoming")
    private String algorithmShortcoming;

    @ApiModelProperty(value = "算法优点")
    @TableField("algorithm_advantage")
    private String algorithmAdvantage;
    @ApiModelProperty(value = "算法代码类型")
    @TableField("code_type")
    private String codeType;

    @ApiModelProperty(value = "算法功能")
    @TableField("algorithm_function")
    private String algorithmFunction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = " 创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("deleted")
    private Integer deleted;


    public static final String ALGORITHM_ID = "algorithm_id";

    public static final String ALGORITHM_NAME = "algorithm_name";

    public static final String ALGORITHM_URL = "algorithm_url";

    public static final String ALGORITHM_BACKGROUND = "algorithm_background";

    public static final String ALGORITHM_KEYWORD = "algorithm_keyword";

    public static final String USER_ID = "user_id";

    public static final String STATUS = "status";

    public static final String CLICK_COUNT = "click_count";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED = "deleted";

}
