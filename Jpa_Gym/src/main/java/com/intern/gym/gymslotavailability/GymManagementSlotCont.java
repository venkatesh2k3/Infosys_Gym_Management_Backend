package com.intern.gym.gymslotavailability;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200/")
@RestController
public class GymManagementSlotCont {
	@Autowired
	private GymManagementSlotServ smss;

	@GetMapping("/availability")
	public ResponseEntity<Boolean> checkSlotAvailability(@RequestParam("startTime") LocalDateTime startTime,
			@RequestParam("endTime") LocalDateTime endTime) {
		boolean isAvailable = smss.isSlotAvailable(startTime, endTime);
		return new ResponseEntity<>(isAvailable, HttpStatus.OK);

	}

	@GetMapping("/gymslots")
	public ResponseEntity<List<GymManagementSlotPojo>> getAllSlots() {
		List<GymManagementSlotPojo> slots = smss.getAllSlots();
		return new ResponseEntity<>(slots, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GymManagementSlotPojo> getSlotById(@PathVariable("id") Long id) {
		GymManagementSlotPojo slot = smss.getSlotById(id);
		if (slot == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(slot, HttpStatus.OK);
	}

	@PostMapping("/slot")
	public ResponseEntity<GymManagementSlotPojo> createSlot(@RequestBody GymManagementSlotPojo gymSlot) {
		GymManagementSlotPojo createdSlot = smss.createSlot(gymSlot);
		return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSlot(@PathVariable("id") Long id) {
		smss.deleteSlot(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
