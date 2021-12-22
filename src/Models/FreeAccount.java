package Models;
public class FreeAccount extends Account
{
	
	
	public FreeAccount(String name,String surName,String userName,String password,String eMail,boolean parentalControl,int month)
	{
		super(name,surName,userName,password,eMail,parentalControl,month);
		freeAccountCounter++;
	}
	public FreeAccount(String name,String surName,String userName,String password,String eMail,boolean parentalControl,int month,String previous,int renewCounter)
	{
		super(name,surName,userName,password,eMail,parentalControl,month,previous,renewCounter);
		freeAccountCounter++;
		
	}
}
