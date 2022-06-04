package library.entity;

import java.util.GregorianCalendar;

import library.util.InputUtil;
import library.util.Outputter;

/**
 * This factory is used to create item of library. This class applies Singleton
 * Pattern to make sure there will be only one instance of Class.
 * 
 * @author communicated@yeah.net
 * @version 29 Nov 2009
 * @since 1.6
 * 
 */
public class ItemFactory
{
	private static ItemFactory itemFactory;

	static
	{
		itemFactory = new ItemFactory();
	}

	private ItemFactory()
	{
	}

	public static ItemFactory getInstance()
	{
		return itemFactory;
	}

	/**
	 * Create item for library based on user input.
	 * 
	 * @param category
	 *            - the category of item
	 * @return the item created
	 * @see Category
	 */
	public Item createItem(Category category)
	{
		Item item = null;
		switch (category)
		{
		case BOOK:
			return createBook();
		case PERIODICAL:
			return createPeriodical();
		case DVD:
			return createDvd();
		}
		return item;
	}

	private Item createBook()
	{
		Outputter.println("Please input Book information:");
		// title, author, publication date, publisher name, edition
		String title = InputUtil.getString("Title");
		String author = InputUtil.getString("Author");
		int year = InputUtil.getInt("PublicationDate-Year");
		int month = InputUtil.getInt("PublicationDate-Month");
		int day = InputUtil.getInt("PublicationDate-Day");
		String publisherName = InputUtil.getString("Publisher Name");
		int edition = InputUtil.getInt("Edition");

		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setPublicationDate(new GregorianCalendar(year, month - 1, day)
				.getTime());
		b.setPublisherName(publisherName);
		b.setEdition(edition);

		return b;
	}

	private Item createPeriodical()
	{
		Outputter.println("Please input Periodical information:");
		// title, author, publication date, periodical name, pages range
		String title = InputUtil.getString("Title");
		String author = InputUtil.getString("Author");
		int year = InputUtil.getInt("PublicationDate-Year");
		int month = InputUtil.getInt("PublicationDate-Month");
		int day = InputUtil.getInt("PublicationDate-Day");
		String periodicalName = InputUtil.getString("Periodical Name");
		int startPage = InputUtil.getInt("Page Start");
		int endPage = InputUtil.getInt("Page End");

		Periodical p = new Periodical();
		p.setTitle(title);
		p.setAuthor(author);
		p.setPublicationDate(new GregorianCalendar(year, month - 1, day)
				.getTime());
		p.setPeriodicalName(periodicalName);
		p.setStartPage(startPage);
		p.setEndPage(endPage);

		return p;
	}

	private Item createDvd()
	{
		Outputter.println("Please input Dvd information:");
		// artist, title, publication date, genre
		String title = InputUtil.getString("Title");
		String artist = InputUtil.getString("Artist");
		int year = InputUtil.getInt("PublicationDate-Year");
		int month = InputUtil.getInt("PublicationDate-Month");
		int day = InputUtil.getInt("PublicationDate-Day");
		String genre = InputUtil.getString("Genre");

		Dvd d = new Dvd();
		d.setTitle(title);
		d.setAuthor(artist);
		d.setPublicationDate(new GregorianCalendar(year, month - 1, day)
				.getTime());
		d.setGenre(genre);

		return d;
	}
}
