package com.jason.bookstore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jason.bookstore.dao.UserDao;
import com.jason.bookstore.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		Session session = getSessionFactory().getCurrentSession();
		if(session == null){
			session = getSessionFactory().openSession();
		}
		return session;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public User findUser(User user) {
		Query query = getSession().createQuery("from User where username= :username and password = :password");
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
        User res = (User) query.uniqueResult();
		return res;
	}

}
