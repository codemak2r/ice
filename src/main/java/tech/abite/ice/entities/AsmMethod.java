package tech.abite.ice.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("t_asm_method")
@ApiModel(value = "AsmMethod对象", description = "")
public class AsmMethod implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "asm_method_id", type = IdType.AUTO)
    private Long asmMethodId;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "方法名")
    @TableField("asm_method_name")
    private String asmMethodName;

    @ApiModelProperty(value = "方法的参数, 0 为空， 1为基本类型， 2为复杂类型")
    @TableField("asm_method_param_type")
    private Integer asmMethodParamType;

    @ApiModelProperty(value = "参数名")
    @TableField("asm_method_param_name")
    private String asmMethodParamName;

    @ApiModelProperty(value = "返回值")
    @TableField("asm_method_return")
    private String asmMethodReturn;

    @ApiModelProperty(value = "记录这个方法属于哪个类")
    @TableField("asm_obj_id")
    private Long asmObjId;

    @ApiModelProperty(value = "是否是静态方法")
    @TableField("is_static")
    private Integer isStatic;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time")
    private LocalDateTime updatedTime;


}
