package com.jaymie.version1;

import com.jaymie.Level;
import com.jaymie.appender.ConsoleAppender;
import com.jaymie.logger.Logger;
import com.jaymie.logger.SimpleLogger;

/**
 * 测试是否只输出某个日志级别以上的日志
 */
public class LevelTest {
    public static final SimpleLogger DEFAULT_LOGGER = new SimpleLogger(LevelTest.class.getName(), new ConsoleAppender());
    public static final SimpleLogger INFO_LOGGER = new SimpleLogger(LevelTest.class.getName(), new ConsoleAppender(), Level.INFO);

    public static void main(String[] args) {
        loggerPrint(DEFAULT_LOGGER);
        System.out.println("===============");
        // 只会输出 info 级别以上的 日志
        loggerPrint(INFO_LOGGER);
    }

    private static void loggerPrint(Logger logger) {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
