package com.intern.gym.pojo;

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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="GymManagementReg")

public class GymManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // Renamed id to userId
    
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    
    @NotNull(message = "Phone number is mandatory")
//    @JsonIgnore
    private String password;
    private long phNum;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<BookingPojo> bookings;

    

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhNum() {
        return phNum;
    }

    public void setPhNum(long phNum) {
        this.phNum = phNum;
    }

    public Set<BookingPojo> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingPojo> bookings) {
        this.bookings = bookings;
    }

}
