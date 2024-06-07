package com.intern.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gym.pojo.GymManagement;

public interface GymManagementLoginRepo extends JpaRepository<GymManagement, Integer>{

	GymManagement findByEmail(String email);

}
