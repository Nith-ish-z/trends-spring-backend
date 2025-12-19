package com.ecom.trends.config;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionStore {

    private final Map<String, Long> sessionMap = new ConcurrentHashMap<>();

    public void save(String token, Long userId) {
        sessionMap.put(token, userId);
    }

    public Long get(String token) {
        return sessionMap.get(token);
    }

    public void remove(String token) {
        sessionMap.remove(token);
    }
}
