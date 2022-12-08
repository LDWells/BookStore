package edu.du.cs.ladwells.db.view;

import java.awt.BorderLayout;

import javax.swing.*;

public class GUI {
	
	public GUI() {
		
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		SearchByAuthorPanel tab1 = new SearchByAuthorPanel();
		SearchByPublisherPanel tab2 = new SearchByPublisherPanel();
		SearchByCategoryPanel tab3 = new SearchByCategoryPanel();
		
		// Place the tabs on the tabbed pane
		JTabbedPane tabControl = new JTabbedPane();
		tabControl.addTab("SearchByAuthor", tab1);
		tabControl.addTab("SearchByPublisher", tab2);
		tabControl.addTab("SearchByCategory", tab3);
		
		mainPanel.add(tabControl, BorderLayout.CENTER);

		f.setContentPane(mainPanel);

		f.setVisible(true);
	}


}

