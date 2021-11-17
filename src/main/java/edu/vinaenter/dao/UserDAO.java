package edu.vinaenter.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.vinaenter.models.User;
@Repository
public class UserDAO {
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "abc", "abc", "de-active"));
		list.add(new User(2, "abc2", "abc2", "active"));
		list.add(new User(3, "abc3", "abc3", "active"));
		return list;
	}

}
