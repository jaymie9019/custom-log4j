package com.jaymie.logger;

/**
 * @author xiaoma
 */
public interface Logger {
    /**
     * trace 级别
     * @param msg 内容
     */
    void trace(String msg);

    /**
     * debug 级别
     * @param msg 内容
     */
    void debug(String msg);

    /**
     * info 级别
     * @param msg 内容
     */
    void info(String msg);

    /**
     * warn 级别
     * @param msg 内容
     */
    void warn(String msg);

    /**
     * error 级别
     * @param msg 内容
     */
    void error(String msg);

    /**
     * 获取 logger 的名称
     * @return logger的名称
     */
    String getName();
}
