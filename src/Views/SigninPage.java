package Views;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class SigninPage extends JFrame 
{
	static final int option1 = 1; //Monthly Plan Options
	static final int option2 = 4;//Monthly Plan Options
	static final int option3 = 7;//Monthly Plan Options
	FreeAccount freeAccount;  //Free account object reference variable (object will created depends on user's choice)
	SubscriptionAccount subscriptionAccount;//SubscriptionAccount object reference variable (object will created depends on user's choice)
	JLabel nameLabel;		//Some necessary JFrame components for the design
	JLabel surNameLabel;
	JLabel userNameLabel;
	JLabel passwordLabel;
	JLabel eMailLabel;
	JLabel monthlyPlanLabel;
	JLabel correctionLabel;
	JTextField nameText;
	JTextField surNameText;
	JTextField userNameText;
	JPasswordField passwordText;
	JTextField eMailText;
	
	JButton signInButton; 	
	JButton backToTheLogin;
	JComboBox<String> subscriptionMenu; //JFrame components that includes AccountModels
	
	JCheckBox parentalControl;
	JSlider monthlyPlan;
	public SigninPage(String label) //SigninPage Constructor to user to sign up
	{
		super(label);
		InýtýalizeComponent();
	}
	public SigninPage(Account account) //SigninPage Constructor to user to change his/her accountModel
	{
		super("Join us");
		InýtýalizeComponentForChange(account);
	}
	private void InýtýalizeComponent()		//Component and page initializer is encapsulated
	{
		nameLabel = new JLabel("Name ");
		nameLabel.setForeground(Color.WHITE);
		nameText = new JTextField(35);
		
		surNameLabel = new JLabel("Surname");
		surNameLabel.setForeground(Color.WHITE);
		surNameText = new JTextField(35);
		
		userNameLabel = new JLabel("Username");
		userNameLabel.setForeground(Color.WHITE);
		userNameText = new JTextField(35);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordText = new JPasswordField(35);
		
		eMailLabel = new JLabel("e-mail");
		eMailLabel.setForeground(Color.WHITE);
		eMailText = new JTextField(35);
		
		correctionLabel = new JLabel("");
		
		parentalControl = new JCheckBox("Parental Control");
		parentalControl.setBackground(new Color(120,5,190));
		parentalControl.setForeground(Color.WHITE);
		parentalControl.setEnabled(true);
		parentalControl.setBorderPainted(true);
		parentalControl.setFocusPainted(true);
		
		signInButton = new JButton("Sign up");
		signInButton.setBackground(new Color(120,5,190));
		signInButton.setBorderPainted(false);
		signInButton.setForeground(Color.WHITE);
		signInButton.addActionListener(						//Sign in Button Action Listener 
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//Try catch kullanýlacak
						if(!nameText.getText().isEmpty() && !surNameText.getText().isEmpty() && !userNameText.getText().isEmpty() &&
							passwordText.getPassword().length != 0 && !eMailText.getText().isEmpty())  //If there are no field empty
						{
							String tempName = nameText.getText();										//Get the informations from the fields
							String tempSurName = surNameText.getText();
							String tempUserName = userNameText.getText();
							String tempPassword = new String(passwordText.getPassword());
							String tempMail = eMailText.getText();
							int month = monthlyPlan.getValue();
							boolean control = parentalControl.isContentAreaFilled();
							boolean isAdded = false;
							if(subscriptionMenu.getSelectedItem().toString().contains("Free")) // Object reference variables are initialized depends on the Account Model																	  //
							{																//chosen from the JComboBox Component
								isAdded = Database.add(freeAccount = new FreeAccount(tempName,tempSurName,tempUserName,tempPassword,tempMail,control,1));
								//Database's static add function is called to add an Account to its Account LinedList
							}
							if(subscriptionMenu.getSelectedItem().toString().contains("Basic"))
							{	//AccountModel's first constructor is used to create an account not to change the account model 
								isAdded = Database.add(subscriptionAccount = new SubscriptionAccount(tempName,tempSurName,tempUserName,tempPassword,tempMail,"Basic",control,month));
								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
							}
							if(subscriptionMenu.getSelectedItem().toString().contains("Standard"))
							{
								isAdded = Database.add(subscriptionAccount = new SubscriptionAccount(tempName,tempSurName,tempUserName,tempPassword,tempMail,"Standard",control,month));
								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
							}
							if(subscriptionMenu.getSelectedItem().toString().contains("Full experience"))
							{
								isAdded = Database.add(subscriptionAccount = new SubscriptionAccount(tempName,tempSurName,tempUserName,tempPassword,tempMail,"Special",control,month));
								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
							
								//Payment message is send after signing operation if the chosen AccountModel is not FreeAccount  
							}
							if(isAdded)
							{
								correctionLabel.setForeground(Color.WHITE);     //
								correctionLabel.setText(" You Are Successfully Signed Up");	
							}
							if(!isAdded)
							{
								correctionLabel.setForeground(Color.RED);     //
								correctionLabel.setText("The Username has been using");	
							}
							
							
						}
						else
						{
							correctionLabel.setForeground(Color.RED);
							correctionLabel.setText("Fill the required informations");
							
						}
						
					}
				}
				);
		
		backToTheLogin = new JButton("Back To The Login Page");
		backToTheLogin.setBackground(new Color(120,5,190));
		backToTheLogin.setBorderPainted(false);
		backToTheLogin.setForeground(Color.WHITE);
		backToTheLogin.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						LoginPage lp = new LoginPage("DemoFlix");
						dispose();
					}
				}
				
				);
		
		
		correctionLabel = new JLabel("");
		
		monthlyPlanLabel = new JLabel("Choose your Monthly Plan");
		monthlyPlanLabel.setForeground(Color.WHITE);
		
		
		monthlyPlan = new JSlider(JSlider.HORIZONTAL,option1,option3,option2);
		monthlyPlan.setMajorTickSpacing(3);
		monthlyPlan.setMinorTickSpacing(1);
		monthlyPlan.setPaintTicks(true);
		monthlyPlan.setPaintLabels(true);
		monthlyPlan.setBackground(new Color(120,5,190));
		monthlyPlan.setForeground(Color.WHITE);
		monthlyPlan.setEnabled(false);
		
		subscriptionMenu = new JComboBox<String>(new String[]{"Get Limited Experience for Free","Basic Experience",
				"Standard Experience","Get Full Experience"});
	
		
		subscriptionMenu.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						if(subscriptionMenu.getSelectedItem().toString().contains("Free"))
						{
							monthlyPlan.setEnabled(false);
							
						}
						else
						{
							monthlyPlan.setEnabled(true);
						}
					}
				}
				);
		
		
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		
		//Inýtýalizing Constraints object
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(20,10,10,5);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipady = 3;
		constraints.gridwidth = 1;
		container.add(nameLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(nameText,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(surNameLabel,constraints);		
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(surNameText,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(userNameLabel,constraints);
		
		constraints.gridx =1;
		constraints.gridy = 2;
		container.add(userNameText,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(passwordLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		container.add(passwordText,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(eMailLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy=4;
		container.add(eMailText,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 3;
		container.add(subscriptionMenu,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		container.add(monthlyPlanLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		container.add(monthlyPlan,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 8;
		container.add(parentalControl,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridwidth = 2;
		container.add(signInButton,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		container.add(backToTheLogin,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 11;
		constraints.gridwidth = 2;
		container.add(correctionLabel,constraints);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840,840);
		container.setBackground(new Color(100,100,150));
		
	}
	private void InýtýalizeComponentForChange(Account account)
	{
		correctionLabel = new JLabel("");
		
		monthlyPlanLabel = new JLabel("Choose your Monthly Plan");
		monthlyPlanLabel.setForeground(Color.WHITE);
		
		signInButton = new JButton("Change the model");
		
		monthlyPlan = new JSlider(JSlider.HORIZONTAL,option1,option3,option2);
		monthlyPlan.setMajorTickSpacing(3);
		monthlyPlan.setMinorTickSpacing(1);
		monthlyPlan.setPaintTicks(true);
		monthlyPlan.setPaintLabels(true);
		monthlyPlan.setBackground(new Color(120,5,190));
		monthlyPlan.setForeground(Color.WHITE);
		monthlyPlan.setEnabled(true);
		
		parentalControl = new JCheckBox("Parental Control");
		parentalControl.setBackground(new Color(120,5,190));
		parentalControl.setForeground(Color.WHITE);
		parentalControl.setEnabled(true);
		parentalControl.setBorderPainted(true);
		parentalControl.setFocusPainted(true);
		
		if(account.getClass().getSimpleName().equals("SubscriptionAccount")) 
		{
				
				
					subscriptionMenu = new JComboBox<String>(new String[]{"Get Limited Experience for Free","Basic Experience",
							"Standard Experience","Get Full Experience"});
				
				subscriptionMenu.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						if(subscriptionMenu.getSelectedItem().toString().contains("Free"))
						{
							monthlyPlan.setEnabled(false);
							
						}
						else
						{
							monthlyPlan.setEnabled(true);
						}
					}
				}
				);
	
		}
		else
		{
			
			subscriptionMenu = new JComboBox<String>(new String[]{"Basic Experience",
					"Standard Experience","Get Full Experience"});
		
			subscriptionMenu.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							if(subscriptionMenu.getSelectedItem().toString().contains("Free"))
							{
								monthlyPlan.setEnabled(false);
					
							}
							else
							{
								monthlyPlan.setEnabled(true);
							}
						}
					}
			);
		}
		signInButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						int month = monthlyPlan.getValue();
						boolean control = parentalControl.isContentAreaFilled();
						String previousAccountModel = account.getClass().getSimpleName().equals("FreeAccount") ? "Free Account with limited experience" : ((SubscriptionAccount)account).getSubscriptionModel();
						
						
						if(subscriptionMenu.getSelectedItem().toString().contains("Free"))
						{
							if(Database.deleteAccount(account))
							{
								Database.add(freeAccount = new FreeAccount(account.getName(),account.getSurName(),account.getUserName()
										,account.getPassword(),account.geteMail(),control,1,previousAccountModel,account.getRenewCounter()));
								
								LoginPage redirect = new LoginPage("DemoFlix");
								dispose();	
							}
							
						}
						if(subscriptionMenu.getSelectedItem().toString().contains("Basic"))
						{
							if(Database.deleteAccount(account))
							{
								Database.add(subscriptionAccount = new SubscriptionAccount(account.getName(),account.getSurName(),account.getUserName()
										,account.getPassword(),account.geteMail(),"Basic",control,month,previousAccountModel,account.getRenewCounter()));

								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
								LoginPage redirect = new LoginPage("DemoFlix");
								dispose();	
							}
							
						}
						if(subscriptionMenu.getSelectedItem().toString().contains("Standard"))
						{
						
							if(Database.deleteAccount(account))
							{
								Database.add(subscriptionAccount = new SubscriptionAccount(account.getName(),account.getSurName(),account.getUserName()
										,account.getPassword(),account.geteMail(),"Standard",control,month,previousAccountModel,account.getRenewCounter()));
								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
								LoginPage redirect = new LoginPage("DemoFlix");
								dispose();	
							}
						}
						if(subscriptionMenu.getSelectedItem().toString().contains("Full Experience"))
						{
						
							if(Database.deleteAccount(account))
							{
								Database.add(subscriptionAccount = new SubscriptionAccount(account.getName(),account.getSurName(),account.getUserName()
										,account.getPassword(),account.geteMail(),"Special",control,month,previousAccountModel,account.getRenewCounter()));
								JOptionPane.showMessageDialog(new JFrame("Thank you for choosing us"),"Payment invoice for the membership is "+ subscriptionAccount.getPaymentInvoice()+"$");
							
								LoginPage redirect = new LoginPage("DemoFlix");
								dispose();	
							}
						}
						
					}
				}
				
				);
		
		Container c = this.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(20,10,10,5);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipady = 3;
		constraints.gridwidth = 2;
		c.add(subscriptionMenu,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		
		c.add(monthlyPlanLabel,constraints);
		

		constraints.gridx = 0;
		constraints.gridy = 2;
		
		c.add(monthlyPlan,constraints);
		

		constraints.gridx = 0;
		constraints.gridy = 3;
		
		c.add(parentalControl,constraints);
		

		constraints.gridx = 0;
		constraints.gridy = 4;
		
		c.add(signInButton,constraints);
		

		constraints.gridx = 0;
		constraints.gridy = 5;
		
		c.add(correctionLabel,constraints);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840,840);
		c.setBackground(new Color(100,100,150));
	}
	
}
