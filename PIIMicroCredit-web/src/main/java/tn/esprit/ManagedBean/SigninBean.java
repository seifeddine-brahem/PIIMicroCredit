package tn.esprit.ManagedBean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import tn.esprit.PIIMicroCredit.entity.ContactInformation;
import tn.esprit.PIIMicroCredit.entity.Department;
import tn.esprit.PIIMicroCredit.entity.LegalInformation;
import tn.esprit.PIIMicroCredit.entity.Role;
import tn.esprit.PIIMicroCredit.entity.Session;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.ContactInformationService;
import tn.esprit.PIIMicroCredit.service.DepartmentService;
import tn.esprit.PIIMicroCredit.service.LegalInformationService;
import tn.esprit.PIIMicroCredit.service.UserService;

@SessionScoped
@ManagedBean
public class SigninBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Legal info
	private Integer legalId;
	private String birthplace;
	private String birthday;
	private String cin;
	private Integer kids;
	private double salary;
	private String status;
	private String work;
	// Contact Info
	private Integer ContactId;
	private String country;
	private String phone;
	private Integer zip_code;
	private String state;
	// User
	private Integer UserId;
	private String email;
	private String login;
	private String first_name;
	private String last_name;
	private String grade;
	private String password;
	private Role role;
	private String address;
	private String image;
	public String getImage() {
		return image;
	}
	//test image
	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Services
	@EJB
	UserService us;
	@EJB
	ContactInformationService cs;
	@EJB
	LegalInformationService ls;
	@EJB
	DepartmentService ds;
	
	public String addUser() throws ParseException {
		
		
		
	
			
			
			
			Department d= ds.findDepartmentById(1);
			
			
			us.AddUser(new User(first_name,last_name,email,login,us.crypte(password),true,address,grade,Role.client,d));
			User user= us.FindUserByEmailAndPsswd(email,us.crypte(password));
			cs.addContactInfo(new ContactInformation(phone,zip_code,state,country,user));
			ls.addLegalInfo(new LegalInformation(cin,LocalDate.now(),birthplace,status,kids,
					work, salary, user));
			Authenticator.currentsession=new Session(user);
		
		
		String navigateTo = "null";
		navigateTo = "/xhtml/Welcome2?faces-redirect=true";
		return navigateTo;
	}
	public User getCurrent()
	{
		return Authenticator.currentsession.getUser();
	}

	public Integer getLegalId() {
		return legalId;
	}

	public void setLegalId(Integer legalId) {
		this.legalId = legalId;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String  getBirthday() {
		return birthday;
	}

	public void setBirthday(String  birthday) {
		this.birthday = birthday;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Integer getKids() {
		return kids;
	}

	public void setKids(Integer kids) {
		this.kids = kids;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Integer getContactId() {
		return ContactId;
	}

	public void setContactId(Integer contactId) {
		ContactId = contactId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getZip_code() {
		return zip_code;
	}

	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public ContactInformationService getCs() {
		return cs;
	}

	public void setCs(ContactInformationService cs) {
		this.cs = cs;
	}

	public LegalInformationService getLs() {
		return ls;
	}

	public void setLs(LegalInformationService ls) {
		this.ls = ls;
	}
	public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            image=file.getFileName();
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	 public void handleFileUpload(FileUploadEvent event) {
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public SigninBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
