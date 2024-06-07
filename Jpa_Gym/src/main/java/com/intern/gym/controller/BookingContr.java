package com.intern.gym.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gym.pojo.BookingPojo;
import com.intern.gym.service.BookingServ;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/bookings")
public class BookingContr {

    @Autowired
    private BookingServ bookingService;

    @GetMapping
    public List<Map<String, Object>> getAllBookings() {
        List<BookingPojo> bookings = bookingService.getAllBookings();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (BookingPojo booking : bookings) {
            Map<String, Object> bookingMap = new HashMap<>();
            bookingMap.put("id", booking.getId());
            bookingMap.put("plans", booking.getPlans());
            bookingMap.put("bookingTime", booking.getBookingTime());
            bookingMap.put("slotID", booking.getSlot().getId());
            bookingMap.put("userID", booking.getUser().getUserId());
            responseList.add(bookingMap);
        }

        return responseList;
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookingPojo> getBookingById(@PathVariable Long id) {
        Optional<BookingPojo> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Map<String, Object> requestBody) {
        try {
            Long userId = Long.parseLong((String) requestBody.get("userId"));
            Long slotId = Long.parseLong((String) requestBody.get("slotId"));
            String plan = (String) requestBody.get("plan");

            String result = bookingService.createBooking(userId, slotId, plan);

            if (result.equals("1")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid user ID or slot ID format");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid request data");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
