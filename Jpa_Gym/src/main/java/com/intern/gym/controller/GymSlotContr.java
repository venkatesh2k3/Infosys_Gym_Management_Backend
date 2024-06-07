package com.intern.gym.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gym.pojo.GymSlotPojo;
import com.intern.gym.service.GymSlotServ;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/slots")
public class GymSlotContr {
		@Autowired
		private GymSlotServ gymSlotService;

//		@GetMapping
//		public List<GymSlotPojo> getAllSlots() {
//			return gymSlotService.getAllSlots();
//		}

		@GetMapping
		public List<GymSlotPojo> getAllSlots() {
		    List<GymSlotPojo> allSlots = gymSlotService.getAllSlots();
		    List<GymSlotPojo> nonEmptySlots = allSlots.stream()
		            .filter(slot -> slot.getSlots() != 0)
		            .map(slot -> {
		                GymSlotPojo filteredSlot = new GymSlotPojo();
		                filteredSlot.setId(slot.getId());
		                filteredSlot.setStartTime(slot.getStartTime());
		                filteredSlot.setEndTime(slot.getEndTime());
		                filteredSlot.setSlots(slot.getSlots());
		                filteredSlot.setTrainerName(slot.getTrainerName());
		                return filteredSlot;
		            })
		            .collect(Collectors.toList());
		    return nonEmptySlots;
		}




		@PostMapping
		public GymSlotPojo createSlot(@RequestBody GymSlotPojo slot) {
			return gymSlotService.createOrUpdateSlot(slot);
		}

		@PutMapping("/{id}")
		public ResponseEntity<GymSlotPojo> updateSlot(@PathVariable Long id, @RequestBody GymSlotPojo slot) {
			if (gymSlotService.getSlotById(id).isPresent()) {
				slot.setId(id);
				return ResponseEntity.ok(gymSlotService.createOrUpdateSlot(slot));
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteSlot(@PathVariable Long id) {
			if (gymSlotService.getSlotById(id).isPresent()) {
				gymSlotService.deleteSlot(id);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	}
