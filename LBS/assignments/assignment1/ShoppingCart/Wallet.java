                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Wallet {
   /**
    * The RandomAccessFile of the wallet file
    */  
   private RandomAccessFile file;

   /**
    * Creates a Wallet object
    *
    * A Wallet object interfaces with the wallet RandomAccessFile
    */
    public Wallet () throws Exception {
	this.file = new RandomAccessFile(new File("wallet.txt"), "rw");
    }

   /**
    * Gets the wallet balance. 
    *
    * @return                   The content of the wallet file as an integer
    */
    public int getBalance() throws IOException {
	this.file.seek(0);
	return Integer.parseInt(this.file.readLine());
    }

    public final synchronized int safeWithdraw(int valueToWithdraw) throws Exception
	{
		int walletbalance = this.getBalance();
		if(valueToWithdraw <= walletbalance)
			{
			walletbalance = walletbalance - valueToWithdraw;
			setBalance(walletbalance);
			return valueToWithdraw;
			}	
		else
			{
				int Amountwithdrawn=walletbalance;
				System.out.println("Balance Withdrawn is "+ Amountwithdrawn);
				walletbalance = 0;
				setBalance(walletbalance);	
				System.out.println("Your account balance: " + Amountwithdrawn + " is not sufficient to buy the product");				
				return Amountwithdrawn;
			 	 
			}	
			
	}
    

   public synchronized void safeDeposit(int valueToDeposit) throws Exception
	{
            int balance=valueToDeposit;
	    setBalance(balance);	
	}



   /**
    * Sets a new balance in the wallet
    *
    * @param  newBalance          new balance to write in the wallet
    */
   public void setBalance(int newBalance) throws Exception {
	this.file.setLength(0);
	String str = new Integer(newBalance).toString()+'\n'; 
	this.file.writeBytes(str); 
    }

   /**
    * Closes the RandomAccessFile in this.file
    */
    public void close() throws Exception {
	this.file.close();
    }
}
