package com.example.KafkaFileWrite.controller;

import com.example.KafkaFileWrite.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {

    @Autowired
    private final ProducerService logProducerService;

    public LogController(ProducerService logProducerService) {
        this.logProducerService = logProducerService;
    }

    @GetMapping("/log")
    public String produceLog(@RequestParam String message) {
        logProducerService.sendLog(message);
        return "Log sent: " + message;
    }
}

