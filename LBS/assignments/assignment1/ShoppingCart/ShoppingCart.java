import java.util.Scanner;
import java.util.Date;

public class ShoppingCart {
  public static void main(String[] args) throws Exception{
	Wallet wallet = new Wallet();
	int balance = wallet.getBalance();
	//Replace <YOUR NAME> below with your name!!! 
	System.out.println("Welcome to Murali's ShoppingCart. The time now is " + (new Date()).toString());
	System.out.println("Your balance: " + balance+ " credits\n");
	System.out.println("Please select your product: \n" + Store.asString());
	Scanner input = new Scanner(System.in);
	System.out.println("What do you want to buy, type e.g., pen ");
	String product = input.next();
	//int price = Store.getPrice(product);
	if((product.matches("car")) || (product.matches("candies")) || (product.matches("book")) || (product.matches("pen")))
	{
	int price = Store.getPrice(product);
	int amount = wallet.safeWithdraw(price);
	
   if(amount >= price){
		//wallet.setBalance(balance-price);
		Pocket pocket = new Pocket();
		pocket.addProduct(product);
		System.out.println("Your new balance: " + wallet.getBalance()+ " credits");
	        }else{
		System.out.println("Insufficient funds to buy the product");
		System.out.println("Your current balance is "+ wallet.getBalance());
	        }
	}
	else{
		System.out.println("Invalid product requested");
	}
		
		
  }
}
        
	/*if((product.equals("candies"))​ ​||​ ​(product.equals("car"))​ ​||​ ​(product.equals("pen"))||
(product.equals("book")))
​ ​ ​ ​ ​{
​ ​ ​ ​ ​int​ ​cost​ ​=​ ​Store.getPrice(product);
    int amount = wallet.safeWithdraw(cost);
​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​if(amount >=cost){
		Pocket pocket = new Pocket();
		pocket.addProduct(product);
		System.out.println("Your new balance: " + wallet.getBalance() + " credits");
  }
}
	else {
		
		System.out.println("Your current balance is "+ wallet.getBalance());
}
​ ​ ​ ​ ​else​ ​{
​ ​ ​ ​ ​System.out.println("product​ ​not​ ​found");
​ ​ ​ ​ ​}
}
}*/
