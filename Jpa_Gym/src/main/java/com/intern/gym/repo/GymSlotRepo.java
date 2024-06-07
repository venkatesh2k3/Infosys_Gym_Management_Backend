package com.intern.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gym.pojo.GymSlotPojo;

public interface GymSlotRepo extends JpaRepository<GymSlotPojo, Long> {

}
