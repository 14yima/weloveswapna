
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//This is used to test the Create and Login buttons
public class Main {
	public static void main(String[] args) {
        final JFrame frame = new JFrame("Login&Create Test");
        final JButton btnCreate = new JButton("Click to Create an account");
        final JButton btnLogin = new JButton("Click to login");
     
 
        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Login loginDlg = new Login(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
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
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnCreate);
        frame.setVisible(true);
    }
}
