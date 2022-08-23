package com.example.chatTest.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

	private Integer roomId;
	private String sender;
	private String message;
	private Integer enterFlag;	// 0 입장, 1 퇴장
	private LocalDateTime sendDate;
}
