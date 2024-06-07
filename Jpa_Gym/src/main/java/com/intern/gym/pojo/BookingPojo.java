package com.intern.gym.pojo;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingPojo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private GymManagement user;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    @JsonIgnore
    private GymSlotPojo slot;
    
    private String plans;
    
    public String getPlans() {
		return plans;
	}

	public void setPlans(String plans) {
		this.plans = plans;
	}

	@Column(name = "booking_time", nullable = false)
    private LocalDateTime bookingTime;

    public BookingPojo() {
        // Default constructor
    }

    public BookingPojo(GymManagement user, GymSlotPojo slot, String plans, LocalDateTime bookingTime) {
        this.user = user;
        this.slot = slot;
        this.plans = plans;
        this.bookingTime = bookingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GymManagement getUser() {
        return user;
    }

    public void setUser(GymManagement user) {
        this.user = user;
    }

    public GymSlotPojo getSlot() {
        return slot;
    }

    public void setSlot(GymSlotPojo slot) {
        this.slot = slot;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
