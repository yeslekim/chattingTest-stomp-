package com.example.chatTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatTest.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
