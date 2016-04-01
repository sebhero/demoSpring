package com.sebhero.javafx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Sebastian Börebäck on 2016-04-01.
 */

@Configuration
@EnableWebSocket
public class ApplicationConfigurer implements WebSocketConfigurer {

	@Autowired
	SimpleServerWebSocketHandler simpleServerWebSocketHandler;

	@Override public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(simpleServerWebSocketHandler, "/echo");
	}
}
