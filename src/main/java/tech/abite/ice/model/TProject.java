package tech.abite.ice.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TProject implements Serializable {
    private Long projectId;

    private String projectName;

    private String projectDesc;

    private String projectOwner;

    private Date createdTime;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}