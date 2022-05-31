package library.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import library.entity.Book;
import library.entity.Dvd;
import library.entity.Item;
import library.entity.Periodical;
import library.entity.User;

/**
 * Util class RecordGenerator is used to generate randomly initial 
 * data for library application.
 * The initial data includes users and items with random number.
 * 
 * @author Wenzheng Liang
 * @version 3.0, 29/11/2009
 * @since 1.6
 */
public class RecordGenerator
{
	private static final int NUMBER = 50;
	private static Random random = new Random();
	
	/**
	 * Generate users for library randomly.
	 * @return the array of generated users.
	 */
	public static User[] generateUsers()
	{
		List<User> result = new LinkedList<User>();
		int number = random.nextInt(NUMBER);
		
		for(int i = 0; i < number; i++)
		{
			User user = new User();
			user.setName("Name " + i);
			user.setAddress("Address " + i);
			result.add(user);
		}
		return result.toArray(new User[0]);
	}
	
	/**
	 * Generate items for library randomly.
	 * @return the array of generated items.
	 */
	public static Item[] generateItems()
	{
		List<Item> result = new LinkedList<Item>();
		Book[] books = generateBooks(random.nextInt(NUMBER));
		Periodical[] periodicals = generatePeriodicals(random.nextInt(NUMBER));
		Dvd[] dvds = generateDvds(random.nextInt(NUMBER));
		
		for(Book b : books)
		{
			result.add(b);
		}
		
		for(Periodical p : periodicals)
		{
			result.add(p);
		}
		
		for(Dvd d : dvds)
		{
			result.add(d);
		}
		
		return result.toArray(new Item[0]);
	}
	
	private static Book[] generateBooks(int number)
	{
		List<Item> result = new LinkedList<Item>();
		
		for(int i = 0; i < number; i++)
		{
			Book book = new Book();
			book.setTitle("Title " + i);
			book.setAuthor("Author " + i);
			book.setPublicationDate(new Date());
			book.setPublisherName("Publisher Name " + i);
			book.setEdition(i);
			result.add(book);
		}
		return result.toArray(new Book[0]);
	}
	
	private static Periodical[] generatePeriodicals(int number)
	{
		List<Item> result = new LinkedList<Item>();
		
		for(int i = 0; i < number; i++)
		{
			Periodical p = new Periodical();
			p.setTitle("Title " + i);
			p.setAuthor("Author " + i);
			p.setPeriodicalName("Periodical Name " + i);
			p.setPublicationDate(new Date());
			p.setStartPage(i);
			p.setEndPage(i + 5);
			result.add(p);
		}
		return result.toArray(new Periodical[0]);
	}
	
	private static Dvd[] generateDvds(int number)
	{
		List<Item> result = new LinkedList<Item>();
		
		for(int i = 0; i < number; i++)
		{
			Dvd d = new Dvd();
			d.setTitle("Title " + i);
			d.setAuthor("Artist " + i);
			d.setPublicationDate(new Date());
			d.setGenre("Genre " + i);
			result.add(d);
		}
		return result.toArray(new Dvd[0]);
	}
}
