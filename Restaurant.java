
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
	
	public String restaurantName="restaurant1";
	public String town;
	private String line;
	public boolean exists;
	public ArrayList<String> searchResult = new ArrayList<String>();
	
	public boolean getExists()
	{
		return exists;
	}
	
	public boolean restaurantSearch(String searchStr) {
		
		//public void parseFile(String searchStr) throws FileNotFoundException{
			exists = false; 

			
			try(BufferedReader br = new BufferedReader(new FileReader("restaurantList.txt"))) {
				while((line = br.readLine()) != null) {
					String[] words = line.split(":");		
				    if(words[0].contains(searchStr)) {
				    	searchResult.add(words[0]);
				    	exists = true;
				    	System.out.println(searchResult);
				    }
				    
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error file not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			
			if(searchResult.isEmpty()) {
				exists = false;
			}
			return exists;
			
			
		}
		
			
	
		
/*
	    public void parseFile(String searchStr) throws FileNotFoundException{
	        Scanner scan = new Scanner(new File("restaurantList.txt"));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toLowerCase().toString();
	            if(line.contains(searchStr)){
	                System.out.println(line);
	            }
	        }
	    }


	    public static void main(String[] args) throws FileNotFoundException{
	        restaurantSearch fileSearch = new restaurantSearch();
	        fileSearch.parseFile("src/main/resources/test.txt", "am");
	    }

	*/
	
	
	public String getRestaurantName() {
        return restaurantName;
    }

}
