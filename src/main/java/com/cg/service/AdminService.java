package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.AdminRepository;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.repository.VendorRepository;

@Service
public class AdminService {

	// Admin repository instance
	@Autowired
	AdminRepository adminRepository;

	@Autowired
	private SupervisorRepository supervisorRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private HallRepository hallRepository;

	Admin currentAdmin = null;

	public ResponseEntity<Object> loginAdmin(String email, String password) {

		if ((currentAdmin = adminRepository.findByAdminEmailAndAdminPassword(email, password)) != null) {

			if (currentAdmin.getActive())
				return new ResponseEntity<Object>("Admin login successfull.", HttpStatus.OK);

			return new ResponseEntity<Object>("Admin is deactivated.", HttpStatus.OK);

		}

		return new ResponseEntity<Object>("Admin login failed, invalid credentials.", HttpStatus.FORBIDDEN);
	}

	public ResponseEntity<Object> logoutAdmin() {

		if (currentAdmin != null) {
			currentAdmin = null;
			return new ResponseEntity<Object>("Admin logout successfull.", HttpStatus.OK);
		}

		return new ResponseEntity<Object>("Error, currently no admin logged-in.", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> addAdmin(Admin admin) {

		if (!admin.getActive())
			adminRepository.save(admin);
		else {
			List<Admin> admins = adminRepository.getActiveAdmin();
			if (admins.isEmpty()) {

				adminRepository.save(admin);

				return new ResponseEntity<Object>("Admin added successfully.", HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<Object>("Error, currently admin is available.", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Object>("Admin added successfully", HttpStatus.OK);

	}

	public ResponseEntity<Object> removeAllAdmin() {

		if (currentAdmin != null) {
			if (adminRepository.count() != 0) {

				adminRepository.deleteAll();
				return new ResponseEntity<Object>("All admin deleted successfully.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> removeByAdminId(int id) {

		if (currentAdmin != null) {
			if (adminRepository.existsById(id)) {

				adminRepository.deleteById(id);
				return new ResponseEntity<Object>("Admin deleted successfully.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAllAdmin() {

		if (currentAdmin != null) {
			List<Admin> admin = adminRepository.findAll();

			if (admin.isEmpty()) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminPage(int m, int n) {

		if (currentAdmin != null) {
			Pageable page = PageRequest.of(m, n);

			Page<Admin> admin = adminRepository.findAll(page);

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminId(int id) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.findById(id).get();

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminFirstName(String adminFirstName) {

		if (currentAdmin != null) {

			List<Admin> admin = adminRepository.findByAdminFirstName(adminFirstName);

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminLastName(String adminLastName) {

		List<Admin> admin = adminRepository.findByAdminLastName(adminLastName);

		if (admin == null) {

			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminContact(String adminContact) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.findByAdminContact(adminContact);

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminEmail(String email) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.findByAdminEmail(email);

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminRevenue() {

		return this.getAdminRevenueById(currentAdmin.getAdminId());

	}

	public ResponseEntity<Object> getAdminRevenueById(int id) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.getAdminTotalRevenue(id);

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}

			return new ResponseEntity<Object>("Revenue for admin with ID: " +
					admin.getAdminRevenue() + " is:" + admin.getAdminRevenue(), HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> collectAdminRevenue() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = adminRepository.getAllSupervisors(currentAdmin.getAdminId());
			double totalRevenue = 0;

			for (Supervisor supervisor : supervisors) {

				Hall hall = hallRepository.findById(supervisor.getHall().getHallId()).get();
				totalRevenue += hall.getHallRevenue();

				hall.setHallRevenue(0);
				hallRepository.save(hall);
				
				supervisorRepository.save(supervisor);

			}

			currentAdmin.setAdminRevenue(currentAdmin.getAdminRevenue() + totalRevenue);

			adminRepository.save(currentAdmin);

			return new ResponseEntity<Object>("Admin revenue collected.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getSortedByAdminFirstName() {

		if (currentAdmin != null) {

			List<Admin> admin = adminRepository.findAll(Sort.by("adminFirstName"));

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getSortedByAdminLastName() {

		if (currentAdmin != null) {

			List<Admin> admin = adminRepository.findAll(Sort.by("adminLastName"));

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> getSortedByAdminRevenue() {

		if (currentAdmin != null) {

			List<Admin> admin = adminRepository.findAll(Sort.by("adminRevenue"));

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> makeAdminActive(int adminId) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.findById(adminId).get();

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}

			currentAdmin.setActive(false);
			admin.setActive(true);
			currentAdmin = null;
			return new ResponseEntity<Object>("New admin is activated, login with new to use services.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> makeAdminDeactive(int adminId) {

		if (currentAdmin != null) {

			Admin admin = adminRepository.findById(adminId).get();

			if (admin == null) {

				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

			}
			admin.setActive(false);
			return new ResponseEntity<Object>("Admin is deactivated.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	// supervisor services
	public ResponseEntity<Object> addSupervisor(Supervisor s) {

		if (currentAdmin != null) {

			s.setAdmin(currentAdmin);
			supervisorRepository.save(s);
			return new ResponseEntity<Object>("Supervisor added successfully", HttpStatus.OK);
		}

		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> getAllSupervisor() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll();

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> removeAllSupervisor() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll();

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("All supervisors deleted successfully.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> removeBySupervisorId(Integer id) {

		if (currentAdmin != null) {

			Supervisor supervisor = supervisorRepository.findById(id).get();

			if (supervisor == null) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Supervisor deleted successfully.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);
	}

	public ResponseEntity<Object> getBySupervisorId(Integer id) {

		if (currentAdmin != null) {

			Supervisor supervisor = supervisorRepository.findById(id).get();

			if (supervisor == null) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisor, HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getBySupervisorName(String name) {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findBySupervisorName(name);

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getBySupervisorContact(String contact) {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findBySupervisorContact(contact);

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getBySupervisorEmail(String email) {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findBySupervisorEmail(email);

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getSortedBySupervisorName() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll(Sort.by("supervisorName"));

			if (supervisors.isEmpty()) {

				return new ResponseEntity<Object>("Supervisors not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	// vendor services

	public ResponseEntity<Object> addVendor(Vendor vendor) {

		if (currentAdmin != null) {

			vendor.setAdmin(currentAdmin);
			vendorRepository.save(vendor);
			return new ResponseEntity<Object>("Vendor added successfully.", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> removeAllVendor() {

		if (currentAdmin != null) {

			if (vendorRepository.count() != 0) {

				vendorRepository.deleteAll();
				return new ResponseEntity<Object>("All vendors deleted successfully.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> removeByVendorId(int id) {

		if (currentAdmin != null) {

			if (vendorRepository.existsById(id)) {

				vendorRepository.deleteById(id);
				return new ResponseEntity<Object>("Vendor deleted successfully.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAllVendor() {

		if (currentAdmin != null) {

			List<Vendor> vendors = vendorRepository.findAll();

			if (vendors.isEmpty()) {

				return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorPage(int m, int n) {

		if (currentAdmin != null) {

			Pageable page = PageRequest.of(m, n);

			Page<Vendor> vendors = vendorRepository.findAll(page);

			if (vendors == null) {

				return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorId(int id) {

		if (currentAdmin != null) {

			Vendor vendors = vendorRepository.findById(id).get();

			if (vendors == null) {

				return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorFirstName(String adminFirstName) {

		if (currentAdmin != null) {

			List<Vendor> vendors = vendorRepository.findByVendorFirstName(adminFirstName);

			if (vendors == null) {

				return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorLastName(String vendorLastName) {

		List<Vendor> vendors = vendorRepository.findByVendorLastName(vendorLastName);

		if (vendors == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendors, HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorContact(String vendorContact) {

		if (currentAdmin != null) {

			Vendor vendors = vendorRepository.findByVendorContact(vendorContact);

			if (vendors == null) {

				return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			}
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please log in as ADMIN.", HttpStatus.OK);

	}

}