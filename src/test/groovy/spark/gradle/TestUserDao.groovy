package spark.gradle;

import static org.junit.Assert.*

import org.junit.Test

class TestUserDao {

	@Test
	public void testGetUserList() {
		UserDao daoTest = new UserDao();
		User userTest = new User(2,"test", "test")
		daoTest.userList.add(userTest)
		User userFound = daoTest.find('2')
		
		assert userTest.firstName == userFound.firstName
	}

	@Test
	public void testFind() {
//		fail("Not yet implemented");
	}

	@Test
	public void testCreateUser() {
//		fail("Not yet implemented");
	}

}
