package com.jaymie.appender;

import com.jaymie.LoggingEvent;
import com.jaymie.appender.Appender;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * 把日志输出在控制台
 * @author xiaoma
 */
public class ConsoleAppender implements Appender {
    /**
     * 标准输出
     */
    private final OutputStream out = System.out;
    /**
     * 错误输出
     */
    private final OutputStream outError = System.err;

    @Override
    public void append(LoggingEvent loggingEvent) {
       try {
           out.write(loggingEvent.toString().getBytes(StandardCharsets.UTF_8));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
