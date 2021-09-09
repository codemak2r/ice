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
@TableName("t_asm_method_anno")
@ApiModel(value = "AsmMethodAnno对象", description = "")
public class AsmMethodAnno implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "asm_method_anno_id", type = IdType.AUTO)
    private Long asmMethodAnnoId;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "类 ID")
    @TableField("asm_method_id")
    private Long asmMethodId;

    @ApiModelProperty(value = "注释ID")
    @TableField("asm_anno_id")
    private Long asmAnnoId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
