package com.intern.gym.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gym.pojo.GymManagement;

public interface GymManagementRepo extends JpaRepository<GymManagement, Long>{

}
