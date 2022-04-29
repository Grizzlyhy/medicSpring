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
@ApiModel(value="CaseImage对象", description="")
public class CaseImage implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    @ApiModelProperty(value = "案例id")
    @TableField("case_id")
    private Integer caseId;

    @ApiModelProperty(value = "案例名称")
    @TableField("case_name")
    private String caseName;

    @ApiModelProperty(value = "原始图片存放url")
    @TableField("original_image_url")
    private String originalImageUrl;

    @ApiModelProperty(value = "结果图片存放url")
    @TableField("result_image_url")
    private String resultImageUrl;

    @ApiModelProperty(value = "使用的算法id")
    @TableField("algorithm_id")
    private Integer algorithmId;

    @ApiModelProperty(value = "使用的模型id")
    @TableField("model_id")
    private Integer modelId;

    @ApiModelProperty(value = "上传人")
    @TableField("user_id")
    private Integer userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Integer createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("deleted")
    private LocalDateTime deleted;


    public static final String CASE_ID = "case_id";

    public static final String CASE_NAME = "case_name";

    public static final String ORIGINAL_IMAGE_URL = "original_image_url";

    public static final String RESULT_IMAGE_URL = "result_image_url";

    public static final String ALGORITHM_ID = "algorithm_id";

    public static final String MODEL_ID = "model_id";

    public static final String USER_ID = "user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED = "deleted";

}
