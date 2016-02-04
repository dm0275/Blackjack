/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dmancilla
 */
public class Functions 
{
    public Object getRandomCard(Hashtable h)
    {
        Object[] keys = h.keySet().toArray();
        Object key = keys[new Random().nextInt(keys.length)];
        return key;
    }
    public Hashtable createDeck()
    {
        String[] cardNumbers = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] symbols = {"♥","♦","♣","♠"};
        Hashtable deck = new Hashtable();
        
        for (int i = 0; i < symbols.length; i++) 
        { 
            for (int j = 0; j < cardNumbers.length; j++) 
            {
                try
                {
                    String temp = cardNumbers[j] + symbols[i];
                    int value = Integer.parseInt(cardNumbers[j]);
                    deck.put(temp,value);
                }
                catch(NumberFormatException e)
                {
                    String temp = cardNumbers[j] + symbols[i];
                    int value = 10;
                    deck.put(temp,value);
                }
            }
        }
        return deck;
    }
    public void cardsOnHand()
    {
        List<Object> card = new ArrayList<Object>(); 
        //card.add(drawCard());
    }
    public int getHandValue(ArrayList <Integer> playersHandValue, int total)
    {
        for (int i=0; i<playersHandValue.size(); i++)
        {
            total += playersHandValue.get(i);
        }
        return total;
    }
}
