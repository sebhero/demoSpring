package sample;

/**
 * Created by Sebastian Börebäck on 2016-04-01.
 */


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.text.MessageFormat;


public class StompWebSocketLoadTestClient {

	private static Log logger = LogFactory.getLog(StompWebSocketLoadTestClient.class);

	private static final int NUMBER_OF_USERS = 200;
	private static final int BROADCAST_MESSAGE_COUNT = 2000;

	public static void main(String[] args) {
		String host = "localhost";
		Integer port = 8080;
//		int port = 37232;

		String homeUrl = MessageFormat.format("ws://{0}:{1}/hello", host, port.toString());

//		List<Transport> transports = new ArrayList<>(2);
//		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//		transports.add(new RestTemplateXhrTransport());
//
//		SockJsClient sockJsClient = new SockJsClient(transports);
//
//		sockJsClient.doHandshake(new MyWebSocketHandler(), homeUrl);

		WebSocketClient transport = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(transport);
		stompClient.setMessageConverter(new StringMessageConverter());

		StompSessionHandler handler = new StompSessionHandlerAdapter() {
			@Override
			public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
				System.out.println("connected> "+session.getSessionId());

			}
		};

		System.out.println(homeUrl);
		stompClient.connect(homeUrl, handler);



	}

}
