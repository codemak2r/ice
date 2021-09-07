package tech.abite.ice.common.enums;

import lombok.Getter;

@Getter
public enum Response {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),
    ERROR(500, "error");

    private final int status;
    private final String msg;

    Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
