/**
 * 
 */
package library.entity;

import java.util.Date;

import library.exception.CheckInException;
import library.exception.CheckOutException;
import library.util.ArrayOutputter;
import library.util.DateUtil;

/**
 * This abstract class represents the item of the library. Each item owns the
 * specific category, such as book, periodical and dvd.
 * 
 * The basic information of an item includes: Library code, type, title, author,
 * publicationDate, available
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * @see ArrayOutputter
 * 
 */
public abstract class Item implements ArrayOutputter
{
	// the unique library code
	private int code;

	// the title of the item
	private String title;

	// the author of the item, such as author of book or artist of dvd
	private String author;

	// the publication date of the item
	private Date publicationDate;

	// the status of the item, true stands for available; false stands for on
	// loan default is available.
	private boolean available = true;

	// each item belongs to a loan or not
	private Loan loan;

	public Loan getLoan()
	{
		return loan;
	}

	public void setLoan(Loan loan)
	{
		this.loan = loan;
	}

	/**
	 * Check in an item back to library.
	 */
	public void checkIn()
	{
		if (isAvailable())
		{
			throw new CheckInException("The item with code " + code
					+ " is not on loan.");
		} else
		{
			// set available of the item
			setAvailable(true);
			// remove loan from user
			this.loan.getUser().returnBack(this.loan);
			// reset the loan
			this.loan = null;
		}
	}
	
	/**
	 * Check out an item from library.
	 * @param user - the user who borrow the item
	 */
	public void checkOut(User user)
	{
		if (isAvailable())
		{
			// set available for item
			setAvailable(false);

			// create a new loan
			Loan loan = new Loan(user, this, new Date());
			// associate item with loan
			setLoan(loan);
			// associate user with loan
			user.borrow(loan);
		} else
		{
			throw new CheckOutException("The item with code " + code
					+ " is unavailable.");
		}
	}

	/**
	 * Getter and Setter of each field
	 */
	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getPublicationDate()
	{
		return publicationDate;
	}

	public void setPublicationDate(Date date)
	{
		this.publicationDate = date;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Return the status of item
	 * @return true if the item is available, or else return false;
	 */
	public boolean isAvailable()
	{
		return available;
	}

	public void setAvailable(boolean available)
	{
		this.available = available;
	}

	public String toString()
	{
		return "Library Code:" + this.code + "\nCategory:" + this.getCategory()
				+ "\nTitle:" + this.title + "\nAuthor:" + this.author
				+ "\nPublish Date:" + DateUtil.getDateString(this.publicationDate) + "\nAvailable:"
				+ (available == true ? "YES" : "NO") + "\n";
	}

	public String getString()
	{
		return String.format("%1$8d %2$16s %3$15s %4$15s %5$8s", code,
				getCategory(), title, author,
				(available == true ? "YES" : "NO"));
	}

	public String getHeader()
	{
		return String.format("%1$12s %2$12s %3$15s %4$15s %5$10s",
				"Library Code", "Category", "Title", "Author", "Available");
	}

	/**
	 * Abstract method which is used to return category of the specific item.
	 * 
	 * @see Category
	 */
	public abstract Category getCategory();
}