package Models;

public class Movie 
{

	private String title;
	private String type;
	private int hour;
	private int minAgeLimit;
	private int year;
	public Movie(String title,String type,int hour,int minAgeLimit,int year)
	{
		setTitle(title);
		setType(type);
		setHour(hour);
		setMinAgeLimit(minAgeLimit);
		setYear(year);
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public int getMinAgeLimit() 
	{
		return minAgeLimit;
	}
	public void setMinAgeLimit(int minAgeLimit) 
	{
		this.minAgeLimit = minAgeLimit;
	}

	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public int getHour() 
	{
		return hour;
	}
	public void setHour(int hour) 
	{
		this.hour = hour;
	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	
}
