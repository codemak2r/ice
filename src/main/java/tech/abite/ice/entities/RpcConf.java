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
@TableName("t_rpc_conf")
@ApiModel(value = "RpcConf对象", description = "")
public class RpcConf implements Serializable {


    @ApiModelProperty(value = "ID")
    @TableId(value = "t_rpc_conf_id", type = IdType.AUTO)
    private Long tRpcConfId;

    @ApiModelProperty(value = "rpc 配置名称")
    @TableField("t_rpc_conf_name")
    private String tRpcConfName;

    @ApiModelProperty(value = "项目")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "应用名称")
    @TableField("application_name")
    private String applicationName;

    @ApiModelProperty(value = "zk地址")
    @TableField("zk_address")
    private String zkAddress;

    @ApiModelProperty(value = "版本")
    @TableField("reference_version")
    private String referenceVersion;

    @ApiModelProperty(value = "组别")
    @TableField("reference_group")
    private String referenceGroup;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
