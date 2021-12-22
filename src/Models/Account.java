package Models;

import java.time.LocalDate;

public abstract class Account // Make the general account class abstract because the attributes that class have must be private							 //
{							
	// in interfaces, access modifiers only be public and types are only static and final
	public static int accountNumber = 0; // total amount of all accounts it is used for account id
	protected int accountId;
	protected String name;
	protected String surName;
	protected String userName;
	protected String password;
	protected String eMail;
	protected String previousSubscriptionModel;
	protected boolean parentalControl;
	protected LocalDate renewDate;//When the new membership starts
	protected int renewCounter = 0;
	protected LocalDate lastRenewDate;//When the membership ends
	protected int monthlyPlan;//How much month left
	
	public static int freeAccountCounter=0; //Account counters to hold the nuumber of account models
	public static int basicAccountCounter=0;
	public static int standardAccountCounter=0;
	public static int specialAccountCounter=0;
	
	public Account(String name,String surName,String userName,String password,String eMail,boolean parentalControl,int month)
	{
		accountNumber++;
		setAccountId(accountNumber);
		setName(name);
		setSurName(surName);
		setUserName(userName);
		setPassword(password);
		seteMail(eMail);
		setPreviousSubscriptionModel("");
		setParentalControl(parentalControl);
		setRenewDate(LocalDate.now());
		setMonthlyPlan(month);
		setLastRenewDate(renewDate.plusMonths(this.monthlyPlan));
		setRenewCounter(0);
	}
	
	public Account(String name,String surName,String userName,String password,String eMail,boolean parentalControl,int month,String previousSubscriptionModel,int renewCounter)
	{		//Account constructor for changing account model
		accountNumber++;
		setAccountId(accountNumber);
		setName(name);
		setSurName(surName);
		setUserName(userName);
		setPassword(password);
		seteMail(eMail);
		setPreviousSubscriptionModel(previousSubscriptionModel);
		decreaseAccountCounter(previousSubscriptionModel);
		setParentalControl(parentalControl);
		setRenewDate(LocalDate.now());
		setMonthlyPlan(month);
		setLastRenewDate(renewDate.plusMonths(this.monthlyPlan));
		setRenewCounter(++renewCounter);
	}
	public int getAccountId() 
	{
		return accountId;
	}
	
	public void setAccountId(int accountId) 
	{
		this.accountId = accountId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSurName() 
	{
		return surName;
	}
	
	public void setSurName(String surName) 
	{
		this.surName = surName;
	}
	
	public String geteMail() 
	{
		return eMail;
	}
	
	public void seteMail(String eMail) 
	{
		this.eMail = eMail;
	}
	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPreviousSubscriptionModel() 
	{
		return previousSubscriptionModel;
	}

	public void setPreviousSubscriptionModel(String previousSubscriptionModel) 
	{
		this.previousSubscriptionModel = previousSubscriptionModel;
	}
	public boolean isParentalControl() 
	{
		return parentalControl;
	}

	public void setParentalControl(boolean parentalControl) 
	{
		this.parentalControl = parentalControl;
	}
	public LocalDate getRenewDate() 
	{
		return renewDate;
	}
	public void setRenewDate(LocalDate renewDate) 
	{
		this.renewDate = renewDate;
	}

	public int getRenewCounter() 
	{
		return renewCounter;
	}


	public void setRenewCounter(int renewCounter)
	{
		this.renewCounter = renewCounter;
	}
	public LocalDate getLastRenewDate() 
	{
		return lastRenewDate;
	}

	public void setLastRenewDate(LocalDate lastRenewDate)
	{
		this.lastRenewDate = lastRenewDate;
	}
	public int getMonthlyPlan()
	{
		return monthlyPlan;
	}

	public void setMonthlyPlan(int monthlyPlan) 
	{
		this.monthlyPlan = monthlyPlan;
	}
	private void decreaseAccountCounter(String previousAccount) //When a user change the account model the number of previous account counter
	{															//must be decreased
		if(previousAccount.equals("Basic"))
		{
			basicAccountCounter--;
		}
		else if(previousAccount.equals("Standard"))
		{
			standardAccountCounter--;
		}
		else if(previousAccount.equals("Special"))
		{
			specialAccountCounter--;
		}
		else
		{
			freeAccountCounter--;
		}
	}

}
