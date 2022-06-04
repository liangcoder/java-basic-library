package library.entity;

import java.util.Date;

/**
 * This class represents a loan of item in the library involves specific user.
 * The basic information of a loan includes:
 * user, item associating with the user and date of check out.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 *
 */
public class Loan
{
	// the user of loan
	private User user;
	
	// the item on loan
	private Item item;
	
	// the date of the loan
	private Date date;
	
	public Loan(User user, Item item, Date date)
	{
		this.user = user;
		this.item = item;
		this.date = date;
	}

	/** 
	 * Getter of each field
	 */
	public User getUser()
	{
		return user;
	}
	public Item getItem()
	{
		return item;
	}
	public Date getDate()
	{
		return date;
	}
}