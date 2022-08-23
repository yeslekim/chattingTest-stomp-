package com.example.chatTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chatTest.model.Chat;
import com.example.chatTest.model.Room;
import com.example.chatTest.repository.ChatRepository;
import com.example.chatTest.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private final RoomRepository roomRepository;
	private final ChatRepository chatRepository;
	
	/*
	 * 모든 채팅방 찾기
	 */
	public List<Room> findAllRoom() {
		return roomRepository.findAll();
	}
	
	/*
	 * 특정 채팅방 찾기
	 */
	public Room findRoomById(Integer id) {
		return roomRepository.findById(id).orElseThrow();
	}
	
	/*
	 * 채팅방 만들기
	 * @param name 방 이름
	 */
	public Room createRoom(String name) {
		return roomRepository.save(Room.createRoom(name));
	}
	
	
	/*
	 * 채팅 생성
	 * @param roomId 채팅방 id
	 * @param sender 보낸이
	 * @param message 내용
	 */
	public Chat createChat(Integer roomId, String sender, String message, Integer enterFlag) {
		Room room = roomRepository.findById(roomId).orElseThrow();
		return chatRepository.save(Chat.createChat(room, sender, message, enterFlag));
	}
	
	/*
	 * 채팅방 내용 불러오기
	 * @param roomId 채팅방 id
	 */
	public List<Chat> findAllChatByRoomId(Integer roomId) {
		return chatRepository.findAllByRoomId(roomId);
	}
}
