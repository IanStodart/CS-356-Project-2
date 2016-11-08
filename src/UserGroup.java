import java.util.ArrayList;

public class UserGroup extends UserComponent{

	private String groupID;
	private ArrayList<UserComponent> userComponents;
	
	public UserGroup(String name){
		groupID = name;
		userComponents = new ArrayList<UserComponent>();
	}
	
	public String getID() {
		return groupID;
	}
	
	public int getSize() {
		return userComponents.size();
	}
	
	public ArrayList<UserComponent> getComponents(){
		return userComponents;
	}
	
	public void add(UserComponent u){
		userComponents.add(u);
	}
	
	public void remove(UserComponent u){
		userComponents.remove(u);
	}
}
