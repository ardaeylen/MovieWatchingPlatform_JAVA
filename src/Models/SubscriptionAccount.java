package Models;
import java.time.LocalDate;

import Constants.Payments;

public class SubscriptionAccount extends Account 
{

	private String subscriptionModel;//Subscription model of the member (Basic,Standard,Special)
	private double paymentInvoice; //Payment invoice for the subscription model

	public SubscriptionAccount(String name,String surName,String userName,String password,String eMail,String subModel,boolean parentalControl,int month)
	{
		super(name,surName,userName,password,eMail,parentalControl,month);
		
		setSubscriptionModel(subModel); //initializing sub account according to the model
		if(subModel.equals("Basic"))
		{
			setPaymentInvoice(Payments.BASICSUBSCRIPTION*month);
			basicAccountCounter++;
		}
		 if(subModel.equals("Standard"))
		{
			setPaymentInvoice(Payments.STANDARDSUBSCRIPTION*month);
			standardAccountCounter++;
		}
		if(subModel.equals("Special"))
		{
			setPaymentInvoice(Payments.SPECIALSUBSCRIPTION*month);
			specialAccountCounter++;
		}
		
	}
	
	public SubscriptionAccount(String name,String surName,String userName,String password,String eMail,String subModel,boolean parentalControl,int month,String previous,int renewCounter)
	{
		super(name,surName,userName,password,eMail,parentalControl,month,previous,renewCounter);
		setSubscriptionModel(subModel);//initializing sub account for the change of the model (this constructor takes extra parameters like previous
		setRenewDate(LocalDate.now()); //account model
		setParentalControl(parentalControl);
		if(subModel.equals("Basic"))
		{
			setPaymentInvoice(Payments.BASICSUBSCRIPTION*month);
			basicAccountCounter++;
		}
		 if(subModel.equals("Standard"))
		{
			setPaymentInvoice(Payments.STANDARDSUBSCRIPTION*month);
			standardAccountCounter++;
		}
		if(subModel.equals("Special"))
		{
			setPaymentInvoice(Payments.SPECIALSUBSCRIPTION*month);
			specialAccountCounter++;
		}
		
	}
	
	public String getSubscriptionModel() 
	{
		return subscriptionModel;
	}


	public void setSubscriptionModel(String subscriptionModel) 
	{
		this.subscriptionModel = subscriptionModel;
	}


	public double getPaymentInvoice() 
	{
		return paymentInvoice;
	}


	public void setPaymentInvoice(double paymentInvoice)
	{
		this.paymentInvoice = paymentInvoice;
	}
	
}
