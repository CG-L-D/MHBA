package com.cg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Supervisor;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select admin from Admin admin where admin.adminId=?1")
	Admin getAdminTotalRevenue(int id);

	@Query("select supervisors from Admin admin where admin.adminId=?1")
	List<Supervisor> getAllSupervisors(int id);

	Admin findByAdminEmailAndAdminPassword(String email, String password);

}
