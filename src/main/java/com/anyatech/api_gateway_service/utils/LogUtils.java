package com.anyatech.api_gateway_service.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryContext;

@Slf4j
public class LogUtils {

    public static void logWarnOnRetry(RetryContext context){

        if(context.getRetryCount() == 0) {
            return;
        }

        log.warn("retrying again", context.getRetryCount(),context.getLastThrowable());


    }

}
