package com.sebhero.hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by Sebastian Börebäck on 2016-03-30.
 */
@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException {

		Thread.sleep(3000);
		return new Greeting("Hello, " + message.getName() + "!");
	}

}
