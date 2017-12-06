package cse2102Project01;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
//Create search bar

public class SearchRestaurants extends JDialog {
	
	private JLabel lbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private Restaurant restaurant = new Restaurant();
	private boolean succeeded;
	
	public SearchRestaurants(Frame parent) {
		
		super(parent, "Search Restaurants", true);
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints(); 
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lbSearch = new JLabel("Search for Restaurants: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbSearch, cs);
        
        tfSearch = new JTextField(30);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfSearch, cs);
        
        btnSearch = new JButton("Search");
        
        btnSearch.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                if (restaurant.restaurantSearch(getSearchStr())) {
                    JOptionPane.showMessageDialog(SearchRestaurants.this,
                            "Your search returned these results: " + restaurant.searchResult ,
                            "Search",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(SearchRestaurants.this,
                            "There were no restaurants matching your search: " + getSearchStr(),
                            "Search",
                            JOptionPane.ERROR_MESSAGE);

                    succeeded = false;
 
                }
            }
            
        });
        
        JPanel bp = new JPanel();
        bp.add(btnSearch);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        
	}
	
	public String getSearchStr() {
        return tfSearch.getText().trim();
    }
	
	public boolean isSucceeded() {
        return succeeded;
    }

	
}
