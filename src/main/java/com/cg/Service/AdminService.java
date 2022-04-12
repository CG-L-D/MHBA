package com.cg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public String addAdmin(Admin admin) {
		
		adminRepository.save(admin);
		
		return "Admin added successfully.";
	}
	
	public String removeAdmin(long id) {
		
		adminRepository.deleteById(id);
		
		return "Admin deleted successfully.";
	}
	
}
