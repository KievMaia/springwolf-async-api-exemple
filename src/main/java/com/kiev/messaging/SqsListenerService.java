package com.kiev.messaging;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiev.dtos.AnotherPayloadDto;
import com.kiev.dtos.SnsNotification;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.github.springwolf.bindings.sns.annotations.SnsAsyncOperationBinding;
import io.github.springwolf.bindings.sns.annotations.SnsAsyncOperationBindingIdentifier;
import io.github.springwolf.core.asyncapi.annotations.AsyncListener;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.Message;

@Component
@RequiredArgsConstructor
@Slf4j
public class SqsListenerService {

    private final ObjectMapper objectMapper;

    @AsyncListener(operation = @AsyncOperation(channelName = "meu-topico", description = "Tópico criado para exemplo de recebimento de mensagem"))
    @SnsAsyncOperationBinding(protocol = "sqs", endpoint = @SnsAsyncOperationBindingIdentifier(arn = "arn:aws:sns:us-east-1:000000000000:meu-topico"))
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
