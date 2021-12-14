package com.jaymie;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;


/**
 * @author xiaoma
 */
@Data
public class LoggingEvent {
    /**
     * 时间戳
     */
    public long timestamp;

    /**
     * 日志级别
     */
    private Level level;

    /**
     * 消息
     */
    private Object message;

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * 线程id
     */
    private long threadId;

    /**
     * 日志名称
     */
    private String loggerName;

    /**
     * 调用日志的类名
     */
    private String className;

    /**
     * 调用日志的方法名称
     */
    private String methodName;

    /**
     * 调用日志的行号
     */
    private int lineNum;

    public LoggingEvent() {
    }

    public LoggingEvent(Level level, Object message, String loggerName, StackTraceElement traceElement) {
        this.level = level;
        this.message = message;
        this.loggerName = loggerName;
        Thread currentThread = Thread.currentThread();
        this.threadId = currentThread.getId();
        this.threadName = currentThread.getName();
        this.timestamp = System.currentTimeMillis();

        // 类方法相关信息设置
        this.className = traceElement.getClassName();
        this.methodName = traceElement.getMethodName();
        this.lineNum = traceElement.getLineNumber();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // 当前时间
        DateTime date = DateUtil.date(timestamp);
        sb.append(DateUtil.formatDateTime(date)).append(" ");
        // 日志级别
        sb.append(level.getLevelStr()).append(" ");
        // 线程名称
        sb.append("[").append(this.threadName).append("]").append(" ");
        // 类名 + 方法名称 + 行号
        sb.append(this.className).append(".")
                .append(this.methodName).append("(").append(this.lineNum).append(")")
                .append(" - ");
        // 消息内容
        sb.append(message.toString()).append("\n");
        return sb.toString();
    }
}