// package com.cg;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// // import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.cg.entity.Admin;
// import com.cg.entity.Hall;
// import com.cg.entity.Supervisor;
// import com.cg.repository.SupervisorRepository;
// import com.cg.service.SupervisorService;

// public class SupervisorControllerTest extends MhbaApplicationTests {

// @Autowired
// SupervisorService supervisorService;

// @MockBean
// SupervisorRepository supervisorRepository;

// Admin admin;
// Hall hall;
// Supervisor supervisor;

// @BeforeEach
// void setUp() {
// admin = new Admin(101, "onkar", "M", "onkar@gmail.com", "893821128312",
// "qazwsx");
// hall = new Hall(101, "palace", 40, 500, "civil line", "city", 70000, false,
// null, null);
// supervisor = new Supervisor(101, "Surya", "surya@gmail.com", "90909022339",
// hall);
// }

// @Test
// public void addHallTest() {
// when(supervisorRepository.getById(101)).thenReturn(supervisor);
// assertEquals("<200 OK OK,Hall added successfully.,[]>",
// supervisorService.addHall(101, hall).toString());
// }

// @Test
// public void removeHallTest() {
// when(supervisorRepository.deleteById(101).get()).thenReturn(supervisor);
// assertEquals("<200 OK OK,Hall removed successfully.,[]>",
// supervisorService.addHall(101, hall).toString());
// }

// @Test
// public void getSupervisorHallDetailsTest() {
// when(supervisorRepository.findById(101).get().getHall()).thenReturn(supervisor);
// assertEquals("<200 OK OK,Hall removed successfully.,[]>",
// supervisorService.addHall(101, hall).toString());
// }

// @Test
// public void generateBillTest() {
// // when(supervisorRepository.).thenReturn();
// }
// }
