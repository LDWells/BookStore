package edu.du.cs.ladwells.db.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.du.cs.ladwells.db.dao.AuthorDAO;
import edu.du.cs.ladwells.db.dao.HenryDAO;
import edu.du.cs.ladwells.db.model.Book;

public class SearchByAuthorPanel extends JPanel {
	
	AuthorDAO authordao = new AuthorDAO();
	Book author = new Book();
	
	private static final long serialVersionUID = 1L;
	
	public SearchByAuthorPanel() {
		this.setBackground(Color.blue);
		
		Vector<Book> authors = new Vector<Book>();
		authors.addAll(authordao.searchByAuthor());
		
		JComboBox<Book> com1 = new JComboBox<Book>();
		com1.removeAllItems();
				
		//add item for each column from DAO
		for (int i=0; i<authors.size(); i++) {
			com1.addItem(authors.get(i));
		}
		
		com1.setSelectedIndex(0);
		
		JComboBox<Book> com2 = new JComboBox<Book>();
		
		com1.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<Book> box = (JComboBox<Book>) e.getSource();

				Book selectedItem = (Book) box.getSelectedItem();
				System.out.println(selectedItem);
				
				//produces results of com2 based on selectedItem in com1
				Vector<Book> titles = new Vector<Book>();
				titles.addAll(authordao.bookFromAuthor(selectedItem.getFirstName()));
				
				com2.removeAllItems();
				for (int i=0; i<titles.size(); i++) {
					com2.addItem(titles.get(i));
				}
			}
			
			
			
		});
		this.add(com1);
		this.add(com2);

		
		JTextField price = new JTextField(10);
		JTextArea inventory = new JTextArea(10, 10);
	    
		
	 	com2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<Book> box = (JComboBox<Book>) e.getSource();

				Book selectedItem = (Book) box.getSelectedItem();
				System.out.println(selectedItem);
										
				//produces the results of price based on the selected title in com2
				
				if(selectedItem == null) {
					price.setText("N/A");
					inventory.setText("Not on hand");
				}
				else {
					
				Book bookPrice = new Book();
				bookPrice = authordao.getPrice(selectedItem.getTitle());
				price.setText(bookPrice.toString());
				
				//produces the results of inventory based on the selected title in com2
				Vector<Book> bookInventory = new Vector <Book>();
				bookInventory.addAll(authordao.getInventory(selectedItem.getTitle()));
				
				// will produce errors if selected Author does not contain a book title
				String result = " ";
				for(int i=0; i < bookInventory.size(); i++)
				{
					result += bookInventory.get(i).toString() + "\n";
					
				}
				inventory.setText(result);
				
				}
			}
						
			
		});
	 	this.add(price);
	 	
	 	this.add(inventory);
		

	}
	
}
