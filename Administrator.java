package cse2102Project01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Administrator extends Account{
	private String line;
	
	/**
	 * Deletes a review
	 * 
	 * @param restaurant where the review was posted
	 * @param user	username of who wrote the review
	 * @param review Actual contents of the review
	 */
	public void deleteReview(String restaurant, String user, String review) //currently doesn't work
	{
		//basically copies all of the reviews except for the one that is supposed to be deleted
		//it does fully go through the while loop and the if statement does work as intended
		//however It doesn't seem to create the temporary location im not sure why
		//it also does not do the rename maybe because the file was never created, I really don't know why yet
		File tempFile = new File("tempFile.txt");
		File current = new File(restaurant + ".txt");
		try	
		{
			BufferedReader br = new BufferedReader(new FileReader(current));
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempFile.txt"));
			while ((line = br.readLine()) != null) {		
				//skip the review that is to be deleted
				if(line.equals(user+": " + review))
				{
					continue;
				}
				//add the line to the temparary location
				writer.write(line + System.getProperty("line.separator"));
				writer.write("Just checking if this acctualy works");
			}
			writer.close();
			br.close();
			//rename the tempary location to the name of the original postions effectively overwritting the original
			tempFile.renameTo(current);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in delting review: That restaurant doesn't exist");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in deleting review");
			e.printStackTrace();
		}
	}
	
	public boolean addRestaurant(String name, String town)
	{
		boolean exists=false;
		boolean created=false;
		
		try(BufferedReader br = new BufferedReader(new FileReader("restaurantList.txt")))
		{
			while ((line = br.readLine()) != null) {	
			    String[] words = line.split(":");		
			    if(words[0].equals(name))				
			    {
			    	exists=true;
			    	System.out.println("Restaurant already exists.");
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
				BufferedWriter add = new BufferedWriter(new FileWriter("restaurantList.txt", true));
				add.newLine();				
				add.write(name + ":" + town); 
				add.close();
				System.out.println("Restaurant added to directory");
				created=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in writing to file");
				e.printStackTrace();
			}
		}
		
		return created;
		
	}
			
}
