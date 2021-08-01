package org.zwhy.swag.blog.vo.common;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 17:07
 */
public class ResponseResult<T> {

    private Boolean success;

    private String message;

    private T result;


    public ResponseResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
        this.result = null;
    }



    public ResponseResult(Boolean success, T result) {
        this.success = success;
        this.result = result;
        this.message = "";
    }

    public ResponseResult(Boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public static <T> ResponseResult<T> getDefaultSuccessResponse(T result) {
        return new ResponseResult<T>(true, "success", result);
    }

    public static <T> ResponseResult<T> getDefaultFailureResponse(T result) {
        return new ResponseResult<T>(false, "failure", result);
    }

    public static ResponseResult getNoObjectResponseByResult(Boolean success) {
        if (success) {
            return new ResponseResult<> (success, "success");
        }
        return new ResponseResult<> (success, "failure");
    }

    public static <T> ResponseResult<T> getObjectResponseByResult(Boolean success, T object) {
        if (success) {
            return getDefaultSuccessResponse(object);
        }
        return getDefaultFailureResponse(object);
    }
}
