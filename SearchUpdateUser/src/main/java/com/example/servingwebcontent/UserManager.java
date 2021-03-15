package com.example.servingwebcontent;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class UserManager {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
 
	
	public UserManager() {
		setup();
	}
	
    protected void setup() {
    	try {
            // Creating a registry
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            // Create the MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create the Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();

          } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
              StandardServiceRegistryBuilder.destroy(registry);
            }
          }
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
    
    protected boolean verifyCredentials(String username) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(User.class);
    	User user = (User) criteria.add(Restrictions.eq("username", username))
                .uniqueResult();
    	session.close();
    	if (user != null) {
    		return false;
    	}
    	return true;
    }
 
    protected boolean register(String first, String last, String username, String pass) {
        User user = new User();
        if (!verifyCredentials(username)) {
        	return false;
        }
        user.setFirstname(first);
        user.setLastname(last);
        user.setUsername(username);
        user.setPassword(pass);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(user);
     
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    protected User login(String username, String pass) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(User.class);
    	User user = (User) criteria.add(Restrictions.eq("username", username)).add(Restrictions.eq("password",pass))
                .uniqueResult();
    	session.close();
    	return user;
    }
    
    protected User getUser(String id) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(User.class);
    	User user = (User) criteria.add(Restrictions.eq("id", id))
                .uniqueResult();
    	session.close();
    	return user;
    }
 
    protected List<User> getUsers() {
    	Session session = sessionFactory.openSession();
    	String hql = "FROM user_tbl";
    	Query query = session.createQuery(hql, User.class);
    	List results = query.list();
    	session.close();
    	return results;
    }
}