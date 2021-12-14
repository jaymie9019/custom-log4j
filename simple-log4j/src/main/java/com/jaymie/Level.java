package com.jaymie;

import lombok.Getter;

/**
 * 日志级别
 * ERROR > WARN > INFO > DEBUG > TRACE
 * @author xiaoma
 */
@Getter
public enum Level {
    /**
     * error级别
     */
    ERROR(40000, "ERROR"),
    WARN(30000, "WARN"),
    INFO(20000, "INFO"),
    DEBUG(10000, "DEBUG"),
    TRACE(5000, "TRACE");

    private final int levelInt;
    private final String levelStr;

    Level(int i, String s) {
        levelInt = i;
        levelStr = s;
    }

    public static Level parse(String level) {
        return valueOf(level.toUpperCase());
    }

    public int toInt() {
        return levelInt;
    }

    @Override
    public String toString() {
        return levelStr;
    }

    public boolean isGreaterOrEqual(Level level) {
        return levelInt>=level.toInt();
    }

}