package com.sebhero.javafx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Sebastian Börebäck on 2016-04-01.
 */

@Service
public class SimpleServerWebSocketHandler extends TextWebSocketHandler {

	@Autowired
	private RandomTicker randomTicker;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		randomTicker.addSession(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();

		if (!payload.isEmpty()) {
			randomTicker.broadcast("Server received : " + payload);
		}

		System.out.println("SERVER GOT "+payload);

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		randomTicker.removeSession(session.getId());
	}
}