import java.util.Date;
public aspect ShoppingCartAspect{
	//pointcut greeting(): call(* Hello.greeting(..));
	pointcut safeWithdraw(int price) :call(* Wallet.safeWithdraw(int)) && args(price);

        
        before(int price):safeWithdraw(price)
	{
         try{
	   Wallet balance = new Wallet();
           int credit=balance.getBalance();
	   if( price>credit)	
		{
		 System.out.println(" aspectJ..Your balance is low.");	
		}
	} catch(Exception e)
	 {
	   e.printStackTrace();	
	 }
	}	
        after(int price) returning(int withdrawnAmount) :safeWithdraw(price) {  
	try{  
	      Wallet balance = new Wallet();
              if(withdrawnAmount < price)
		{
                  balance.safeDeposit(withdrawnAmount);
                  System.out.println(" aspectJ..Amount is deposited back in to the wallet.");
		}
         } catch(Exception e)
	 {
	   e.printStackTrace();	
	 }
	}
	
}
