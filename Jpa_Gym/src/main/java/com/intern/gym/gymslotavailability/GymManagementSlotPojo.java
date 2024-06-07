package com.intern.gym.gymslotavailability;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="GymManagementSlot")
public class GymManagementSlotPojo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long trainerId;
    public Long getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public LocalDateTime getTrainerStartTime() {
		return trainerStartTime;
	}
	public void setTrainerStartTime(LocalDateTime trainerStartTime) {
		this.trainerStartTime = trainerStartTime;
	}
	public LocalDateTime getTrainerEndTime() {
		return trainerEndTime;
	}
	public void setTrainerEndTime(LocalDateTime trainerEndTime) {
		this.trainerEndTime = trainerEndTime;
	}
	private String trainerName;
    private LocalDateTime trainerStartTime;
    private LocalDateTime trainerEndTime;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}
