package com.adarshr.gradle.testlogger.logger

import com.adarshr.gradle.testlogger.renderer.AnsiTextRenderer
import com.adarshr.gradle.testlogger.renderer.TextRenderer
import groovy.transform.CompileStatic
import org.gradle.api.logging.LogLevel
import org.gradle.api.logging.Logger

@CompileStatic
class ConsoleLogger {

    private final Logger logger
    private final LogLevel level
    private final TextRenderer renderer

    ConsoleLogger(Logger logger, TextRenderer renderer = new AnsiTextRenderer()) {
        this.logger = logger
        this.level = LogLevel.LIFECYCLE
        this.renderer = renderer
    }

    void log(String text) {
        if (text) {
            logger.log(level, renderer.render(text))
        }
    }

    void logNewLine() {
        logger.log(level, '')
    }
}
