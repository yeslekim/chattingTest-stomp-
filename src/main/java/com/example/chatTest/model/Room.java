package com.example.chatTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {

	@Id
	@GeneratedValue
	@Column(name = "room_id")
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String name;
	
	@Builder
	public Room(String name) {
		this.name = name;
	}
	
	/*
	 * 채팅방 생성
	 * @param name 방 이름
	 * @return Room Entity
	 */
	public static Room createRoom(String name) {
		return Room.builder()
				.name(name)
				.build();
	}
}
