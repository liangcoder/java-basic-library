package library.entity;

import java.util.LinkedList;
import java.util.List;

import library.util.ArrayOutputter;
import library.util.DateUtil;
import library.util.InputUtil;
import library.util.Outputter;

/**
 * This class represents the user of the library. The basic information of a
 * user includes: library id, name, address
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * @see ArrayOutputter
 */
public class User implements ArrayOutputter
{
	// unique id of user in the library
	private int id;

	// name of user
	private String name;

	// address of user
	private String address;

	// loans associated by user
	private List<Loan> loans;

	public User()
	{
		loans = new LinkedList<Loan>();
	}

	/**
	 * User borrow an item from library.
	 * 
	 * @param loan
	 *            - the loan associated with the user
	 */
	public void borrow(Loan loan)
	{
		loans.add(loan);
	}

	/**
	 * User return an item back to library.
	 * 
	 * @param loan
	 *            - the loan need to be remove
	 */
	public void returnBack(Loan loan)
	{
		int index = this.loans.indexOf(loan);

		if (index == -1)
		{
			throw new RuntimeException(
					"The loan doesn't associated with the user with id "
							+ this.id);
		} else
		{
			this.loans.remove(index);
		}
	}
	
	/**
	 * Create a user object.
	 * @return the object of user created
	 */
	public static User createUser()
	{
		Outputter.println("Please input user information:");
		//name, address
		String name = InputUtil.getString("Name");
		String address = InputUtil.getString("Address");
		
		User u = new User();
		u.setName(name);
		u.setAddress(address);
		return u;
	}

	public String toString()
	{
		return "Library ID:" + id + "\nName:" + name + "\nAddress:" + address
				+ "\n" + this.getLoanInfo();
	}
	
	/**
	 * Get information of all loans of the specific user.
	 * 
	 * @return the information of all loans
	 */
	public String getLoanInfo()
	{
		StringBuffer sb = new StringBuffer("List of items on loan:");
		if(this.loans.size() == 0)
		{
			sb.append("None");
			sb.append("\n");
			return sb.toString();
		}
		else
		{
			sb.append("\n");
		}
		
		int i = 1;
		for(Loan l : this.loans)
		{
			sb.append(i + ". ");
			sb.append("Library Code:");
			sb.append(l.getItem().getCode());
			sb.append(";");
			sb.append("Category:");
			sb.append(l.getItem().getCategory());
			sb.append(";");
			sb.append("Title:");
			sb.append(l.getItem().getTitle());
			sb.append(";");
			sb.append("Date of check out:");
			sb.append(DateUtil.getDateString(l.getDate()));
			sb.append("\n");
			i++;
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public String getHeader()
	{
		return String.format("%1$12s %2$12s %3$15s %4$15s",
				"Library ID", "Name", "Address", "Number of loan");
	}
	
	public String getString()
	{
		return String.format("%1$12s %2$12s %3$15s %4$10s",
				this.id, this.name, this.address, this.loans.size());
	}

	/**
	 * Getter and Setter of each field
	 */
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}