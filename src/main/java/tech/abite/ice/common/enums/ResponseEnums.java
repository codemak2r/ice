package tech.abite.ice.common.enums;

import lombok.Getter;

@Getter
public enum ResponseEnums {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),
    ERROR(500, "error");

    private final int status;
    private final String msg;

    ResponseEnums(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
