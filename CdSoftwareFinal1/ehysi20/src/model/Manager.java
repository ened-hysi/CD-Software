package model;

public class Manager extends User{
	
	private String nameofman;
	private Date bdate;
	private String phone;
	private double salary;
	private String email;
	
	public Manager (String nameofman,Date bdate ,String phone,double salary,String email,Cditems cd,String username,String password) {
		super();
		this.nameofman=nameofman;
		this.bdate=bdate;
		this.phone=phone;
		this.salary=salary;
		this.email=email;
		
	}
	
	public  String getNameofman() {
		return nameofman;
	
	}
	public void setNameofcash(String nameofman) {
		
		this.nameofman=nameofman;
	}
	
	public  String getPhone() {
		return phone;
	
	}
	public void setPhone(String phone) {
		
		this.phone=phone;
	}
	
	public  String getEmailr() {
		return email;
	
	}
	public void setEmail(String email) {
		
		this.email=email;
	}
	
	public double getSalary() {
		return salary;
	
	}
	public void setSalary(double salary) {
		
		this.salary=salary;
	}
	
	
	public Date getBdate() {
		return bdate;
	}
	public String toString() {
		return super.toString() + nameofman  + "\n Birthday:"
				+ bdate + "\n Phone: " + phone + "\n salary: " + salary + "\n Email: "+ email ;
	}

}
