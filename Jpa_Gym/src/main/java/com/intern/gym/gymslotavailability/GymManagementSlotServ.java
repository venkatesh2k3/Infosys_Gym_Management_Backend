package com.intern.gym.gymslotavailability;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymManagementSlotServ {

	@Autowired
	private GymManagementSlotRepo gymManagementSlotRepo;
	
	public GymManagementSlotPojo createSlot(GymManagementSlotPojo gmsp) {
		return gymManagementSlotRepo.save(gmsp);
	}
	
	public void deleteSlot(Long id) {
		gymManagementSlotRepo.deleteById(id);
	}
	
	public List<GymManagementSlotPojo> getAllSlots() {
		return gymManagementSlotRepo.findAll();
	}

	public GymManagementSlotPojo getSlotById(Long id) {
		return gymManagementSlotRepo.findById(id).orElse(null);
	}

	public boolean isSlotAvailable(LocalDateTime startTime, LocalDateTime endTime) {
		List<GymManagementSlotPojo> slots = gymManagementSlotRepo.findAllByStartTimeBetweenAndEndTimeBetween(startTime,
				endTime, startTime, endTime);
		return slots.isEmpty();
	}
}
