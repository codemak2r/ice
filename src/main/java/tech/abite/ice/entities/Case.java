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
@TableName("t_case")
@ApiModel(value = "Case对象", description = "")
public class Case implements Serializable {


    @ApiModelProperty(value = "测试用例ID")
    @TableId(value = "case_id", type = IdType.AUTO)
    private Long caseId;

    @ApiModelProperty(value = "用例名称")
    @TableField("case_name")
    private String caseName;

    @ApiModelProperty(value = "用例描述")
    @TableField("case_des")
    private String caseDes;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "维护人")
    @TableField("case_owner")
    private String caseOwner;

    @ApiModelProperty(value = "类型， 0 - 前端， 1- api 2 - rpc")
    @TableField("case_type")
    private Integer caseType;

    @ApiModelProperty(value = "是否有 前端 配置")
    @TableField("end_conf_id")
    private Long endConfId;

    @ApiModelProperty(value = "是否有 api 配置")
    @TableField("api_conf_id")
    private Long apiConfId;

    @ApiModelProperty(value = "是否有 rpc 配置")
    @TableField("rpc_conf_id")
    private Long rpcConfId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
