package com.intern.gym.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gym.pojo.BookingPojo;
import com.intern.gym.pojo.GymManagement;
import com.intern.gym.pojo.GymSlotPojo;
import com.intern.gym.repo.BookingRepo;
import com.intern.gym.repo.GymManagementRepo;
import com.intern.gym.repo.GymSlotRepo;

@Service
public class BookingServ {

  @Autowired
  private BookingRepo bookingRepository;

  @Autowired
  private GymManagementRepo gymManagementRepository;

  @Autowired
  private GymSlotRepo gymSlotRepository;

  public List<BookingPojo> getAllBookings() {
    return bookingRepository.findAll();
  }

  public Optional<BookingPojo> getBookingById(Long id) {
    return bookingRepository.findById(id);
  }

  public String createBooking(Long userId, Long slotId, String plans) {
	    Optional<GymManagement> userOptional = gymManagementRepository.findById(userId);
	    Optional<GymSlotPojo> slotOptional = gymSlotRepository.findById(slotId);

	    if (userOptional.isEmpty() || slotOptional.isEmpty()) {
	        return "User or Slot not found";
	    }

	    GymManagement user = userOptional.get();
	    GymSlotPojo slot = slotOptional.get();

	    if (slot.getSlots() <= 0) {
	        return "Slot is not available";
	    }

	    // Update slot availability only if booking is confirmed
	    slot.setSlots(slot.getSlots() - 1); // Reduce available slots by 1
	    slot.setAvailable(slot.getSlots() > 0); // Update available flag based on remaining slots
	    gymSlotRepository.save(slot);

	    BookingPojo booking = new BookingPojo(user, slot, plans, LocalDateTime.now());
	    bookingRepository.save(booking);

	    return "1";
  }
  public void cancelBooking(Long id) {
    Optional<BookingPojo> bookingOptional = bookingRepository.findById(id);

    if (bookingOptional.isPresent()) {
      BookingPojo booking = bookingOptional.get();
      GymSlotPojo slot = booking.getSlot();

      // Increase slot availability only if a booking is canceled
      slot.setSlots(slot.getSlots() + 1); // Increase available slots by 1
      slot.setAvailable(true); // Ensure the slot is available again
      gymSlotRepository.save(slot);

      bookingRepository.deleteById(id);
    } else {
      throw new IllegalArgumentException("Booking not found");
    }
  }
}
