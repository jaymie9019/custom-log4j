package com.jaymie.logger;

import com.jaymie.Level;
import com.jaymie.LoggingEvent;
import com.jaymie.appender.Appender;

/**
 * @author xiaoma
 */
public class SimpleLogger implements Logger {
    private final String name;

    private final Appender appender;

    /**
     * 当前 logger 的级别，默认最低级别
     */
    private Level level = Level.TRACE;

    public SimpleLogger(String name, Appender appender) {
        this.name = name;
        this.appender = appender;
    }

    public SimpleLogger(String name, Appender appender, Level level) {
        this.name = name;
        this.appender = appender;
        this.level = level;
        this.effectiveLevelInt = level.getLevelInt();
    }

    /**
     * 冗余字段，方便使用
     */
    private int effectiveLevelInt;

    @Override
    public void trace(String msg) {
        filterAndLog(Level.TRACE, msg);
    }

    @Override
    public void info(String msg) {
        filterAndLog(Level.INFO, msg);
    }

    @Override
    public void debug(String msg) {
        filterAndLog(Level.DEBUG, msg);
    }

    @Override
    public void warn(String msg) {
        filterAndLog(Level.WARN, msg);
    }

    @Override
    public void error(String msg) {
        filterAndLog(Level.ERROR, msg);
    }

    @Override
    public String getName() {
        return this.name;
    }


    /**
     * 过滤并输出，所有输出方法都调用这个
     * @param level 日志级别
     * @param msg 输出内容
     */
    private void filterAndLog(Level level, String msg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[3];
        // 目标日志级别大于当前级别才输出
        if( level.toInt() > effectiveLevelInt ) {
            appender.append(new LoggingEvent(level, msg, name, stackTraceElement));
        }
    }
}
