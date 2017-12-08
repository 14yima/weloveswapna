import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.net.URL;
import java.io.IOException;


public class WriteReview extends JDialog {
	
	private JButton btnSubmitReview;
	private Account account = new Account();
	private JTextArea textArea;
	private JTextField tfResName;
	private JLabel lbResName;
	private JTextField tfResLoc;
	private JLabel lbResLoc;
	private boolean revSuccess;
	public String name;
	private JTextField rating;
	
	public WriteReview(Frame parent) {
		
        
		super(parent, "Write Review", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        lbResName = new JLabel("Restaurant Name: ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(lbResName, c);
        
        tfResName = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(tfResName, c);
        
        lbResLoc = new JLabel("Restaurant Town: ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(lbResLoc, c);
        
        tfResLoc = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(tfResLoc, c);
        
        
        rating = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(rating, c);
        
        

        textArea = new JTextArea(
                "Enter Review Here"
         );
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 3;
        panel.add(textArea, c);
        
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setRows(10);
        
   
        
        
       
        /**
         * 
		     textArea.setEditable(true);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250)); 
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                		BorderFactory.createTitledBorder("Review"),
                		BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        
        JPanel rightPane = new JPanel(new GridLayout(1,0));
        JPanel leftPane = new JPanel(new BorderLayout());         
        leftPane.add(panel, 
                      BorderLayout.PAGE_START);
        leftPane.add(areaScrollPane,
                      BorderLayout.CENTER);
        add(leftPane, BorderLayout.LINE_START);
        add(rightPane, BorderLayout.LINE_END); 
        
        **/
        
        btnSubmitReview = new JButton ("Submit Review");
        
        btnSubmitReview.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Name is : " + getResName());
            	account.username=name;
                account.writeReview(getResName(), getReview(), getRating());
                tfResName.setText("");
                tfResLoc.setText("");
 
                }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnSubmitReview);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(true);
        setLocationRelativeTo(parent);
        
        
        }
	public String getRating() {
		return rating.getText().trim();
	}
	public String getReview() {
        return textArea.getText().trim(); 
    }
	public String getResName() {
        return tfResName.getText().trim(); 
    }
	public String getResLoc() {
        return tfResLoc.getText().trim(); 
    }
	
	public boolean reviewSuccess() {
        return revSuccess;
    }
	
	/*private static void createAndShowGUI() {
        JFrame frame = new JFrame("Review");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new WriteReview(frame));
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    } */
	
}