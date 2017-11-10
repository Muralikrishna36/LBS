import java.util.Date;
public aspect ShoppingCartAspect{
        after(int balance): call(* Wallet.setBalance(int)) && args(balance){
          System.out.print("Policy will be enforced by Murali in AspectJ. The time now is" + (new Date()).toString() );   
	  System.out.print("\n your balance is :" + balance);
	  System.out.print("\n The time is " + (new Date()).toString()); 
    	}
}
