package tech.abite.ice.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TAsmMethod implements Serializable {
    private Long asmMethodId;

    private Long projectId;

    private String asmMethodName;

    private Long asmObjId;

    private String asmObjName;

    private Integer isStatic;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}