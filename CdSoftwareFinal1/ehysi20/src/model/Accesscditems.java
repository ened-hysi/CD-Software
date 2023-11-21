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
import java.util.Collection;
import java.util.List;

public class Accesscditems {
	
	public static final String filename = "CdItems.ser";
	
	private ArrayList<Cditems> cditems = new ArrayList<Cditems>();
	private ArrayList<Cditems> billItems = new ArrayList<Cditems>();
	private List<Integer> quanBills = new ArrayList<>();


	InputStream file, buffer;
	OutputStream bf, fl;
	ObjectInput input;
	ObjectOutput output;
	File uf = new File(filename);
		
	
    public Accesscditems(){
    	readF();
    }

	public void addCditems(Cditems cdit) {
		cditems.add(cdit);
		writeF();
	}

	public String readS() {
		readF();
		String read = "";
		for (Cditems x : cditems)
			read += "\n-------------User " + x.getName()+"----------\n"+x.getQuant()+"------\n"
			+ x.getPrice()
			+ "--------------------\n" + x.toString()
			+ "\n>---------------------------<\n";
		return read;
	}
	
	public ArrayList<Cditems> getCditems()
	{
		/*this.readF();
		this.closeFile();*/
		return cditems;
	}
	
	
	public int search(Cditems cdit)
	{
		for(int i=0; i<cditems.size(); i++)
		{
			if(cditems.get(i).getId()==cdit.getId() ){
				return i;
			}
		}
		
		return -1;
	}

	
	public void editCditems(int pos,Cditems cdit)
	{

		cditems.set(pos, cdit);
		this.writeF();
	}
	
    public double totAmount(Cditems cdit) {
    	double totalAmount=0;
    	for (Cditems x : cditems) {
    		totalAmount+=(x.getPrice() * x.getQuant());
    	}
    	return totalAmount;
    	
    }
    
    
    public int countGenre(Genre gen)
	{
		int cnt = 0;
		
		for(int i=0; i<cditems.size(); i++)
		{
			if(cditems.get(i).getGen().equals(gen)) cnt++;
		}
		
		return cnt;
	}
     
    public void remove(int id) {
		boolean rm = false;
		for (Cditems x : cditems)
			if (x.getId() == id ) {
				rm = true;
				cditems.remove(cditems.indexOf(x));
				break;
			}
		if (!rm)
			System.out.println("Not Found");
		else
		    this.writeF();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void readF() {
		try {
			// use buffering
			file = new FileInputStream(uf);
			buffer = new BufferedInputStream(file);
			input = new ObjectInputStream(buffer);
			// deserialize the List
			cditems = (ArrayList<Cditems>) input.readObject();
			// display its data
			for (Cditems cdit : cditems) {
				System.out.println("Data: " + cdit.toString());
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("File Not well defined. Creating new file"
					+ ex.toString());
			//addCditems(new Cditems("FIFA 2022",2,40));
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
			output.writeObject(cditems);
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
	
	public void addToBill(Cditems cditem) {
		billItems.add(cditem);
	}
	
	public ArrayList<Cditems> getBillItems(){
		return this.billItems;
	}
	
	public void addToQuanBill(int quanBill) {
		quanBills.add(quanBill);
	}
	
	public List<Integer> getQuanBills(){
		return this.quanBills;
	}
}
