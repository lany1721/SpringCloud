package cn.zpeace.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zpeace
 * @date 2020/12/24
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;

    private ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 请求成功，不携带响应数据
     */
    public static <T> ResultVO<T> success() {
        return success(null);
    }

    /**
     * 请求成功，携带响应数据
     */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(200, "success",data);
    }

    /**
     * 请求失败
     */
    public static <T> ResultVO<T> failure() {
        return new ResultVO<>(500,"failure",null);
    }
}
