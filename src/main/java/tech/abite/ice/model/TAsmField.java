package tech.abite.ice.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TAsmField implements Serializable {
    private Long asmFieldId;

    private Long projectId;

    private Long asmObjId;

    private String asmObjName;

    private String asmFieldName;

    private Integer isStatic;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}