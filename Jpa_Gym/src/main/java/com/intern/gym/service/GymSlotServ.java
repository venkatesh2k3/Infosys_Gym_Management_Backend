package com.intern.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gym.pojo.GymSlotPojo;
import com.intern.gym.repo.GymSlotRepo;

@Service 
public class GymSlotServ {
	@Autowired
	private GymSlotRepo gymSlotRepository;

	public List<GymSlotPojo> getAllSlots() {
		return gymSlotRepository.findAll();
	}

	public Optional<GymSlotPojo> getSlotById(Long id) {
		return gymSlotRepository.findById(id);
	}

	public GymSlotPojo createOrUpdateSlot(GymSlotPojo slot) {
		return gymSlotRepository.save(slot);
	}

	public void deleteSlot(Long id) {
		gymSlotRepository.deleteById(id);
	}
}
