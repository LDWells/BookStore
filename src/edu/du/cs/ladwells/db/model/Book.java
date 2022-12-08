// a class that'll access the books information from the DAO

package edu.du.cs.ladwells.db.model;

public class Book {
	private String firstName;
	private String lastName;
	private String publisher;
	private String category;
	private String title;
	private double price;
	private String branchName;
	private int onHand;

	public Book() {
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public int getOnHand() {
		return onHand;
	}


	public void setOnHand(int onHand) {
		this.onHand = onHand;
	}


	@Override
	public String toString() {
		if(getFirstName() != null) return  firstName + " " + lastName;
		if(getPublisher() != null) return  publisher;
		if(getCategory() != null) return  category;
		if(getTitle() != null) return title;
		if(getPrice() != 0) return "$" + price;
		if(getBranchName() != null) return branchName + "\t" + onHand;

		return " ";
	}

	
	
	
	
	
	
}
