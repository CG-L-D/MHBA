package com.cg.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.exception.AdminAvailableException;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.AdminLoggedInException;
import com.cg.exception.AdminLoggedOutException;
import com.cg.exception.InvalidCredentialsException;
import com.cg.exception.SupervisorNotFoundException;
import com.cg.repository.AdminRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.repository.VendorRepository;
import com.cg.exception.VendorNotFoundException;

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

	@Autowired
	private CustomerRepository customerRepository;

	Admin currentAdmin = null;

	static Logger log = Logger.getLogger(AdminService.class.getName());

	public ResponseEntity<Object> loginAdmin(String email, String password) {

		if (currentAdmin != null) {

			log.error("Admin with ID, " + currentAdmin.getAdminId() + ", was already logged in.");
			throw new AdminLoggedInException("Admin is already logged in.");

		}

		if ((currentAdmin = adminRepository.findByAdminEmailAndAdminPassword(email, password)) != null) {

			log.info("Admin with ID, " + currentAdmin.getAdminId() + ", logged in successfully.");
			return new ResponseEntity<Object>("Admin login successfull.", HttpStatus.OK);

		}

		log.error("Admin with email, " + email + ", tried to login, invalid credentials.");

		throw new InvalidCredentialsException("Admin login failed, invalid credentials.");
	}

	public ResponseEntity<Object> logoutAdmin() {

		if (currentAdmin != null) {

			log.info("Admin with ID, " + currentAdmin.getAdminId() + ", logged out successfully.");

			currentAdmin = null;

			return new ResponseEntity<Object>("Admin logout successfull.", HttpStatus.OK);

		}

		log.error("Admin tried to logout, but no admin logged-in.");

		throw new AdminLoggedOutException("Currently no admin logged-in.");
	}

	public ResponseEntity<Object> addAdmin(Admin admin) {

		if (adminRepository.findAll().isEmpty()) {

			adminRepository.save(admin);
			log.info("Admin with ID " + admin.getAdminId() + ", added successfully");

			return new ResponseEntity<Object>("Admin added successfully.", HttpStatus.OK);

		}

		log.error("Tried to add, but admin is available.");

		throw new AdminAvailableException("Error, currently admin is available.");

	}

	public ResponseEntity<Object> removeAdmin() {

		if (currentAdmin != null) {

			adminRepository.deleteById(currentAdmin.getAdminId());
			log.info("Admin with ID " + currentAdmin.getAdminId() + ", deleted successfully.");

			return new ResponseEntity<Object>("Admin deleted successfully.", HttpStatus.OK);

		}

		log.error("Tried to remove admin, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getAdmin() {

		if (currentAdmin != null) {

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed all admins.");

			return new ResponseEntity<Object>(currentAdmin, HttpStatus.OK);

		}

		log.error("Tried to access admin, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getAdminRevenue() {

		if (currentAdmin != null) {

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed revenue.");

			return new ResponseEntity<Object>("Revenue for admin with ID: " +
					currentAdmin.getAdminId() + " is:" + currentAdmin.getAdminRevenue(), HttpStatus.OK);

		}

		log.error("Tried to access admin revenue, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> collectAdminRevenue() {

		if (currentAdmin != null) {

			List<Hall> halls = hallRepository.findAll();
			double totalRevenue = 0;

			for (Hall hall : halls) {

				totalRevenue += hall.getHallRevenue();

				hall.setHallRevenue(0.0);

				hallRepository.save(hall);

			}

			currentAdmin.setAdminRevenue(currentAdmin.getAdminRevenue() + totalRevenue);

			adminRepository.save(currentAdmin);

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", collected revenue.");

			return new ResponseEntity<Object>("Admin revenue collected.", HttpStatus.OK);

		}

		log.error("Tried to collect admin revenue, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	// supervisor services
	public ResponseEntity<Object> addSupervisor(Supervisor s) {

		if (currentAdmin != null) {

			s.setAdmin(currentAdmin);
			supervisorRepository.save(s);

			log.info(
					"Admin with ID " + currentAdmin.getAdminId() + ", added supervisor with ID," + s.getSupervisorId());

			return new ResponseEntity<Object>("Supervisor added successfully", HttpStatus.OK);

		}

		log.error("Admin tried to add supervisor, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getAllSupervisor() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll();

			if (supervisors.isEmpty()) {

				log.error("Admin tried to access supervisors, but no supervisors present.");

				throw new SupervisorNotFoundException("Supervisors not found.");

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed supervisors.");

			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}

		log.error("Admin tried to access supervisors without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> removeAllSupervisor() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll();

			if (supervisors.isEmpty()) {

				log.error("Admin tried to access supervisors, but no supervisors present.");

				throw new SupervisorNotFoundException("Supervisors not found.");

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", deleted all supervisors.");

			return new ResponseEntity<Object>("All supervisors deleted successfully.", HttpStatus.OK);

		}

		log.error("Admin tried to delete supervisors without login.");
		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> removeBySupervisorId(Integer id) {

		if (currentAdmin != null) {

			Supervisor supervisor = supervisorRepository.findById(id).get();

			if (supervisor == null) {

				log.error("Admin tried to remove supervisor, but no supervisor present.");

				throw new SupervisorNotFoundException();

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", deleted supervisor with ID, " + id);
			return new ResponseEntity<Object>("Supervisor deleted successfully.", HttpStatus.OK);

		}

		log.error("Admin tried to delete supervisor without login.");
		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getBySupervisorId(Integer id) {

		if (currentAdmin != null) {

			Supervisor supervisor = supervisorRepository.findById(id).get();

			if (supervisor == null) {

				log.error("Admin tried to access supervisors, but no supervisors present.");

				throw new SupervisorNotFoundException();

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed supervisor with ID, " + id);

			return new ResponseEntity<Object>(supervisor, HttpStatus.OK);

		}

		log.error("Admin tried to access supervisor without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getSortedBySupervisorName() {

		if (currentAdmin != null) {

			List<Supervisor> supervisors = supervisorRepository.findAll(Sort.by("supervisorName"));

			if (supervisors.isEmpty()) {

				log.error("Admin tried to access supervisors, but no supervisors present.");

				throw new SupervisorNotFoundException();

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed all supervisors.");

			return new ResponseEntity<Object>(supervisors, HttpStatus.OK);
		}

		log.error("Admin tried to access supervisor without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	// vendor services

	public ResponseEntity<Object> addVendor(Vendor vendor) {

		if (currentAdmin != null) {

			vendor.setAdmin(currentAdmin);
			vendorRepository.save(vendor);
			log.info("Admin with ID " + currentAdmin.getAdminId() + ", added vendor with ID," + vendor.getVendorId());

			return new ResponseEntity<Object>("Vendor added successfully.", HttpStatus.OK);

		}
		log.error("Admin tried to add vendor, but no admin logged in");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> removeAllVendor() {

		if (currentAdmin != null) {

			if (vendorRepository.count() != 0) {

				vendorRepository.deleteAll();
				log.info("Admin with ID " + currentAdmin.getAdminId() + " deleted all vendors succesfully.");

				return new ResponseEntity<Object>("All vendors deleted successfully.", HttpStatus.OK);

			}
			log.error("No vendors are present");
			throw new VendorNotFoundException("Vendor not found.");
		}

		log.error("Admin tried to remove vendors without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> removeByVendorId(int id) {

		if (currentAdmin != null) {

			if (vendorRepository.existsById(id)) {

				vendorRepository.deleteById(id);
				log.info("Admin with ID " + currentAdmin.getAdminId() + ", removed vendor with ID," + id);

				return new ResponseEntity<Object>("Vendor deleted successfully.", HttpStatus.OK);

			}
			log.error("No vendor present");
			throw new VendorNotFoundException("Vendor not found.");
		}

		log.error("Admin tried to remove vendor without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");
	}

	public ResponseEntity<Object> getAllVendor() {

		if (currentAdmin != null) {

			List<Vendor> vendors = vendorRepository.findAll();

			if (vendors.isEmpty()) {
				log.error("Admin tried to access vendors, but no vendors present.");

				throw new VendorNotFoundException("Vendor not found.");

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed vendors.");

			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}

		log.error("Admin tried to access vendors without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getByVendorPage(int m, int n) {

		if (currentAdmin != null) {

			Pageable page = PageRequest.of(m, n);

			Page<Vendor> vendors = vendorRepository.findAll(page);

			if (vendors == null) {

				log.error("No vendors are present");
				throw new VendorNotFoundException("Vendor not found.");

			}
			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed vendors with ID " + m + " to " + n);
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);
		}

		log.error("Admin tried to access vendors without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getByVendorId(int id) {

		if (currentAdmin != null) {

			Vendor vendors = vendorRepository.findById(id).get();

			if (vendors == null) {

				log.error("Admin tried to access vendors, but no vendors present.");

				throw new VendorNotFoundException("Vendor Not Found");

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", accessed vendor with id " + id);
			return new ResponseEntity<Object>(vendors, HttpStatus.OK);

		}

		log.error("Admin tried to access vendor without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> getAllCustomers() {

		if (currentAdmin != null) {

			List<Customer> customers = customerRepository.findAll();

			if (customers.isEmpty()) {

				log.error("Admin tried to access customers, but no customers present.");

				throw new CustomerNotFoundException("Customers not found.");
			}

			return new ResponseEntity<Object>(customers, HttpStatus.OK);

		}

		log.error("Admin tried to access customers without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");

	}

	public ResponseEntity<Object> removeCustomerById(int id) {

		if (currentAdmin != null) {

			Customer customer = customerRepository.findById(id).get();
			if (customer == null) {

				log.error("Admin tried to access supervisors, but no customers present.");

				throw new CustomerNotFoundException("Customers not found.");

			}

			log.info("Admin with ID " + currentAdmin.getAdminId() + ", deleted customer with ID, " + id);

			return new ResponseEntity<Object>("Customer deleted successfully.", HttpStatus.OK);

		}

		log.error("Admin tried to remove customer without login.");

		throw new AdminLoggedOutException("No admin logged in, please login as admin.");
	}
}