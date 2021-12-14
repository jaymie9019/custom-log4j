package com.jaymie.version1;

import com.jaymie.appender.ConsoleAppender;
import com.jaymie.logger.SimpleLogger;

public class MessageTest {
    public static final SimpleLogger DEFAULT_LOGGER = new SimpleLogger(LevelTest.class.getName(), new ConsoleAppender());

    public static void main(String[] args) {
        // 看最后输出是不是 fun3 第 22 行
        fun1();
    }

    private static void fun1() {
        fun2();
    }

    private static void fun2() {
        fun3();
    }

    private static void fun3() {
        DEFAULT_LOGGER.info("hello world");
    }
}
