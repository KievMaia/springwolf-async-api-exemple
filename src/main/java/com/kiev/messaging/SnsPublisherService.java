package com.kiev.messaging;

import com.kiev.dtos.AnotherPayloadDto;
import io.github.springwolf.bindings.sns.annotations.SnsAsyncOperationBinding;
import io.github.springwolf.bindings.sns.annotations.SnsAsyncOperationBindingIdentifier;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import io.github.springwolf.core.asyncapi.annotations.AsyncPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class SnsPublisherService {

    private final SnsClient snsClient;

    public static final String TOPIC = "meu-topico";

    @AsyncPublisher(
            operation =
            @AsyncOperation(
                    channelName = TOPIC,
                    description = "Tópico criado para exemplo de publicação de mensagem"))
    @SnsAsyncOperationBinding(protocol = "sqs", endpoint = @SnsAsyncOperationBindingIdentifier(url = "http://localhost:4566/000000000000/minha-fila"))
    public String publishMessage(AnotherPayloadDto message) {
        log.info("Publishing message: {}", message);
        PublishRequest request = PublishRequest.builder()
                .topicArn(TOPIC)
                .message(String.valueOf(message))
                .build();
        PublishResponse response = snsClient.publish(request);
        return response.messageId();
    }
}
