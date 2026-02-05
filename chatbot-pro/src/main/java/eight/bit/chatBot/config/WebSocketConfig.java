package eight.bit.chatBot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/queue");
        config.setUserDestinationPrefix("/user");
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 1. Postman testing ke liye (Direct WebSocket)
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("*");

        // 2. React frontend ke liye (SockJS support)
        registry.addEndpoint("/ws-chat-sockjs")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
