package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;



@DataJpaTest

public class AuthenticationTests {
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
	private UserRepository userRepository;
	//@Autowired
	//private UserService userService = new UserService();
    
    @Test
    public void whenFindByName_thenReturnUser() {
        // given
    	UserService userService = new UserService();
    	userService.setUserRepository(userRepository);
        User dummyUser = new User();
        dummyUser.setUsername("admin");
        dummyUser.setEmail("example@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();

        // when
        
        User found = userService.GetUserByUsername(dummyUser.getUsername());

        // then
        
        assertEquals(found.getUsername(), dummyUser.getUsername());
    }
    
    @Test
    public void whenFindByPassword_thenReturnUser() {
        // given
    	UserService userService = new UserService();
    	userService.setUserRepository(userRepository);
        User dummyUser = new User();
        dummyUser.setUsername("admin");
        dummyUser.setEmail("example@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();

        // when
        
        User found = userService.GetUserByPassword(dummyUser.getPassword());

        // then
        
        assertEquals(found.getUsername(), dummyUser.getUsername());
    }
    
    
    @Test
    public void whenNotCorrectUser_thenReturnFailure() {
        // given
    	UserService userService = new UserService();
    	userService.setUserRepository(userRepository);
        User dummyUser = new User();
        dummyUser.setUsername("admin");
        dummyUser.setEmail("example@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        User dummyUser2 = new User();
        dummyUser.setUsername("nottheadmin");
        dummyUser.setEmail("example2@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();


        // when
        
        User found = userService.GetUserByUsername(dummyUser2.getUsername());

        // then
        
        assertEquals(found, null);
    }
    
    @Test
    public void whenNotCorrectPassword_thenReturnFailure() {
        // given
    	UserService userService = new UserService();
    	userService.setUserRepository(userRepository);
        User dummyUser = new User();
        dummyUser.setUsername("admin");
        dummyUser.setEmail("example@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();

        // when
        
        User found = userService.GetUserByPassword("NotThePassword");

        // then
        
        assertEquals(found, null);
    }
    
    @Test
    public void whenFindByID_thenReturnUser() {
    	 // given
    	UserService userService = new UserService();
    	userService.setUserRepository(userRepository);
        User dummyUser = new User();
        dummyUser.setUsername("admin");
        dummyUser.setEmail("example@example.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        User found = userService.GetUserById(dummyUser.getId());

        // then
        
        assertEquals(found.getUsername(), dummyUser.getUsername());
    }

    
    





}
