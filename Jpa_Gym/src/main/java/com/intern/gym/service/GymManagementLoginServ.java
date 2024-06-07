package com.intern.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gym.pojo.GymManagement;
import com.intern.gym.repo.GymManagementLoginRepo;

@Service
public class GymManagementLoginServ {
@Autowired
GymManagementLoginRepo gmlr;
public GymManagement login(GymManagement gml) {
	return gmlr.save(gml);
}
public GymManagement findByEmail(String email) {
    return gmlr.findByEmail(email); 
}
}
