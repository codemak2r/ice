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
@TableName("t_asm_obj")
@ApiModel(value = "AsmObj对象", description = "")
public class AsmObj implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "asm_obj_id", type = IdType.ASSIGN_ID)
    private Long asmObjId;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "是否是controller类， 0 不是，1 是")
    @TableField("is_cotroller")
    private Integer isCotroller;

    @ApiModelProperty(value = "类名")
    @TableField("asm_obj_name")
    private String asmObjName;

    @ApiModelProperty(value = "类名全路径")
    @TableField("asm_obj_fullname")
    private String asmObjFullname;

    @ApiModelProperty(value = "class 类文件路径")
    @TableField("asm_obj_file_path")
    private String asmObjFilePath;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
