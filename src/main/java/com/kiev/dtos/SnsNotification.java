package com.kiev.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record SnsNotification(
        @JsonProperty("Type") String type,
        @JsonProperty("MessageId") String messageId,
        @JsonProperty("TopicArn") String topicArn,
        @JsonProperty("Message") String message,
        @JsonProperty("Timestamp") String timestamp,
        @JsonProperty("UnsubscribedURL") String unsubscribedURL,
        @JsonProperty("MessageAttributes") Map<String, Object> messageAttributes,
        @JsonProperty("SignatureVersion") String signatureVersion,
        @JsonProperty("Signature") String signature,
        @JsonProperty("SigningCertURL") String signingCertURL
) {
}
