package com.zhou.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoulixin
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BrowsingRecord对象", description="")
public class BrowsingRecord implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "请求用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "请求ip地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "浏览模块")
    @TableField("browse_module")
    private String browseModule;

    @ApiModelProperty(value = "操作动作")
    @TableField("operation_action")
    private String operationAction;

    @ApiModelProperty(value = "请求url")
    @TableField("page_url")
    private String pageUrl;

    @ApiModelProperty(value = "操作结果")
    @TableField("operation_result")
    private String operationResult;

    @ApiModelProperty(value = "请求时间")
    @TableField("operation_time")
    private LocalDateTime operationTime;

    @ApiModelProperty(value = "详情")
    @TableField("request_code")
    private String requestCode;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String IP = "ip";

    public static final String BROWSE_MODULE = "browse_module";

    public static final String OPERATION_ACTION = "operation_action";

    public static final String PAGE_URL = "page_url";

    public static final String OPERATION_RESULT = "operation_result";

    public static final String OPERATION_TIME = "operation_time";

    public static final String REQUEST_CODE = "request_code";

    public static final String REMARKS = "remarks";

}
