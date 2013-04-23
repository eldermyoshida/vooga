package arcade.games;

import util.Pixmap;
import arcade.database.Database;

public class UserData {
	
	/**
	 * This class is analogous to GameInfo and stores user-specific information.
	 * This class may replace the UserInfo class.
	 * 
	 * @author Eunsu (Joe) Ryu - jesryu
	 */
	
	private Database myDb;
	private String username;

	public UserData(Database db, String id){
		myDb = db;
		username = id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public Pixmap getAvatar() {
		return myDb.getAvatar(username);
	}
	
	public void changeAvatar(Pixmap newAvatar){
		//TODO
	}
	
	public String getName() {
		return myDb.getUserRealName(username);
	}
	
	public void changeName(String newName){
		//TODO
	}
	
	public int getAge(){
		return myDb.getUserAge(username);
	}
	
	public String getHometown(){
		return myDb.getUserHometown(username);
	}
	
	public void changeHometown (String newHometown) {
		//TODO
	}
	
	public String getSchool(){
		return myDb.getUserSchool(username);
	}
	
	public void changeSchool(String newSchool){
		//TODO
	}
	
	public String getHobbies(){
		return myDb.getUserHobbies(username);
	}
	
	public String getUserFavoriteColor(){
		return myDb.getUserFavoriteColor(username);
	}
	
}
