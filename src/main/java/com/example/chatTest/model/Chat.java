package com.example.chatTest.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {
	
	@Id @GeneratedValue
	@Column(name = "chat_id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id")
	private Room room;
	
	@Column(columnDefinition = "TEXT")
	private String sender;
	
	@Column(columnDefinition = "TEXT")
	private String message;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime sendDate;
	
	@Builder
	public Chat(Room room, String sender, String message) {
	    this.room = room;
	    this.sender = sender;
	    this.message = message;
	    this.sendDate = LocalDateTime.now();
	}
	
	/**
	 * 채팅 생성
	 * @param room 채팅 방
	 * @param sender 보낸이
	 * @param message 내용
	 * @return Chat Entity
	 */
	public static Chat createChat(Room room, String sender, String message) {
	    return Chat.builder()
	            .room(room)
	            .sender(sender)
	            .message(message)
	            .build();
	}
}
