package com.intern.gym.pojo;

import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gym_slots")
public class GymSlotPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "slots", nullable = false)
    private int slots;
    private String trainerName;
    
    public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Column(name = "available", nullable = false)
    @JsonIgnore
    private boolean available;

    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<BookingPojo> bookings;

    public GymSlotPojo() {
        this.available = true; // By default, slots are available
    }

    public GymSlotPojo(LocalTime startTime, LocalTime endTime, int slots, String trainerName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.trainerName=trainerName;
        this.slots = slots;
        this.available = slots > 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
        this.available = slots > 0;
    }

    public boolean isAvailable() {
        return available && (slots > 0) && (bookings == null || bookings.isEmpty());
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Set<BookingPojo> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingPojo> bookings) {
        this.bookings = bookings;
    }
}
