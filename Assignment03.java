// Class       :   <CSE 110 Online >
// Assignment  : <assignment 3>
// Author      : MORRIS, CHRIS 1223564576		
// Description : Automatic stock trader

import java.util.Scanner;

public class Assignment03 {

    public static void main(String[] args) {

        // declare and instantiate a Scanner
    	Scanner input = new Scanner(System.in);
        
        // declare and initialize variables
    	int currentShares = 0;
    	int purchasePrice = 0;
    	int marketPrice = 0;
    	int availableFunds = 0;
    	String recommendedAction = ""; //this is the final output of the program
    	
        final int TRANSACTION_FEE = 10; //cannot buy or sell w/o paying fee. this fee can be taken from the profit of a sale
        // prompt for and collect inputs
        //collecting inputs and assigning them to initialized variables
    	System.out.println("Current shares  : ");
    	currentShares = input.nextInt();
    	System.out.println("Purchase Price  : ");
    	purchasePrice = input.nextInt();
    	System.out.println("Market Price    : ");
    	marketPrice = input.nextInt();
    	System.out.println("Available Funds : ");
    	availableFunds = input.nextInt();
        // compute required values
    	
    	if (availableFunds > TRANSACTION_FEE && purchasePrice > marketPrice) 
    	{
    		int numSharesBuy = numSharesBuyCalc(availableFunds , marketPrice , TRANSACTION_FEE);
    		int totalBuyCost = totalBuyCalc(TRANSACTION_FEE , marketPrice , numSharesBuy);
    		int perShareBuyValue = perShareBuyCalc(purchasePrice , marketPrice);
    		int totalBuyValue = totalShareBuyCalc(perShareBuyValue , numSharesBuy);
    		if (numSharesBuy > 0 && totalBuyValue > TRANSACTION_FEE)
	    	{
	    		recommendedAction = String.format("Buy %d shares" , numSharesBuy); 
	    	 	
	    	}
    		else 
    		{
    			recommendedAction = "Hold shares";
    		}
    	}
    	else if (purchasePrice < marketPrice) 
    	{
    		int perShareSellValue = perShareSellCalc(marketPrice , purchasePrice);
    		int totalSellValue = totalShareSellCalc(perShareSellValue , currentShares);
    		if (totalSellValue > TRANSACTION_FEE) 
    		{
    			recommendedAction = String.format("Sell %d shares" , currentShares);
    		}
    		else 
    		{
    			recommendedAction = "Hold Shares";
    		}
    	}
    	else {
    		recommendedAction = "Hold Shares";
    	}
    	System.out.println(recommendedAction);
        // display required outputs

    }
    /**
	    calculates value per share buy value
	    @param purchasePrice purchase price of share at time of purchase
	    @param int marketPrice current market price of share
	    @return perShareBuyValue money gained or lost from buying each share
    */
    private static int perShareBuyCalc(int purchasePrice , int marketPrice) {
    	
    	int perShareBuyValue = purchasePrice - marketPrice;
    	
    	return perShareBuyValue;
    }
    /**
    	calculates total value of purchase
	    @param perShareBuyValue money gained from buying each share
	    @param numSharesPurchased number of shares purchased
	    @return totalBuyValue total money gained or lost from buying shares
     */
    private static int totalShareBuyCalc(int perShareBuyValue , int numSharesPurchased) {
    	
    	int totalBuyValue = perShareBuyValue * numSharesPurchased;
    	
    	return totalBuyValue;
    }
    /** 
      	calculates value per share sale value
	    @param marketPrice current market price of share
	    @param purchasePrice purchase price of share at time of purchase
	    @return perShareSellValue money gained or lost from selling each share
    */
    private static int perShareSellCalc(int marketPrice , int purchasePrice) {
    	
    	int perShareSellValue = marketPrice - purchasePrice;
    	
    	return perShareSellValue;
    }
    /** 
	    calculates total value of sale
	    @param perShareSellValue money gained from selling each share
	    @param currentShares number of shares currently held
	    @return totalSellValue total money gained from selling shares
    */
    private static int totalShareSellCalc(int perShareSellValue , int currentShares) {
    	
    	int totalSellValue = perShareSellValue * currentShares;
    	
    	return totalSellValue; 	
    }
    /**
     * calculates the amount of shares to buy
     * @param availableFunds funds available to purchase shares
     * @param marketPrice current price of a given share
     * @param transFee this will be the transaction fee for a transaction
     * @return numSharesBuy the number of shares to purchase
     */
    private static int numSharesBuyCalc(int availableFunds , int marketPrice, int transFee) {
    	
    	int numSharesBuy = ((availableFunds - transFee) / marketPrice);
    	
    	return numSharesBuy;
    }
    /**
     * calculates the total cost of purchased shares
     * @param transFee the transaction fee
     * @param marketPrice current price of a given share
     * @param numSharesBuy number of shares purchased, based on numSharesBuyCalc(); output
     * @return totalBuyCost total cost of purchased shares
     */
    private static int totalBuyCalc(int transFee , int marketPrice , int numSharesBuy) {
    	
    	int totalBuyCost = (numSharesBuy * marketPrice) + transFee;
    	
    	return totalBuyCost;
    }
}










































