
public class Driver {
	
	public static void main(String[] args) {
		
		UserList listOfUsers = new UserList();		
		//Give the AdminControlPanel the initial list of users
		AdminControlPanel frame = AdminControlPanel.getInstance(listOfUsers); 	
		frame.visible();
	}
}
