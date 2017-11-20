package menuClasses;

import java.util.ArrayList;

public class AlterListContentMenu extends Menu{
	private static AlterListContentMenu ALCM = new AlterListContentMenu();
	public AlterListContentMenu() {
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Statistics on Lists"; 
		options.add(new Option("Add a New Value to a List", new AddToListAction())); 
		options.add(new Option("Delete a Position form a List", new DeleteFromListAction())); 
		options.add(new Option("Show Content of a List", new ShowListAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 
	}
	
	public static AlterListContentMenu getAlterListContentMenu() {
		return ALCM;
	}
}
