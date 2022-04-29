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
@ApiModel(value="Dataset对象", description="")

public class Dataset implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    @ApiModelProperty(value = "数据集的唯一id")
    @TableField("dataset_id")
    private Integer datasetId;

    @ApiModelProperty(value = "数据集名称")
    @TableField("dataset_name")
    private String datasetName;
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "数据集存放url")
    @TableField("dataset_url")
    private String datasetUrl;

    @ApiModelProperty(value = "数据集下载链接")
    @TableField("dataset_link")
    private String datasetLink;

    @ApiModelProperty(value = "数据集背景介绍")
    @TableField("dataset_background")
    private String datasetBackground;

    @ApiModelProperty(value = "数据集关键字")
    @TableField("dataset_keyword")
    private String datasetKeyword;

    @ApiModelProperty(value = "数据集用途")
    @TableField("dataset_usage")
    private String datasetUsage;
    @ApiModelProperty(value = "数据集文件类型")
    @TableField("file_type")
    private String datasetType;

    @ApiModelProperty(value = "数据集属性数")
    @TableField("dataset_attribute_count")
    private Integer datasetAttributeCount;

    @ApiModelProperty(value = "数据集实例数")
    @TableField("dataset_instance_count")
    private Integer datasetInstanceCount;

    @ApiModelProperty(value = "数据集是否值缺失")
    @TableField("dataset_value_missing")
    private Boolean datasetValueMissing;

    @ApiModelProperty(value = "数据集相关任务")
    @TableField("dataset_task")
    private String datasetTask;

    @ApiModelProperty(value = "数据集的点击量")
    @TableField("click_count")
    private Integer clickCount;

    @ApiModelProperty(value = "数据集的下载量")
    @TableField("download_count")
    private Integer downloadCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据集创建时间，到2038年")
    @TableField("create_time")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("deleted")
    private Boolean deleted;


    public static final String DATASET_ID = "dataset_id";

    public static final String DATASET_NAME = "dataset_name";

    public static final String DATASET_URL = "dataset_url";

    public static final String DATASET_LINK = "dataset_link";

    public static final String DATASET_BACKGROUND = "dataset_background";

    public static final String DATASET_KEYWORD = "dataset_keyword";
    public static final String DATASET_USUAGE = "dataset_ususge";
    public static final String FILE_TYPE = "file_type";

    public static final String DATASET_ATTRIBUTE_COUNT = "dataset_attribute_count";

    public static final String DATASET_INSTANCE_COUNT = "dataset_instance_count";

    public static final String DATASET_VALUE_MISSING = "dataset_value_missing";

    public static final String DATASET_TASK = "dataset_task";

    public static final String CLICK_COUNT = "click_count";

    public static final String DOWNLOAD_COUNT = "download_count";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED = "deleted";

}
