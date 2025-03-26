package com.kiev.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiev.dtos.SnsNotification;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SqsListenerService {

    private final ObjectMapper objectMapper;

    @SqsListener("${aws.sqs.queue-name}")
    public void receiveMessage(String message) {
        try {
            var payload = objectMapper.readValue(message, SnsNotification.class);
            var anotherPayloadDto = payload.message();
            System.out.println(anotherPayloadDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
