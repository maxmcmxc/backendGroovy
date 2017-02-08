package spark.gradle

import java.util.List

class UserDao {

	List<User> userList;
	
	static countEntries = 0
	
	UserDao(){
		
		userList = []
		userList.add(new User(0,"fromentin", "maxence"))
		countEntries++
		userList.add(new User(1,"michel", "michel"))
		countEntries++
		
	}
	
	def getUserList(){
		
		this.userList
		
	}
	
	def find(id){
		User u
		this.userList.each { User ->
			if (id == User.id) u = User		
		}
		u
	}
	
	def createUser(name,firstName){
		
		User u = new User(countEntries, name, firstName)
		countEntries++
		
		find(countEntries-1)
		
		
	}
	
}
