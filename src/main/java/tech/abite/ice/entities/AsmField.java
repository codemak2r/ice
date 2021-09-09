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
@TableName("t_asm_field")
@ApiModel(value = "AsmField对象", description = "")
public class AsmField implements Serializable {


    @ApiModelProperty(value = "字段ID")
    @TableId(value = "asm_field_id", type = IdType.AUTO)
    private Long asmFieldId;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "记录这个字段属于哪个类")
    @TableField("asm_obj_id")
    private Long asmObjId;

    @ApiModelProperty(value = "字段名")
    @TableField("asm_field_name")
    private String asmFieldName;

    @ApiModelProperty(value = "是否是静态变量")
    @TableField("is_static")
    private Integer isStatic;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
