package club.neters.blogspring.model.dto;

import lombok.Data;

@Data
public class ResponseBean<T> {
    /**
     * 错误代码
     */
    private long code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> ResponseBean<T> ok(T data) {
        return ok(data, "success");
    }

    public static <T> ResponseBean<T> ok(T data, String msg) {
        ResponseBean<T> bean = new ResponseBean<>();
        bean.setData(data);
        bean.setCode(200);
        bean.setMessage(msg);
        return bean;
    }


    public static <T> ResponseBean<T> error(T data) {
        return error(data, "服务器异常");
    }

    public static <T> ResponseBean<T> error(T data, String msg) {
        ResponseBean<T> bean = new ResponseBean<>();
        bean.setData(data);
        bean.setCode(500);
        bean.setMessage(msg);
        return bean;
    }


}
