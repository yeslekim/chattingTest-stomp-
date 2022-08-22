package com.example.chatTest.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.chatTest.model.Chat;

public interface ChatRepository extends CrudRepository<Chat, Integer> {

	List<Chat> findAllByRoomId(Integer roomId);
}
