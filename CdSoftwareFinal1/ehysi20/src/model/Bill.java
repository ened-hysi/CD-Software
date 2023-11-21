package model;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {
	
	private static int x = -1;
	private int id;
	private Date pDate;
	private Cashier cash;
	private double totalPrice;
	ArrayList<Cditems> cdItems;

	public Bill(Cashier cash, double totalPrice, ArrayList<Cditems> cdItems) {
		this.id = x++;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		pDate=date;
		this.pDate = pDate;
		this.cash = cash;
		this.totalPrice = totalPrice;	
	}

	public void setPDate(Date pDate) {
		this.pDate = pDate;
	}
	
	public Date getDate() {
		return this.pDate;
	}
	
	public void setCash(Cashier cash) {
		this.cash = cash;
	}
	
	public Cashier getCash() {
		return this.cash;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setCditems(ArrayList<Cditems> cdItems) {
		this.cdItems = cdItems;
	}
	
	public ArrayList<Cditems>  getCditems() {
		return this.cdItems;
	}

}
