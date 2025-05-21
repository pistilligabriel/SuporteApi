package br.com.api_suporte.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Configura o broker de mensagens
        // O "/queue" é onde os ADMs vão pegar as mensagens pendentes e resolvidas.
        registry.enableSimpleBroker("/queue", "/topic");  // "/queue" para mensagens pendentes, "/topic" pode ser usado para broadcast (caso necessário).

        // Configura o prefixo "/app" para onde o cliente envia as mensagens (rota de request)
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registra o endpoint "/chat" para clientes se conectarem via WebSocket
        // Esse endpoint é o URL onde os clientes irão se conectar
        registry.addEndpoint("/chat")
                .setAllowedOrigins("*") // Permite conexões de qualquer origem
                .withSockJS(); // Habilita o fallback do SockJS para navegadores que não suportam WebSocket diretamente
    }
}
