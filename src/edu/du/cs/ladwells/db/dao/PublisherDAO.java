package edu.du.cs.ladwells.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.du.cs.ladwells.db.dao.AuthorDAO.SQL;
import edu.du.cs.ladwells.db.model.Book;

public class PublisherDAO extends HenryDAO {
	
	   enum SQL{
	   	   
		   SEARCH_BY_PUBLISHER("SELECT PUBLISHER_NAME FROM henry_publisher"),
		   
		   SELECT_BOOK_FROM_PUBLISHER("SELECT TITLE FROM henry_book hb \r\n"
		   		+ "JOIN henry_publisher hp ON hb.PUBLISHER_CODE = hp.PUBLISHER_CODE\r\n"
		   		+ "WHERE PUBLISHER_NAME = ?"),
		   
		   GET_PRICE_FROM_BOOK("SELECT PRICE FROM henry_book WHERE TITLE = ?"),
		   
		   GET_INVENTORY("SELECT BRANCH_NAME, ON_HAND FROM henry_inventory hi\r\n"
		   		+ "    JOIN henry_branch b ON hi.BRANCH_NUM = b.BRANCH_NUM\r\n"
		   		+ "    JOIN henry_book hb ON hi.BOOK_CODE = hb.BOOK_CODE\r\n"
		   		+ "    WHERE TITLE = ?");
		   

	        private final String query;

	        SQL(String query) {
	            this.query = query;
	        }

	        public String getQuery() {
	            return query;
	        }
	    } 
	   
	   public List<Book> searchByPublisher()
	   {
		   
		   List<Book> list = new ArrayList<>();
	        
	        try {
	            this.connect();
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(SQL.SEARCH_BY_PUBLISHER.getQuery());

	            while(resultSet.next()){
	            	Book author = new Book();

	            	author.setPublisher(resultSet.getString(1));
	                    
	                list.add(author);

	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	        }

	        this.dispose();
	        return list;
	   }

	   
	   public List<Book> bookFromPublisher(String name)
	   {
		   List<Book> list = new ArrayList<>();
	        
	        try {
	            this.connect();
	            preparedStatement = connection.prepareStatement(SQL.SELECT_BOOK_FROM_PUBLISHER.getQuery());
	            preparedStatement.setString(1, name);
	            resultSet = preparedStatement.executeQuery();

	            while(resultSet.next()){
	            	Book author = new Book();
	            	author.setTitle(resultSet.getString(1));	                    
	                list.add(author);
	 	   
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	        }

	        this.dispose();
	        return list;
		   
	   }

	   
	   public Book getPrice(String title)
	   {
        	Book author = new Book();

	        try {
	            this.connect();
	            preparedStatement = connection.prepareStatement(SQL.GET_PRICE_FROM_BOOK.getQuery());
	            preparedStatement.setString(1, title);
	            resultSet = preparedStatement.executeQuery();

	            while(resultSet.next()){
	            	author.setPrice(resultSet.getDouble(1));	                    
	 	   
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	        }

	        this.dispose();
	        return author;
		   
	   }

	   public List<Book> getInventory(String title)
	   {
		   
		   List<Book> list = new ArrayList<>();
	        
	        try {
	            this.connect();
	            preparedStatement = connection.prepareStatement(SQL.GET_INVENTORY.getQuery());
	            preparedStatement.setString(1, title);
	            resultSet = preparedStatement.executeQuery();

	            while(resultSet.next()){
	            	Book author = new Book();

	            	author.setBranchName(resultSet.getString(1));
	            	author.setOnHand(resultSet.getInt(2));
	                    
	                list.add(author);
	                

	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	        }

	        this.dispose();
	        return list;
	   }
	   

}
