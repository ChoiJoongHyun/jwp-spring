package next.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;

import next.controller.user.UserController;
import next.dao.UserDao;
import next.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserSessionUtilsTest {

	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserController controller;
	
	@Test
	public void insert() throws Exception {
		User user = new User("test", "password", "name", "");
		controller.create(user);
		verify(userDao).insert(user);
		//when verify 가 가장 많이 사용된다.
		
	}
	
	@Test
	public void profile() throws Exception{
		//fail("Not yet implemented");
		when(userDao.findByUserId("test")).thenReturn(new User("test", "password", "name", ""));
		ExtendedModelMap model = new ExtendedModelMap();
		controller.profile("test", model);
		
		User user = (User) model.get("user");
		System.out.println("User : " + user);
	}
	
	

}
