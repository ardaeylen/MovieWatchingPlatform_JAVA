package Views;
import javax.swing.*;
import Controllers.*;
import Models.Account;

import java.awt.Cursor;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.*;
public class LoginPage extends JFrame
{
	
	JLabel userNameLabel;
	JTextField userNameText;
	JLabel passwordLabel;
	JLabel warningLabel;
	JPasswordField passwordText;
	JButton loginButton;
	JButton signinButton;
	public LoginPage(String title)
	{
		super(title);
		initializePage();
	}
	private void initializePage()
	{
		
		//initialize components
		
		
		userNameLabel = new JLabel("Username");
		userNameLabel.setForeground(Color.WHITE);
		
		userNameText = new JTextField(35);
		
		
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		
		warningLabel = new JLabel("");
		warningLabel.setForeground(Color.RED);
		
		passwordText = new JPasswordField(35);
		
		
		loginButton = new JButton("Login");
		loginButton.setBackground(new Color(120,5,190));
		loginButton.setBorderPainted(false);
		loginButton.setForeground(Color.WHITE);
		loginButton.addActionListener(
				
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							try
							{
								if(userNameText.getText().isEmpty() || passwordText.getPassword().length == 0)
								{
									warningLabel.setText("Fill the required fields to Login");
								}
								else
								{
									warningLabel.setText("");
									Account account = Database.login(userNameText.getText(),new String(passwordText.getPassword()));
									if(account!= null)
									{
										getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));//Waiting Cursor
										MainPage mainPage = new MainPage(account);
										dispose();
									}
									else
									{
										System.out.println("Giris islemi basarisiz.");
									}
									
									getContentPane().setCursor(Cursor.getDefaultCursor());
								}
							}
							catch(NullPointerException npe)
							{
								System.out.println(npe.getMessage());
							}
						}
					}
				);
		
		
		signinButton = new JButton("Sign up");
		signinButton.setBackground(new Color(120,5,190));
		signinButton.setBorderPainted(false);
		signinButton.setForeground(Color.WHITE);
		signinButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						SigninPage sp = new SigninPage("Join us!");
						dispose();
					}
				}
				);
		
		//initialize Layout
		Container cont = this.getContentPane();
		cont.setLayout(new GridBagLayout());
		
		//initialize constraints
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,10,5,5);//top-left-bottom-right	
		constraints.ipady = 3;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		cont.add(userNameLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		cont.add(userNameText,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		cont.add(passwordLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		cont.add(passwordText,constraints);
		
		constraints.insets = new Insets(35,10,5,10);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		cont.add(loginButton,constraints);
		
		constraints.insets = new Insets(5,10,10,10);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		cont.add(signinButton,constraints);
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 10;
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		cont.add(warningLabel,constraints);
		
		
		cont.setBackground(new Color(100,100,150));
		setVisible(true);
		setSize(840,840);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
