package tech.abite.ice.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class TAsmObjMapping implements Serializable {
    private Long tAsmObjMappingId;

    private Long tControllerObjId;

    private Long tOtherObjId;

    private Long tOtherObjMethodId;

    private static final long serialVersionUID = 1L;
}