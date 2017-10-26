import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Account {
	private String line;
	private boolean exists;
	
	/**
	 * login user if the account exists and the password is correct
	 * @param usr username
	 * @param pas password
	 */
	public void login(String usr, String pas)
	{
		exists=false;
		try(BufferedReader br = new BufferedReader(new FileReader("accounts.txt")))
		{
			while ((line = br.readLine()) != null) {	//reads one line at a time
			    String[] words = line.split(" ");		//puts each word in an element in array words. defines different words by an empty space " "
			    if(words[0].equals(usr))				//checks first word in the line(username)
			    {
			    	exists=true;
			    	if(words[1].equals(pas))			//checks second word in line(password)
			    	{
			    		System.out.println("You have sucesfully loged in");	//latter replace with actually login in the account
			    		break;	//exit the while loop since it already found what it was looking for
			    	}
			    	else System.out.println("Incorrect password");
			    }
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
		if(!exists)
			System.out.println("Username does not exist");
	}
	/**
	 * Creates a new account if one with the same username does not already exist
	 * @param usr desired username
	 * @param pas desired password
	 */
	public void createAccount(String usr, String pas)
	{
		exists=false;
		try(BufferedReader br = new BufferedReader(new FileReader("accounts.txt")))	//checks and make sures username does not already exist
		{
			while ((line = br.readLine()) != null) {	//reads one line at a time
			    String[] words = line.split(" ");		//puts each word in an element in array words. defines different words by an empty space " "
			    if(words[0].equals(usr))				//checks first word in the line(username)
			    {
			    	exists=true;
			    	System.out.println("Username already exists");
			    	break;
			    }
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		if(!exists)
		{
			try {
				BufferedWriter add = new BufferedWriter(new FileWriter("accounts.txt", true));
				add.newLine();				//creates new line to end of file
				add.write(usr + " " + pas); //writes username and password to end of file with a space between the two
				add.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in writing to file");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Will add a review to the designated restaurant
	 * @param resturant name of the restaurant want to leave review for
	 * @param review what will be added as a review
	 */
	public void writeReview(String restaurant, String review) //currently if the restaurant1 doesn't already exist it will create a file for it
	{
		try {
			BufferedWriter add = new BufferedWriter(new FileWriter(restaurant + ".txt", true));		//write to file named after the restaurant
			add.newLine();
			add.write(username + ": " + review); 	//format username: rest of review
			add.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in writing to file");
			e.printStackTrace();
		}
	}
}
