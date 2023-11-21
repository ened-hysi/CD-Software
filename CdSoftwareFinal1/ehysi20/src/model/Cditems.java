package model;

import java.io.Serializable;

public class Cditems implements Serializable {

	private String name;
	private String singer;
	private Date release;
	private double price;
	private int quant;
	private int id;
	private static int x = -1;
	private Genre gen;

	
	public Cditems(String name,int quant,double price) {
		this.name=name;
		this.quant=quant;
		this.price=price;
	}
	
	public Cditems(String name ,double price,int quant,Date release,String singer, Genre gen) {
		x++;
		
		this.id = x;
		this.name=name;
		this.price=price;
		this.quant=quant;
		this.release=release;
		this.singer=singer;
		this.gen = gen;
		//this.billno=billno;
		//this.soldquant=soldquant;
		//this.soldate=soldate;
	}
	
	@Override
	public String toString() {
		return super.toString() + name +  " " + "\n Birthday:"
				+ price + "\n Phone: " + "\n salary: " + release + "\n Email: "+ singer ;
	}


	public  String getName() {
		return name;
	
	}
	public void setName(String name) {
		
		this.name=name;
	}
	
	
	public  String getSinger() {
		return singer;
	
	}
	public void setSinger(String singer) {
		
		this.singer=singer;
	}
	
	public double getPrice() {
		return price;
	
	}
	public void setPrice(double price) {
		
		this.price=price;
	}
	
	public int getId() {
		return id;
	
	}
	public void setId(int id) {
		
		this.id=id;
	}

	public Genre getGen() {
		return gen;
	}

	public void setGen(Genre gen) {
		this.gen = gen;
	}

	/*public  String getBillNo() {
		return billno;
	
	}
	public void setBillno(String billno) {
		
		this.billno=billno;
	}
	
	public  int getSoldquan() {
		return soldquant;
	
	}
	public void setSoldqunat(int soldquant) {
		
		this.soldquant=soldquant;
	}
	
	public Date getSoldD() {
		return soldate;
	}*/	
	
	public Date getRelease() {
		return release;
	}
	public Date setRelease() {
		return release;
	}
	
	public  int getQuant() {
		return quant;
	
	}
	public void setQuant(int quant) {
		
		this.quant=quant;
	}
	
}
