import java.util.ArrayList;

public abstract class UserComponent{

		public abstract int getSize();
	
		public void add(UserComponent newUserComponent){
			throw new UnsupportedOperationException();
		}
		
		public void remove(UserComponent newUserComponent){
			throw new UnsupportedOperationException();
		}
		
		public ArrayList<UserComponent> getComponents(){
			throw new UnsupportedOperationException();
		}
		
		public String getID(){
			throw new UnsupportedOperationException();
		}
}
