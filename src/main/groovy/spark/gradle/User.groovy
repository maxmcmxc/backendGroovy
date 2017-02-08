package spark.gradle

import java.util.concurrent.ConcurrentHashMap.ForEachEntryTask

import groovy.json.JsonBuilder

import groovy.json.JsonSlurper

class User {
		
		String id;
		
		String name;
		
		String firstName;
		
		def getId() {
			id;
		}

		def getName() {
			name;
		}

		def getFirstName() {
			firstName;
		}

		User(id,name,firstName){
			
			this.id = id
			this.name = name
			this.firstName = firstName
			
		}
		
}

class UserService {
		
			UserDao dao;
			
			//Initialize "embedded BDD with some entries"
			UserService(){
				
				dao = new UserDao()
				
			}
			
			def getAllUsers() {
				
				new JsonBuilder([response: dao.getUserList()])			
				
			}
			
			// returns a single user by id
			
			def getUser(String id) {
				
				User u = dao.find(id)
				u
				
			}
			
			// creates a new user
			
			def createUser(String name, String firstName) {  
				
				dao.getUserList()
				
			}
			
			// updates an existing user
			
			def updateUser(String id, String name, String firstName) { }
			
	}
