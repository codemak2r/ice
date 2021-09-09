package tech.abite.ice.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TAsmAnnotation implements Serializable {
    private Long asmAnnoId;

    private Long projectId;

    private Long asmObjId;

    private String asmObjName;

    private String asmMethodType;

    private String asmPath;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}