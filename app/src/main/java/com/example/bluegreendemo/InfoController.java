package com.example.bluegreendemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InfoController {

    // Set these as env vars per deployment (blue/green) so you can see
    // at a glance which version is answering traffic.
    @Value("${APP_COLOR:unknown}")
    private String color;

    @Value("${APP_VERSION:unknown}")
    private String version;

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Hello from bluegreen-demo");
        body.put("color", color);
        body.put("version", version);
        body.put("timestamp", Instant.now().toString());
        body.put("hostname", hostname());
        return body;
    }

    @GetMapping("/version")
    public Map<String, String> version() {
        Map<String, String> body = new LinkedHashMap<>();
        body.put("color", color);
        body.put("version", version);
        body.put("hostname", hostname());
        return body;
    }

    private String hostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "unknown";
        }
    }
}
