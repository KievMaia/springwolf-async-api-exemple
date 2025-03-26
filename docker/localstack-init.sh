#!/bin/sh

# Criar tópico SNS
aws --endpoint-url=http://localhost:4566 sns create-topic --name meu-topico

# Criar fila SQS
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name minha-fila

# Obter ARN da fila
QUEUE_ARN=$(aws --endpoint-url=http://localhost:4566 sqs get-queue-attributes --queue-url http://localhost:4566/000000000000/minha-fila --attribute-names QueueArn --query "Attributes.QueueArn" --output text)

# Criar assinatura SNS para enviar mensagens à fila SQS
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:meu-topico --protocol sqs --notification-endpoint "$QUEUE_ARN"