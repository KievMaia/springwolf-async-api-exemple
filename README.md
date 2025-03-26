# 🚀 Springwolf - Async API Documentation

A documentação de APIs é essencial para qualquer projeto, mas pode ser trabalhosa quando feita manualmente. No ecossistema Spring Boot, temos ótimas soluções para gerar documentação automaticamente para APIs REST, como **Springfox** e **springdoc-openapi**.

Porém, até agora, não havia uma solução equivalente para **APIs assíncronas** (AMQP, JMS, Kafka, SNS, SQS, WebSockets, etc.). O **Springwolf** resolve esse problema, gerando automaticamente a documentação de APIs assíncronas construídas com Spring Boot.

O **Springwolf** é **compatível com AsyncAPI**, trazendo para arquiteturas **event-driven** a mesma padronização e praticidade que **Swagger/OpenAPI** trouxe para APIs REST.

---

## 🛠️ Como Executar

### 📌 Pré-requisitos
- **Docker** e **Docker Compose** instalados
- **Maven** instalado

### 🔥 Rodando o Projeto
1️⃣ Clone este repositório:
```
git clone https://github.com/KievMaia/springwolf-async-api-exemple.git
````
2️⃣ Navegue até a pasta docker:
```
cd docker
```
3️⃣ Inicie os serviços necessários com Docker Compose:
```
docker-compose up -d
```
4️⃣ Volte para a raiz do projeto e inicie a aplicação com Maven:
```
cd ..
mvn spring-boot:run
```
5️⃣ Acesse a documentação gerada automaticamente:

### 📜 UI Interativa: http://localhost:8080/springwolf/asyncapi-ui.html
<img src="https://github.com/user-attachments/assets/8ffb8ef5-fd04-46ff-8392-ceaff0809734" width="500">

### 📄 JSON da API: http://localhost:8080/springwolf/docs

### 🎯 O que este projeto demonstra?
✅ Como documentar eventos assíncronos no Spring Boot usando Springwolf

✅ Geração automática de documentação compatível com AsyncAPI

✅ Integração com SNS/SQS para comunicação assíncrona


<h2>Contribuição</h2>
Em caso de dúvidas, sinta-se a vontade a entrar em contato, me mande mensagem através do meu linkedin:
https://www.linkedin.com/in/kievmaia/
