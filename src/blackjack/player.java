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
public class player 
{
    Functions function = new Functions();
    public void player(String n)
    {
        String name = n;
    }
     public void drawCard(Hashtable h, ArrayList <Object> o, ArrayList <Integer> i)
    {
        Object card = function.getRandomCard(h);
        o.add(card);
        i.add((int) h.get(card));
    }
    
}
