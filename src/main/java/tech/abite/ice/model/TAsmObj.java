package tech.abite.ice.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TAsmObj implements Serializable {
    private Long asmObjId;

    private Long projectId;

    private Integer isCotroller;

    private String asmObjName;

    private String asmObjFullname;

    private String asmObjFilePath;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}