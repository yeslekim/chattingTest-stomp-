package com.example.chatTest.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatTest.model.Chat;
import com.example.chatTest.model.ChatMessage;
import com.example.chatTest.service.ChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	
	private final ChatService chatService;

	@MessageMapping("/{roomId}")	// 여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
	@SendTo("/room/{roomId}")		// 구독하고 있는 장소로 메시지 전송 (목적지) -> WebSocketConfig Broker 에서 적용한건 앞에 붙여줘야함
	public ChatMessage message(@DestinationVariable Integer roomId, ChatMessage message) {
		// 채팅 저장
		Chat chat = chatService.createChat(roomId, message.getSender(), message.getMessage(), message.getEnterFlag());
		return ChatMessage.builder()
				.roomId(roomId)
				.sender(chat.getSender())
				.message(chat.getMessage())
				.enterFlag(message.getEnterFlag())
				.build();
	}
}
