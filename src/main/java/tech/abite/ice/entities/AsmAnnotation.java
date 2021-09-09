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
@TableName("t_asm_annotation")
@ApiModel(value = "AsmAnnotation对象", description = "")
public class AsmAnnotation implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "asm_anno_id", type = IdType.AUTO)
    private Long asmAnnoId;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "注解的名字")
    @TableField("asm_annotation_name")
    private String asmAnnotationName;

    @ApiModelProperty(value = "key值")
    @TableField("asm_annotation_key")
    private String asmAnnotationKey;

    @ApiModelProperty(value = "value值")
    @TableField("asm_annotation_value")
    private String asmAnnotationValue;

    @ApiModelProperty(value = "是否为uri 路径 0不是路径， 1是路径")
    @TableField("is_path")
    private Integer isPath;

    @ApiModelProperty(value = "0 是方法， 1是类 2是 字段")
    @TableField("asm_annotation_type")
    private Integer asmAnnotationType;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time")
    private LocalDateTime updatedTime;


}
