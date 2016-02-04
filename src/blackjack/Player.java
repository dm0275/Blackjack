/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author dmancilla
 */
public class Player 
{
    Functions function = new Functions();
    public void player(String n)
    {
        String name = n;
    }
     public void drawCard(Hashtable deck, ArrayList <Object> hand, ArrayList <Integer> handValue)
    {
        Object card = function.getRandomCard(deck);
        hand.add(card);
        handValue.add((int) deck.get(card));
    }
     public void initialDraw(Hashtable deck, ArrayList <Object> hand, ArrayList <Integer> handValue)
     {
         for(int x = 0; x <2; x++)
        {
            this.drawCard(deck, hand, handValue);
        }
     }
    
}
