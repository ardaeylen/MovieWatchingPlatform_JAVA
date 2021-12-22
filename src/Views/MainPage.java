package Views;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Controllers.MovieController;

import java.awt.*;
import java.util.ArrayList;

import Models.Account;
import Models.Movie;
import Models.SubscriptionAccount;
import java.awt.event.*;
public class MainPage extends JFrame
{
	Account account;
	ArrayList<JButton> movieButtons;
	
	
	private ChangeMovieContent innerListener; 
	private MovieController movieController;
	private JPanel mainPanel;
	private JPanel leftMenuPanel;
	private JPanel moviesPanel;
	private JPanel sequentialMoviesPanel;
	
	
	private JButton filmArea;
	private JButton profileButton;
	private JButton actionMovieB;
	private JButton comedyMovieB;
	private JButton dramaMovieB;
	private JButton horrorMovieB;
	private JButton mysteryMovieB;
	private JButton romanceMovieB;
	private JButton animationMovieB;
	private JButton backButton;
	
	public MainPage(Account account)//Main page initialized with the user that has been logged in
	{
		super("DemoFlix");
		this.account = account;
		initializePage();
		System.out.println("Our Family : \n Free members: "+Account.freeAccountCounter+"\n"+
				"Basic members : "+Account.basicAccountCounter+"\n"+
				"Standard Members: "+Account.standardAccountCounter+"\n"+
				"Special Members : "+ Account.specialAccountCounter+"\n"+
				"Total :"+ Account.accountNumber);
	}
	private void initializePage()
	{
		innerListener = new ChangeMovieContent();
		movieController = new MovieController();
		mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(account.getUserName()));
		mainPanel.setLayout(new BorderLayout());
		
		leftMenuPanel = new JPanel();
		leftMenuPanel.setLayout(new GridLayout(9,1));
		leftMenuPanel.setBackground(Color.BLACK);
		
		
		profileButton = new JButton(account.getName());
		profileButton.setBackground(Color.WHITE);
		profileButton.setForeground(new Color(100,100,150));
		profileButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ProfilePage profilePage = new ProfilePage(account);
						dispose();
					}
				}
				);
		
		actionMovieB= new JButton("Action Movies");
		actionMovieB.setBackground(new Color(120,5,190));
		actionMovieB.setForeground(Color.WHITE);
		actionMovieB.addActionListener(innerListener);
		
		comedyMovieB = new JButton("Comedy Movies");
		comedyMovieB.setBackground(new Color(120,5,190));
		comedyMovieB.setForeground(Color.WHITE);
		comedyMovieB.addActionListener(innerListener);
		
		dramaMovieB = new JButton("Drama Movies");
		dramaMovieB.setBackground(new Color(120,5,190));
		dramaMovieB.setForeground(Color.WHITE);
		dramaMovieB.addActionListener(innerListener);
		
		horrorMovieB = new JButton("Horror Movies");
		horrorMovieB.setBackground(new Color(120,5,190));
		horrorMovieB.setForeground(Color.WHITE);
		horrorMovieB.addActionListener(innerListener);
		
		mysteryMovieB = new JButton("Mystery Movies");
		mysteryMovieB.setBackground(new Color(120,5,190));
		mysteryMovieB.setForeground(Color.WHITE);
		mysteryMovieB.addActionListener(innerListener);
		
		romanceMovieB = new JButton("Romance Movies");
		romanceMovieB.setBackground(new Color(120,5,190));
		romanceMovieB.setForeground(Color.WHITE);
		romanceMovieB.addActionListener(innerListener);
		
		animationMovieB = new JButton("Animation Movies");
		animationMovieB.setBackground(new Color(120,5,190));
		animationMovieB.setForeground(Color.WHITE);
		animationMovieB.addActionListener(innerListener);
		
		backButton = new JButton("Back to the Login Page");
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						new LoginPage("DemoFlix");
						dispose();
					}
				});
		
		leftMenuPanel.add(profileButton);
		leftMenuPanel.add(actionMovieB);
		leftMenuPanel.add(comedyMovieB);
		leftMenuPanel.add(dramaMovieB);
		leftMenuPanel.add(horrorMovieB);
		leftMenuPanel.add(mysteryMovieB);
		leftMenuPanel.add(romanceMovieB);
		leftMenuPanel.add(animationMovieB);
		leftMenuPanel.add(backButton);
		
		moviesPanel = new JPanel();
		moviesPanel.setLayout(new BorderLayout());
		filmArea = new JButton("Movie Comes Here");
		filmArea.setBackground(Color.BLACK);
		filmArea.setForeground(Color.WHITE);
		moviesPanel.add(filmArea,BorderLayout.CENTER);
		sequentialMoviesPanel = new JPanel();
		initializeMovies(movieController.getTopMovies());
		
		mainPanel.add(moviesPanel,BorderLayout.CENTER);
		mainPanel.add(leftMenuPanel,BorderLayout.WEST);
		
		add(mainPanel);
		
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		setSize(840,840);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void initializeMovies(ArrayList<Movie> movies)
	{
		movieButtons = new ArrayList<JButton>(movies.size()); //Bottom Movie buttons are initialized with the number of chosen movie type 
		sequentialMoviesPanel.setLayout(new GridLayout(1,movieButtons.size()));
		sequentialMoviesPanel.removeAll();
		for(int i =0; i<movies.size(); i++)
		{
			JButton b = new JButton(movies.get(i).getTitle());
			movieButtons.add(b);
			b.setPreferredSize(new Dimension(200,240));
			b.setBackground(new Color(100,100,150));
			b.setForeground(Color.WHITE);
			b.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)//ActionListener for the bottom movie panel
						{
							Movie temp = movies.get(movieButtons.indexOf(ae.getSource())); //Select the movie that has the same index with the movieButton
							if(account.isParentalControl() && temp.getMinAgeLimit() == 18)//the movie button
							{//If the user has parental control don't show the movie
								filmArea.setText("You can not watch this movie, this content is "+ 
							String.valueOf(temp.getMinAgeLimit())+"+");
							}
							else
							{
								if(account.getClass().getSimpleName().equals("FreeAccount"))
								{
									filmArea.setText("Watch 20 minutes of "+temp.getTitle()+" in 480p");	
								}
								else
								{
									SubscriptionAccount tempSub = (SubscriptionAccount)account;
									if(tempSub.getSubscriptionModel().equals("Basic"))
										filmArea.setText("Watch  full of "+temp.getTitle()+" in 480p");	
									
									else if(tempSub.getSubscriptionModel().equals("Standard"))
										filmArea.setText("Watch  full of "+temp.getTitle()+" in 720p");	
									else
										filmArea.setText("Watch  full of "+temp.getTitle()+" in 1080p");	


								}
								
							}
						}
					}
			);
			sequentialMoviesPanel.add(b);
		}
		moviesPanel.add(sequentialMoviesPanel,BorderLayout.SOUTH);
		this.validate();
	}
	
	class ChangeMovieContent implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{//The listener area that changes bottom movie content according to left panel buttons actions
			//The action listener of the left panel buttons
			sequentialMoviesPanel.invalidate();
			if(e.getSource() == actionMovieB)
			{
				initializeMovies(movieController.getActionMovies());
			}
			if(e.getSource() == comedyMovieB)
			{
				initializeMovies(movieController.getComedyMovies());
			}
			if(e.getSource() == horrorMovieB)
			{
				initializeMovies(movieController.getHorrorMovies());
			}
			if(e.getSource() == mysteryMovieB)
			{
				initializeMovies(movieController.getMysteryMovies());
			}
			if(e.getSource() == dramaMovieB)
			{
				initializeMovies(movieController.getDramaMovies());
			}
			if(e.getSource() == romanceMovieB)
			{
				initializeMovies(movieController.getRomanceMovies());
			}
			if(e.getSource() == animationMovieB)
			{
				initializeMovies(movieController.getAnimationMovies());
			}
		}
	}
}
