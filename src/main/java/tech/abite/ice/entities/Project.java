package tech.abite.ice.entities;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author john
 * @since 2021-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_project")
@ApiModel(value = "Project对象", description = "")
public class Project implements Serializable {


    @ApiModelProperty(value = "项目ID")
    @TableId(value = "project_id", type = IdType.AUTO)
    private Long projectId;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "项目描述")
    @TableField("project_desc")
    private String projectDesc;

    @ApiModelProperty(value = "项目负责人")
    @TableField("project_owner")
    private String projectOwner;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
