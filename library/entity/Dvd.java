package library.entity;

/**
 * This class is a subclass of Class Item, represents the specific category of
 * item in the library. The basic information of Dvd includes: artist, title,
 * publication date, genre
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * @see Item
 */
public class Dvd extends Item
{
	// genre of dvd
	private String genre;

	/**
	 * Getter and Setter of each field
	 */
	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	/**
	 * Return the category of dvd.
	 * 
	 * @see Item#getCategory()
	 */
	public Category getCategory()
	{
		return Category.DVD;
	}

	public String toSring()
	{
		return super.toString() + "Genre:" + this.genre + "\n";
	}
}