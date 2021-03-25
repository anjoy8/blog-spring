package club.neters.blogspring.model.dto;

import lombok.Data;

@Data
public class ResponseBean {
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
    private Object data;

    public static ResponseBean ok(Object data) {
        return ok(data, "success");
    }

    public static ResponseBean ok(Object data, String msg) {
        ResponseBean bean = new ResponseBean();
        bean.setData(data);
        bean.setCode(200);
        bean.setMessage(msg);
        return bean;
    }


    public static ResponseBean error(Object data) {
        return error(data, "服务器异常");
    }

    public static ResponseBean error(Object data, String msg) {
        ResponseBean bean = new ResponseBean();
        bean.setData(data);
        bean.setCode(500);
        bean.setMessage(msg);
        return bean;
    }


}
