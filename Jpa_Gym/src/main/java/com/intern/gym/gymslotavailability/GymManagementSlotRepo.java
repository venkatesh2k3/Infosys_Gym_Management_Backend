package com.intern.gym.gymslotavailability;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GymManagementSlotRepo extends JpaRepository<GymManagementSlotPojo, Long> {
	List<GymManagementSlotPojo> findAllByStartTimeBetweenAndEndTimeBetween(LocalDateTime startTime1, LocalDateTime endTime1, LocalDateTime startTime2, LocalDateTime endTime2);
	}