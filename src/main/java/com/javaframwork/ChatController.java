package com.javaframwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@MessageMapping("/userRegister")
	@SendTo("/public")
	public ChatResponseDto chat(@Payload ChatResponseDto chatResponseDto,SimpMessageHeaderAccessor messageHeaderAccessor){
		messageHeaderAccessor.getSessionAttributes().put("username", chatResponseDto.getSender());
		return chatResponseDto;
		
	}

	
	@MessageMapping("/messageSend")
	@SendTo("/public")
	public ChatResponseDto sendMessage(@Payload ChatResponseDto chatResponseDto) {
		chatResponseDto.setRess("response data");
		messagingTemplate.convertAndSend("/notificationSent",
				new Notification(chatResponseDto.getContent()+" successfully updated", 200));
		 
		return chatResponseDto;
	}

}
