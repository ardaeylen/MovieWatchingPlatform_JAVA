package Controllers;
import java.util.ArrayList;

import Models.Movie;
public class MovieController 
{
	private ArrayList<Movie> topMovies;
	private ArrayList<Movie> actionMovies;
	private ArrayList<Movie> comedyMovies;
	private ArrayList<Movie> dramaMovies;
	private ArrayList<Movie> horrorMovies;
	private ArrayList<Movie> mysteryMovies;
	private ArrayList<Movie> romanceMovies;
	private ArrayList<Movie> animationMovies;
	
	public MovieController()
	{
		actionMovies = new ArrayList<Movie>();
		actionMovies.add(new Movie("Black Widow","Action",2,13,2021));
		actionMovies.add(new Movie("Fast & Furious","Action",2,16,2021));
		actionMovies.add(new Movie("SkyFall","Action",2,18,2021));
		actionMovies.add(new Movie("Spiderman (No Way Home)","Action",2,13,2021));
		actionMovies.add(new Movie("Matrix","Action",2,18,2021));
		actionMovies.add(new Movie("Tenet","Action",2,13,2021));
		
		dramaMovies = new ArrayList<Movie>();
		dramaMovies.add(new Movie("Joker","Drama",2,18,2019));
		dramaMovies.add(new Movie("Fifth Shades Of Gray","Drama",2,18,2015));
		dramaMovies.add(new Movie("GodFather","Drama",2,18,1974));
		dramaMovies.add(new Movie("A Beautiful Mind","Drama",2,13,2021));
		dramaMovies.add(new Movie("Pulp Fiction","Drama",2,18,1994));
		dramaMovies.add(new Movie("Forrest Gump","Drama",2,13,1994));
		
		comedyMovies = new ArrayList<Movie>();
		comedyMovies.add(new Movie("Hangover","Comedy",2,16,2010));
		comedyMovies.add(new Movie("Scary Movie","Comedy",2,16,2000));
		comedyMovies.add(new Movie("American Pie","Comedy",2,18,1999));
		comedyMovies.add(new Movie("Pulp Fiction","Comedy",2,18,1994));
		comedyMovies.add(new Movie("Home Alone","Comedy",2,0,1994));
		comedyMovies.add(new Movie("Once Upon a Time in Hollywood","Comedy",2,16,2019));
		comedyMovies.add(new Movie("Snatch","Comedy",2,18,2000));
		
		horrorMovies = new ArrayList<Movie>();
		horrorMovies.add(new Movie("No Escape","Horror",2,18,2020));
		horrorMovies.add(new Movie("BirdBox","Horror",2,18,2018));
		horrorMovies.add(new Movie("Circle","Horror",2,18,2020));
		
		mysteryMovies = new ArrayList<Movie>();
		mysteryMovies.add(new Movie("Seven","Mystery",2,18,1995));
		mysteryMovies.add(new Movie("Brick","Mystery",2,18,2005));
		mysteryMovies.add(new Movie("Memento","Mystery",2,18,2000));
		mysteryMovies.add(new Movie("Knives Out","Mystery",2,18,2019));
		
		romanceMovies = new ArrayList<Movie>();
		romanceMovies.add(new Movie("The Photograph","Romance",2,16,2020));
		romanceMovies.add(new Movie("Portrait Of a Lady On Fire","Romance",2,16,2019));
		romanceMovies.add(new Movie("Call Me By Your Name","Romance",2,16,2017));
		romanceMovies.add(new Movie("A Star Is Born","Romance",2,16,2018));
		romanceMovies.add(new Movie("Carol","Romance",2,16,2015));
		
		animationMovies = new ArrayList<Movie>();
		animationMovies.add(new Movie("Moana","Animation",2,0,2016));
		animationMovies.add(new Movie("Zootropolis","Animation",2,0,2016));
		animationMovies.add(new Movie("Boss Baby","Animation",2,0,2017));
		
		topMovies = new ArrayList<Movie>();
		topMovies.add(new Movie("Shawshank Redemption","Best",2,13,1994));
		topMovies.add(new Movie("GodFather","Best",2,18,1972));
		topMovies.add(new Movie("Dark Knight","Best",2,16,2008));
		topMovies.add(new Movie("Lord Of The Rings","Best",3,16,2003));
		topMovies.add(new Movie("The Good, The Bad And The Ugly","Best",3,15,1966));
		topMovies.add(new Movie("Fight Club","Best",2,18,1999));
	}
	public ArrayList<Movie> getTopMovies() 
	{
		return topMovies;
	}
	public ArrayList<Movie> getActionMovies() 
	{
		return actionMovies;
	}
	public ArrayList<Movie> getComedyMovies() 
	{
		return comedyMovies;
	}
	public ArrayList<Movie> getDramaMovies() 
	{
		return dramaMovies;
	}

	public ArrayList<Movie> getHorrorMovies()
	{
		return horrorMovies;
	}
	public ArrayList<Movie> getMysteryMovies()
	{
		return mysteryMovies;
	}

	public ArrayList<Movie> getRomanceMovies() 
	{
		return romanceMovies;
	}
	
	public ArrayList<Movie> getAnimationMovies() 
	{
		return animationMovies;
	}

}
