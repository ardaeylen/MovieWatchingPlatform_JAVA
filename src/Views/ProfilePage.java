package Views;
import javax.swing.*;
import Models.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
public class ProfilePage extends JFrame
{
	Account account;
	private JButton backButton;
	private JButton changeModelButton;
	private JLabel nameLabel;
	private JLabel surNameLabel;
	private JLabel eMailLabel;
	private JLabel parentalControlLabel;
	private JLabel renewDateLabel;//When the new membership starts
	private JLabel renewTimesLabel;
	private JLabel currentSubLabel;
	private JLabel previousSubLabel;
	
	public ProfilePage(Account account)
	{
		this.account = account;
		initializePage();
	}
	private void initializePage()
	{
		backButton = new JButton("Go back");
		backButton.setBackground(new Color(120,5,190));
		backButton.setBorderPainted(false);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						MainPage mp = new MainPage(account);
						dispose();
					}
				}
				);
		
		changeModelButton = new JButton("I want to hange my subscription model");
		changeModelButton.setBackground(new Color(120,5,190));
		changeModelButton.setBorderPainted(false);
		changeModelButton.setForeground(Color.WHITE);
		changeModelButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						SigninPage mp = new SigninPage(account);
						dispose();
					}
				}
				);
		
		nameLabel = new JLabel(account.getName());
		nameLabel.setForeground(Color.WHITE);
		
		surNameLabel = new JLabel(account.getSurName());
		surNameLabel.setForeground(Color.WHITE);
		
		eMailLabel = new JLabel(account.geteMail());		
		eMailLabel.setForeground(Color.WHITE);
		
		parentalControlLabel = new JLabel(account.isParentalControl() ? "This account is protected from inconvenient contents":
			"This account is not protected from inconvenient content");
		parentalControlLabel.setForeground(Color.WHITE);
		
		renewDateLabel = new JLabel("Membership starts at "+account.getRenewDate().toString());
		renewDateLabel.setForeground(Color.WHITE);
		
		renewTimesLabel= new JLabel("Renew Times "+String.valueOf(account.getRenewCounter()));
		renewTimesLabel.setForeground(Color.WHITE);
		
		previousSubLabel = new JLabel(account.getPreviousSubscriptionModel().isEmpty() ? "This account is your first account" :"Previous Account Model :"+account.getPreviousSubscriptionModel());
		previousSubLabel.setForeground(Color.WHITE);
		
		if(account.getClass().getSimpleName().equals("SubscriptionAccount"))
		{
			SubscriptionAccount subtemp = (SubscriptionAccount)account;
			currentSubLabel = new JLabel("Your Current Account Type : "+subtemp.getSubscriptionModel());
			
			
		}
		else
		{
			
			currentSubLabel = new JLabel("Your Current Account Type : Free Account with limited experience");
		}
		currentSubLabel.setForeground(Color.WHITE);
		
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.insets = new Insets(15,10,5,10);
		constraints.gridx = 0;
		constraints.gridy= 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipadx = 5;
		constraints.ipady = 5;
		container.add(nameLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 1;
		
		container.add(surNameLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 2;
		
		container.add(eMailLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 3;
		
		container.add(parentalControlLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 4;
		
		container.add(renewDateLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 5;
		
		container.add(renewTimesLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 6;
		
		container.add(currentSubLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 7;
		
		container.add(previousSubLabel,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 8;
		
		container.add(changeModelButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy= 9;
		
		container.add(backButton,constraints);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840,840);
		container.setBackground(new Color(100,100,150));
	}
}
