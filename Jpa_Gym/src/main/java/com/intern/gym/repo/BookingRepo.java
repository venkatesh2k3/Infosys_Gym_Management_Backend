package com.intern.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gym.pojo.BookingPojo;

public interface BookingRepo  extends JpaRepository<BookingPojo, Long> {

}
