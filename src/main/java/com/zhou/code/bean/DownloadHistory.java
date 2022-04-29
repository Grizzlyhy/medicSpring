package com.zhou.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="DownloadHistory对象", description="")
public class DownloadHistory implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "download_history_id", type = IdType.AUTO)
    private Integer downloadHistoryId;

    @TableField("user_id")
    private Integer userId;

    @TableField("dataset_id")
    private Integer datasetId;

    @TableField("algorithm_id")
    private Integer algorithmId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("deleted")
    private Integer deleted;


    public static final String DOWNLOAD_HISTORY_ID = "download_history_id";

    public static final String USER_ID = "user_id";

    public static final String DATASET_ID = "dataset_id";

    public static final String ALGORITHM_ID = "algorithm_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED = "deleted";

}
