/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dmancilla
 */
public class Game 
{
    Scanner input = new Scanner(System.in);
    Functions function = new Functions();
    ArrayList <Object> playersHand = new ArrayList();
    ArrayList <Integer> playersHandValue = new ArrayList();
    ArrayList <Object> dealersHand = new ArrayList();
    ArrayList <Integer> dealersHandValue = new ArrayList();
    int dealerTotal, playerTotal;
    Hashtable deck;
    boolean overTwentyOne;
            
    public void initializeGame()
    {
        int choice;
        boolean validChoice = false;
     
        do{
            System.out.println("*****Blackjack****");
            System.out.println("1. New Game");
            System.out.println("2. Exit");
            choice = input.nextInt();
            switch(choice)
            {
                case 1: validChoice = true; 
                    newGame();
                    break;
                case 2: validChoice = true;
                    exitGame();
                    break;
                default: System.out.println("Invalid Choice");
                    break;
            }
        }
        while(validChoice == false);
    }
    public void newGame()
    {
        double totalMoney = 100.00;
        double betAmount;
        System.out.println();
        System.out.println("Welcome to Blackjack");
        System.out.println("You have $100, how much would you like to bet?");
        betAmount = input.nextDouble();
        System.out.println();
        System.out.println("You are betting $"+ betAmount);
        System.out.println();
        startGame();            
    }
    public void clearVariables()
    {
        playersHand.clear();
        playersHandValue.clear();
        dealersHand.clear();
        dealersHandValue.clear();
    }
    public void exitGame()
    {
        System.out.println("Exiting game...");
        System.exit(0);
    }
    public void startGame()
    {   
        boolean draw;
        this.clearVariables();
        deck = function.createDeck();
        System.out.println("*****Starting Game*****");
        System.out.println("Dealer's Hand");
        for(int x = 0; x <2; x++)
        {
            this.drawCard(deck, dealersHand, dealersHandValue);
        }
        System.out.println(dealersHand.get(0)+" [hidden]");
        System.out.println();
        System.out.println("Player's Hand");
        for(int x = 0; x <2; x++)
        {
            this.drawCard(deck, playersHand, playersHandValue);
        }
        System.out.println(playersHand);
        //System.out.println(dealersHand);
        //System.out.println(playersHandValue);
        //playerTotal = this.getHandValue(playersHandValue, playerTotal);
        //dealerTotal = this.getHandValue(dealersHandValue, dealerTotal);
        //System.out.println(playerTotal);
        //System.out.println(dealerTotal);
        do
        {
            System.out.println("Draw again? Y/N");
            String userInput = input.next();
            if(userInput.toUpperCase().equals("Y"))
            {
                this.drawCard(deck, dealersHand, dealersHandValue);
                this.drawCard(deck, playersHand, playersHandValue);
                System.out.println("Dealer's Hand");
                System.out.println(dealersHand);
                System.out.println();
                System.out.println("Player's Hand");
                System.out.println(playersHand);
                playerTotal = this.getHandValue(playersHandValue, playerTotal);
                dealerTotal = this.getHandValue(dealersHandValue, dealerTotal);
                overTwentyOne = this.overTwentyOne(playerTotal, dealerTotal, playersHandValue, dealersHandValue);
            }
            else
            {
                
                overTwentyOne = true;
            }
        }
        while(overTwentyOne == false);
        System.out.println();
        playerTotal = this.getHandValue(playersHandValue, playerTotal);
        dealerTotal = this.getHandValue(dealersHandValue, dealerTotal);
        System.out.println("These are the results:");
        System.out.println("Dealer Total:" + dealerTotal);
        System.out.println("Player Total:" + playerTotal);
        
        if(overTwentyOne == true)
        {
            if(playerTotal <= 21)
            {
                System.out.println("The Player wins!!!");
            }
            else
            {
                System.out.println("The dealer won this round");
            }    
        }
        System.out.println();
        System.out.println("Do you want to play again?");
        String again = input.next();
        if(again.toUpperCase().equals("Y"))
        {
            this.startGame();
        }
        else
        {
            this.exitGame();
        }
        
    }
    public void gameCheck(int playerTotal, int dealerTotal, ArrayList <Integer> player, ArrayList <Integer> dealer )
    {
        playerTotal = this.getHandValue(player, playerTotal);
        dealerTotal = this.getHandValue(dealer, dealerTotal);
        
        //boolean draw = this.overTwentyOne(playerTotal , dealerTotal);
        //if(draw == false)
        {
            System.out.println("Draw again? Y/N");
            String userInput = input.next();
        }
        //else
        {
            System.out.println("Over 21");
        }
        
    }
    public boolean overTwentyOne(int playerTotal, int dealerTotal, ArrayList <Integer> player, ArrayList <Integer> dealer)
    {
        playerTotal = this.getHandValue(player, playerTotal);
        dealerTotal = this.getHandValue(dealer, dealerTotal);
        
        if(playerTotal > 21)
        {
            return true;
        }
        else if(dealerTotal > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void drawCard(Hashtable h, ArrayList <Object> o, ArrayList <Integer> i)
    {
        Object card = function.getRandomCard(h);
        o.add(card);
        i.add((int) h.get(card));
    }
    public int getHandValue(ArrayList <Integer> playersHandValue, int total)
    {
        total = 0;       
        for (int i=0; i<playersHandValue.size(); i++)
        {
            total += playersHandValue.get(i);
        }
        return total;
    }
}
