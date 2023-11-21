package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Accessemployes {
	
	public static final String filename = "Employeess.ser";

	private ArrayList<Employees> employees = new ArrayList<Employees>();
	InputStream file, buffer;
	OutputStream bf, fl;
	ObjectInput input;
	ObjectOutput output;
	File uf = new File(filename);

	public Accessemployes() {
		readF();
	}

	public void addEmployee(Employees emp) {
		employees.add(emp);
		writeF();
	}

	public ArrayList<Employees> getEmployees(){
		return employees;
	}
	
	public void rm(int id) {
		boolean rm = false;
		for (Employees x : employees)
			if (x.getId() == id ) {
				rm = true;
				employees.remove(employees.indexOf(x));
				break;
				
			}
		if (!rm)
			System.out.println("Not Found");
		else
		    this.writeF();
		
	}
	
	public int getPosition(Employees emp)
	{
		for(int i=0; i<employees.size(); i++)
		{
			if(employees.get(i).toString().equals(emp.toString()))
				return i;
		}
		
		return -1;
	}
	
	public void setSalary(Employees emp, double salary)
	{
		int pos = getPosition(emp);
		
		employees.get(pos).setSalary(salary);
		
		this.writeF();
	}
	
	public void editEmployee(int pos, Employees emp)
	{
		employees.set(pos, emp);
		this.writeF();
	}

	
	@SuppressWarnings("unchecked")
	public void readF() {
		try {
			file = new FileInputStream(uf);
			buffer = new BufferedInputStream(file);
			input = new ObjectInputStream(buffer);
			employees = (ArrayList<Employees>) input.readObject();
			// display its data
			for (Employees emp : employees) {
				System.out.println("Data: " + emp.toString());
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("File Not well defined. Creating new file"
					+ ex.toString());
			//addEmployee(new Employees("test","test",new BDate(12,2,2010),"+32366653456",Department.HR));
		} catch (IOException ex) {
			System.out.println("Cannot perform input." + ex.toString());
		}
		closeFile();
	}

	private void writeF() {
		// serialize the List
		try {
			fl = new FileOutputStream(uf);
			bf = new BufferedOutputStream(fl);
			output = new ObjectOutputStream(bf);
			output.writeObject(employees);
		} catch (IOException ex) {
			System.out.println("Cannot perform output." + ex.toString());
		}
		closeFile();
	}
	


	public void closeFile() {
		try {
			if (input != null) {
				input.close();
				buffer.close();
				file.close();
			}
			if (output != null) {
				output.close();
				bf.close();
				fl.close();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public Employees checkUser(String user, String pass) {
		for (Employees x : employees)
			if (x.getUser().equals(user) && x.getPass().equals(pass)) {
				return x;
			}
		return null;
	}
	
	


}
