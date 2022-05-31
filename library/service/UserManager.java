package library.service;

import java.util.ArrayList;
import java.util.List;

import library.entity.User;
import library.exception.UserManagementException;

/**
 * Class UserManager provides management functionality for users of the library.
 * 
 * @see User
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 * 
 */
public class UserManager
{
	// the start number of library code
	private int nextId = 1000;

	// list of users of the library
	private List<User> users;

	public UserManager()
	{
		this.users = new ArrayList<User>();
	}

	public UserManager(int startId)
	{
		this();
		this.nextId = startId;
	}
	
	/**
	 * Validate whether the user with given id exists in the library or not. 
	 * @param id - the id of user
	 * @return true if the user with given id exists, or else, return false.
	 */
	public boolean validate(int id)
	{
		for(User u : this.users)
		{
			if(u.getId() == id)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Add a new user.
	 * 
	 * @param user - The new user contains detail information. 
	 *            The id of user should be null.
	 */
	public void addUser(User user)
	{
		user.setId(generateNextId());
		this.users.add(user);
	}

	/**
	 * Update detail information of existing user in the library. If exception
	 * occurs during the process of updating, throw UserManagementException.
	 * 
	 * @param user
	 *            -The user object contains detail information to update.
	 * @see UserManagementException
	 */
	public void updateUser(User user) throws UserManagementException
	{
		// the id of user must be set previously.
		if (user.getId() == 0)
		{
			throw new UserManagementException("The id of user is required when update.");
		}
		
		if(!validate(user.getId()))
		{
			throw new UserManagementException("No user with id " + user.getId());
		}

		User originalUser = getUserById(user.getId());
		originalUser.setName(user.getName());
		originalUser.setAddress(user.getAddress());
	}

	/**
	 * Query the specific user with id which is unique identification of user.
	 * If no user exists with given id, throw UserManagementException.
	 * 
	 * @param id
	 *            -Id of user.
	 * @return the user with given id.
	 * @see UserManagementException
	 */
	public User getUserById(int id) throws UserManagementException
	{
		for (User u : this.users)
		{
			if (u.getId() == id)
			{
				return u;
			}
		}
		throw new UserManagementException("No user with id " + id);
	}

	/**
	 * Get the number of users in the library.
	 * 
	 * @return the number of user
	 */
	public int getNumberOfUsers()
	{
		return this.users.size();
	}

	/**
	 * Get all the users in the library.
	 * 
	 * @return array of user of the library.
	 */
	public User[] getUsers()
	{
		return this.users.toArray(new User[0]);
	}

	private int generateNextId()
	{
		return nextId++;
	}
}
