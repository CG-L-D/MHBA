package com.cg.entity;

<<<<<<< Updated upstream
import javax.persistence.Entity;
import javax.persistence.Id;
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
<<<<<<< Updated upstream
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supervisor")
public class Supervisor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supervisorId;

	@NotBlank
	@Column(name = "supervisorName")
	private String supervisorName;

	@Email
	@Column(name = "supervisorEmail")
	private String supervisorEmail;

	@NotBlank
	@Column(name = "supervisorContact")
	private String supervisorContact;

	public Supervisor() {
		super();
	}

	public Supervisor(int supervisorId, String supervisorName, String supervisorEmail, String supervisorContact) {
		super();
		this.supervisorId = supervisorId;
		this.supervisorName = supervisorName;
		this.supervisorEmail = supervisorEmail;
		this.supervisorContact = supervisorContact;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getSupervisorEmail() {
		return supervisorEmail;
	}

	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}

	public String getSupervisorContact() {
		return supervisorContact;
	}

	public void setSupervisorContact(String supervisorContact) {
		this.supervisorContact = supervisorContact;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisorId = " + supervisorId + ", SupervisorName = " + supervisorName
				+ "', supervisorEmail = " + supervisorEmail + ", supervisorContact = " + supervisorContact + "]";

	}

=======
=======
import javax.persistence.Entity;
>>>>>>> 2066ab205978e3d6f46397f82197540db45ed59b
import javax.persistence.Id;

@Entity
public class Supervisor {
	
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supervisorId;
	
=======
>>>>>>> 2066ab205978e3d6f46397f82197540db45ed59b
	private String firstName;
	
	public Supervisor() {
		
	}

	public Supervisor(String firstName) {
		super();
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
>>>>>>> Stashed changes
}
