package cse2102Project01;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//This is used to test the Create and Login buttons
public class Main {
	public static void main(String[] args) {
        final JFrame frame = new JFrame("Login&Create Test");
        final JFrame frame2 = new JFrame("Write Review");
        final JButton btnCreate = new JButton("Click to Create an account");
        final JButton btnLogin = new JButton("Click to login");
        final JButton tfSearch = new JButton("Click here to search for restaurants");
        final JButton btnWrite = new JButton("Click here to write a review");
        
        tfSearch.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        SearchRestaurants searchResult = new SearchRestaurants(frame);
                        searchResult.setVisible(true);
                        /*if(searchResult.isSucceeded()){
                            ;
                        }*/
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
        btnWrite.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        WriteReview reviewWrite = new WriteReview(frame2);
                        reviewWrite.setVisible(true);
                        if(reviewWrite.reviewSuccess()){
                        	btnWrite.setText("Write another review");
                        }
                    }
                });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnCreate);
        frame.getContentPane().add(tfSearch);
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 300);
        frame2.setLayout(new FlowLayout());
        frame2.getContentPane().add(btnWrite);

        frame.setVisible(true);
        frame2.setVisible(false);
    }
}