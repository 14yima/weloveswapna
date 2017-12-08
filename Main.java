

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
//This is used to test the Create and Login buttons
//promote user to admin, delete revies, average rating,
public class Main {
	public static void main(String[] args) {
        final JFrame frame = new JFrame("Login&Create Test");
        final JFrame frame2 = new JFrame("Write Review");
        
        final JButton btnCreate = new JButton("Click to Create an account");
        final JButton btnLogin = new JButton("Click to login");
        final JButton tfSearch = new JButton("Click here to search for restaurants");
        final JButton goToRest = new JButton("Click to goto restaurant");
        final JButton btnWrite = new JButton("Click here to write a review");
        
        JTextArea name = new JTextArea(2,20);
        JTextArea rating = new JTextArea(2,10);
        JTextArea reviews = new JTextArea(10,50);
        Restaurant restaurant = new Restaurant();
        Account user = new Account();
        String review;
        
        name.setEditable(false);
        rating.setEditable(false);
        reviews.setEditable(false);
        String newline="\n";
        
        
        name.setText(restaurant.getRestaurantName());
        name.setFont(new Font("Serif", Font.BOLD, 24));
        name.setLineWrap(true);
        
		try(BufferedReader br = new BufferedReader(new FileReader(restaurant.getRestaurantName()+".txt")))
		{
			while ((review = br.readLine()) != null) {	//reads one line at a time
				reviews.append(review);
				reviews.append(newline);
				reviews.setLineWrap(true);
			    }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error file not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file");
			e.printStackTrace();
		}
        
		btnWrite.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        WriteReview reviewWrite = new WriteReview(frame2);
                        reviewWrite.name=user.username;
                        reviewWrite.setVisible(true);
                        if(reviewWrite.reviewSuccess()){
                        	btnWrite.setText("Write another review");
                        }
                    }
                });
		
		goToRest.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        ChangeRestuarant result = new ChangeRestuarant(frame);
                        result.setVisible(true);
                        if(result.isSucceeded())
                        {
                        	restaurant.restaurantName=result.getUsername();
                        	System.out.println(restaurant.restaurantName);
                        	name.setText(restaurant.getRestaurantName());
                        //	frame.revalidate();
                        //	frame.repaint();
                        	reviews.setText(null);
                        	try(BufferedReader br = new BufferedReader(new FileReader(restaurant.getRestaurantName()+".txt")))
                    		{
                        		String update;
                    			while ((update = br.readLine()) != null) {	//reads one line at a time
                    				reviews.append(update);
                    				reviews.append(newline);
                    				reviews.setLineWrap(true);
                    			    }
                    			
                    		} catch (FileNotFoundException e1) {
                    			// TODO Auto-generated catch block
                    			System.out.println("Error file not found");
                    			e1.printStackTrace();
                    		} catch (IOException e1) {
                    			// TODO Auto-generated catch block
                    			System.out.println("Error in reading file");
                    			e1.printStackTrace();
                    		}
                        }
                    }
                });
        
        tfSearch.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        SearchRestaurants searchResult = new SearchRestaurants(frame);
                        searchResult.setVisible(true);
                    }
                });
 
        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Login loginDlg = new Login(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Log in as another user");
                            System.out.println(loginDlg.getUsername());
                            user.username=loginDlg.getUsername();
                            frame.setVisible(false);
                            frame2.setVisible(true);
                        }
                    }
                });
        
        btnCreate.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        CreateAccount loginCreate = new CreateAccount(frame);
                        loginCreate.setVisible(true);
                        // if Create successfully
                        if(loginCreate.isSucceeded()){
                        	btnCreate.setText("Account successfuly created");
                        }
                    }
                });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnCreate);
        frame.getContentPane().add(tfSearch);
        frame.getContentPane().add(goToRest);
        frame.getContentPane().add(name);
        frame.getContentPane().add(reviews);
        frame.setVisible(true);
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800, 800);
        frame2.setLayout(new FlowLayout());
        frame2.getContentPane().add(btnWrite);
        frame2.getContentPane().add(tfSearch);
        frame2.getContentPane().add(goToRest);
        frame2.getContentPane().add(name);
        frame2.getContentPane().add(reviews);
        frame2.setVisible(false);
    }

}