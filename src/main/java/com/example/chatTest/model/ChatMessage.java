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
	private LocalDateTime sendDate;
}
