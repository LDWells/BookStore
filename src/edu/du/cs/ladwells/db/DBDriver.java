//purpose of this class was to test if authorDAO produced the correct results

package edu.du.cs.ladwells.db;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.du.cs.ladwells.db.dao.AuthorDAO;
import edu.du.cs.ladwells.db.dao.CategoryDAO;
import edu.du.cs.ladwells.db.dao.HenryDAO;
import edu.du.cs.ladwells.db.dao.PublisherDAO;
import edu.du.cs.ladwells.db.model.Book;

public class DBDriver {
	
	public static void main(String[] args) {

	HenryDAO henry = new HenryDAO();
	henry.connect();
	
	AuthorDAO authordao = new AuthorDAO();
	CategoryDAO categorydao = new CategoryDAO();
	PublisherDAO publisherdao = new PublisherDAO();
	
	List<Book> authors = authordao.searchByAuthor();	
	List<Book> publishers = publisherdao.searchByPublisher();	
	List<Book> categories = categorydao.searchByCategory();	
	List<Book> titles = authordao.bookFromAuthor("Dick");
	Book price = authordao.getPrice("Second Wind");
	List<Book> inventory = authordao.getInventory("Second Wind");

	for(int i=0; i<authors.size(); i++)
	{
		
		System.out.println(authors.get(i).toString());
		System.out.println(publishers.get(i).toString()); 

	}
	
	
	for(int i=0; i<titles.size(); i++) {
		System.out.println(titles.get(i).toString());
	}
	
	System.out.println(price.getPrice());
	
	for(int i=0; i<inventory.size(); i++) {
		System.out.println(inventory.get(i).toString());
	}
	
	
}
	
}
