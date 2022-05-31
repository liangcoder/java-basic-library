package library.entity;

/**
 * This class is a subclass of Class Item, represents the specific category of
 * item in the library.
 * The basic information of a periodical includes:
 * title, author, publication date, periodical name, pages range
 * 
 * @author Wenzheng Liang
 * @version 29 Nov 2009
 * @since 1.6
 * @see Item
 *
 */
public class Periodical extends Item
{
	// end page of range
	private int endPage;
	
	// start page of range
	private int startPage;
	
	// name periodical
	private String periodicalName;

	/** 
	 * Getter and Setter of each field
	 */
	public Integer getEndPage()
	{
		return endPage;
	}

	public void setEndPage(int endPage)
	{
		this.endPage = endPage;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public String getPeriodicalName()
	{
		return periodicalName;
	}

	public void setPeriodicalName(String periodicalName)
	{
		this.periodicalName = periodicalName;
	}
	
	/** 
	 * Return the category of periodical.
	 * 
	 * @see Item#getCategory()
	 */
	public Category getCategory()
	{
		return Category.PERIODICAL;
	}
	
	public String toString()
	{
		return super.toString() + "Periodical Name:" + this.periodicalName+ "\nPages range:" + this.startPage+ "~" + this.endPage+ "\n";
	}
}