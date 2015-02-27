package com.yammer.tenacity.core.logging;

import com.netflix.hystrix.HystrixInvokableInfo;

/**
 * The simplest exception logger out there, just logs any and every exception
 */
public class DefaultExceptionLogger extends ExceptionLogger<Exception> {

    @Override
    protected <T> void logException(Exception exception, HystrixInvokableInfo<T> commandInstance) {
        logger.warn("An exception occurred while executing {}:{}",
                commandInstance.getCommandKey().name(),
                commandInstance.getClass().getSimpleName(),
                exception);
    }
}
