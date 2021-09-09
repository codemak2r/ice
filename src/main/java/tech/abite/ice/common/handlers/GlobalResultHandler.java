package tech.abite.ice.common.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import tech.abite.ice.common.enums.ResponseEnums;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResultHandler<T> {
    private int status;
    private String message;
    private T data;

    public GlobalResultHandler() {
    }

    public GlobalResultHandler(int status) {
        this.status = status;
    }

    public GlobalResultHandler(int status, String msg) {
        this(status);
        this.message = msg;
    }

    public GlobalResultHandler(int status, String msg, T data) {
        this(status, msg);
        this.data = data;
    }

    public static GlobalResultHandler success() {
        return new GlobalResultHandler(ResponseEnums.SUCCESS.getStatus(), ResponseEnums.SUCCESS.getMsg());
    }

    public static <T> GlobalResultHandler<T> success(T data) {
        return new GlobalResultHandler(ResponseEnums.SUCCESS.getStatus(), ResponseEnums.SUCCESS.getMsg(), data);
    }

    public static GlobalResultHandler fail() {
        return new GlobalResultHandler(ResponseEnums.FAIL.getStatus(), ResponseEnums.FAIL.getMsg());
    }

    public static <T> GlobalResultHandler fail(T data) {
        return new GlobalResultHandler(ResponseEnums.FAIL.getStatus(), ResponseEnums.FAIL.getMsg(), data);
    }

    public static GlobalResultHandler error() {
        return new GlobalResultHandler(ResponseEnums.ERROR.getStatus(), ResponseEnums.ERROR.getMsg());
    }

    public static <T> GlobalResultHandler error(T data) {
        return new GlobalResultHandler(ResponseEnums.ERROR.getStatus(), ResponseEnums.ERROR.getMsg(), data);
    }
}
