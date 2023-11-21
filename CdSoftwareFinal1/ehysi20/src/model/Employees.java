package model;

public class Employees extends User {
	
	private String name;
	private String sname;
	private Date bdate;
	private String phone;
	private double salary;
	private String email;
	private static int x = -1;
	private final int id;
	
	
	public Employees (String name,String sname,Date bdate ,String phone,double salary,String email,String user, String pass,int level) {
		
		x++;
	
		this.id = x;
		this.name=name;
		this.sname=sname;
		this.bdate=bdate;
		this.phone=phone;
		this.salary=salary;
		this.email=email;
		this.user = user;
		this.pass = pass;
		this.level = level;
		
	}
	
	/*public User genUser() {
		// Username
		User x = new User();
		x.setUser((this.name.charAt(0)+this.sname).toLowerCase());
		x.setPass((this.sname.substring(0, 2)+this.bdate).toLowerCase());
		x.setLevel(3);
		return x;
	}*/
	


	public  String getName() {
		return name;
	
	}
	public void setName(String name) {
		
		this.name=name;
	}
	
	public  String getSname() {
		return sname;
	
	}
	public void setSname(String sname) {
		
		this.sname=sname;
	}
	
	public  String getPhone() {
		return phone;
	
	}
	public void setPhone(String phone) {
		
		this.phone=phone;
	}
	
	public  String getEmail() {
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
		return super.toString() + name +  " " + sname  + "\n Birthday:"
				+ bdate + "\n Phone: " + phone + "\n salary: " + salary + "\n Email: "+ email ;
	}

	public int getId() {
		return id;
	}
	
	


}
