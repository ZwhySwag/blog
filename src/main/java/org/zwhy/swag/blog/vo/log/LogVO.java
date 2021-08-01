package org.zwhy.swag.blog.vo.log;

import java.util.Arrays;

/**
 * @author ZWHySwag
 * @date 2021\7\26 0026 21:15
 */
public class LogVO {

    private String url;

    private String ip;

    private String method;

    private Object[] args;

    public LogVO(String url, String ip, String method, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.method = method;
        this.args = args;
    }

    @Override
    public String toString() {
        return "LogVO{" +
                "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
