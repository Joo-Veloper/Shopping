package io.core.global.web.service;

import io.core.global.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final ObjectProvider<MyLogger> myLoggerProvider;
    public void logic(String id) {
        myLoggerProvider.getObject();
        myLoggerProvider.getObject().log("service id = " + id);
    }
}
