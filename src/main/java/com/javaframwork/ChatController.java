package com.javaframwork;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {
	
	@MessageMapping("/userRegister")
	@SendTo("/public")
	public ChatResponseDto chat(@Payload ChatResponseDto chatResponseDto,SimpMessageHeaderAccessor messageHeaderAccessor){
		messageHeaderAccessor.getSessionAttributes().put("username", chatResponseDto.getSender());
		return chatResponseDto;
		
	}

	
	@MessageMapping("/messageSend")
	@SendTo("/public")
	public ChatResponseDto sendMessage(@Payload ChatResponseDto chatResponseDto) {
		chatResponseDto.setRess("response darta");
		return chatResponseDto;
	}

}
