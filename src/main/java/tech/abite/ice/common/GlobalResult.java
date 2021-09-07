package tech.abite.ice.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import tech.abite.ice.common.enums.Response;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResult<T> {
    private int status;
    private String message;
    private T data;

    public GlobalResult() {
    }

    public GlobalResult(int status) {
        this.status = status;
    }

    public GlobalResult(int status, String msg) {
        this(status);
        this.message = msg;
    }

    public GlobalResult(int status, String msg, T data) {
        this(status, msg);
        this.data = data;
    }

    public static GlobalResult success() {
        return new GlobalResult(Response.SUCCESS.getStatus(), Response.SUCCESS.getMsg());
    }

    public static <T> GlobalResult<T> success(T data) {
        return new GlobalResult(Response.SUCCESS.getStatus(), Response.SUCCESS.getMsg(), data);
    }

    public static GlobalResult fail() {
        return new GlobalResult(Response.FAIL.getStatus(), Response.FAIL.getMsg());
    }

    public static <T> GlobalResult fail(T data) {
        return new GlobalResult(Response.FAIL.getStatus(), Response.FAIL.getMsg(), data);
    }

    public static GlobalResult error() {
        return new GlobalResult(Response.ERROR.getStatus(), Response.ERROR.getMsg());
    }

    public static <T> GlobalResult error(T data) {
        return new GlobalResult(Response.ERROR.getStatus(), Response.ERROR.getMsg(), data);
    }
}
