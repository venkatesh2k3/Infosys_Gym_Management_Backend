package com.intern.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gym.pojo.GymManagement;
import com.intern.gym.repo.GymManagementRepo;

@Service
public class GymManagementServ {
	@Autowired
	GymManagementRepo gmr;

	public GymManagement register(GymManagement gm) {
		return gmr.save(gm);
	}
	public List<GymManagement> getAllGymManagement() {
        return gmr.findAll();
    }

}
