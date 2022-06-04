package library.entity;

/**
 * This is a subclass of Class Item, represents the specific category of item in
 * the library. The basic information of a book includes: title, author,
 * publication date, publisher name, edition.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * @see Item
 * 
 */
public class Book extends Item
{
	// edition of book
	private int edition;

	// publisher name of book
	private String publisherName;

	/**
	 * Getter and Setter of each field
	 */
	public int getEdition()
	{
		return edition;
	}

	public void setEdition(int edition)
	{
		this.edition = edition;
	}

	public String getPublisherName()
	{
		return publisherName;
	}

	public void setPublisherName(String publisherName)
	{
		this.publisherName = publisherName;
	}

	/**
	 * Return the category of book.
	 * 
	 * @see Item#getCategory()
	 */
	public Category getCategory()
	{
		return Category.BOOK;
	}

	public String toString()
	{
		return super.toString() + "Publisher Name:" + this.publisherName
				+ "\nEdition:" + this.edition + "\n";
	}
}