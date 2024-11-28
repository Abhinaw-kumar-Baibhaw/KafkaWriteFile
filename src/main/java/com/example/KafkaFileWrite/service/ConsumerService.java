package com.example.KafkaFileWrite.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class ConsumerService {


    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    private static final String LOG_FILE = "C:\\Users\\abhin\\OneDrive\\Desktop\\Kafka.txt";
    
    @KafkaListener(topics = "logs-topic", groupId = "log-consumer-group")
    public void consumeLog(String message) {
        logger.info("Consumed log: {}", message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Error writing to log file", e);
        }
    }
}

