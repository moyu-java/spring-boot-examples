package com.junmoyu.example.restful.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一返回数据结构
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
@NoArgsConstructor
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -7542992242245664910L;

    public static final int SUCCESS = 0;

    public static final int ERROR = 500;

    public static final String SUCCESS_MESSAGE = "success";

    public static final String FAILED_MESSAGE = "failed";

    private Integer code;
    private String message;
    private T data;

    /**
     * Instantiates a new response.
     *
     * @param code    the code
     * @param message the message
     * @param data    result data
     */
    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * return success.
     *
     * @param <T> the data class
     * @return {@link Response}
     */
    public static <T> Response<T> success() {
        return success(null);
    }

    /**
     * return success.
     *
     * @param data result data
     * @param <T>  the data class
     * @return {@link Response}
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(SUCCESS, SUCCESS_MESSAGE, data);
    }

    /**
     * return failure.
     *
     * @param <T> the data class
     * @return {@link Response}
     */
    public static <T> Response<T> failure() {
        return failure(ERROR, FAILED_MESSAGE);
    }

    /**
     * return failure.
     *
     * @param message error message
     * @param <T>     the data class
     * @return {@link Response}
     */
    public static <T> Response<T> failure(String message) {
        return failure(ERROR, message);
    }

    /**
     * return failure.
     *
     * @param code    error code
     * @param message error message
     * @param <T>     the data class
     * @return {@link Response}
     */
    public static <T> Response<T> failure(Integer code, String message) {
        return failure(code, message, null);
    }

    /**
     * return failure.
     *
     * @param message error message
     * @param data    result data
     * @param <T>     the data class
     * @return {@link Response}
     */
    public static <T> Response<T> failure(String message, T data) {
        return failure(ERROR, message, data);
    }

    /**
     * return failure.
     *
     * @param code    error code
     * @param message error message
     * @param data    result data
     * @param <T>     the data class
     * @return {@link Response}
     */
    public static <T> Response<T> failure(Integer code, String message, T data) {
        return new Response<>(code, message, data);
    }
}
