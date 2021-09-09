package tech.abite.ice.entities;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("t_asm_obj_mapping")
@ApiModel(value = "AsmObjMapping对象", description = "")
public class AsmObjMapping implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "t_asm_obj_mapping_id", type = IdType.AUTO)
    private Long tAsmObjMappingId;

    @ApiModelProperty(value = "类ID")
    @TableField("t_left_obj_id")
    private Long tLeftObjId;

    @ApiModelProperty(value = "类ID")
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private Long tRightObjId;


}
