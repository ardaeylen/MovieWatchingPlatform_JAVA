package Controllers;
import java.util.LinkedList;

import Models.*;
public class Database 
{
	private static LinkedList<Account> accounts;
	
	
	static {
		accounts = new LinkedList<Account>();
		accounts.add(new SubscriptionAccount("Mehmet Arda","Eylen","Admin","12345","ardaeylen@gmail.com","Special",false,Integer.MAX_VALUE));
		accounts.add(new SubscriptionAccount("Berk","Saðlýcak","cbr","123","saglicakberk@gmail.com","Standard",false,10));
		accounts.add(new SubscriptionAccount("Ege","Þahin","sahinege","1234","sahin.ege@gmail.com","Basic",true,5));
		accounts.add(new FreeAccount("Emin","Helvacý","makine","123","makine@gmail.com",true,1));
		accounts.add(new SubscriptionAccount("Bilge","Özmen","bilge","42","ozmenbilge@gmail.com","Special",false,12));
	}
	public static boolean query(Account account)
	{//Check if there is at least one account that has the same username
		for(Account tempAccount : accounts)
		{
			if(tempAccount.getUserName().equals(account.getUserName()))
			{
				return true;
			}
		}
		return false;
	}
	public static boolean add(Account account)
	{//Add account to the database list
		if(!query(account))
		{
			accounts.add(account);
			return true;
		}
		
		return false;
	}
	public static Account login(String userName,String password)
	{//Check if there is an account that has the same username and password that are input,if there is , return it 
		for(Account account : accounts)
		{
			if(account.getUserName().equals(userName) && account.getPassword().equals(password))
			{
				return account;
			}
		}
		return null;
	}
	public static boolean deleteAccount(Account account)//Delete process for the acount model changing (previous account is deleted from list)
	{
		
		return accounts.remove(account);
	}
}
