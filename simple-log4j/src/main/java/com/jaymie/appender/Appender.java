package com.jaymie.appender;

import com.jaymie.LoggingEvent;

/**
 * 日志输出器
 * 例如 console
 * 文件
 * email
 * mq
 * @author xiaoma
 */
public interface Appender {

    /**
     * 输出日志
     * @param loggingEvent 日志事件
     */
    void append(LoggingEvent loggingEvent);
}
