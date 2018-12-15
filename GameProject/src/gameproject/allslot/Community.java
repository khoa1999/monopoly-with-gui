/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Player;

/**
 *
 * @author ThuyTrang
 */
public class Community extends CC {
    
    public Community(){
        this.cards = new Card[]{new ChargeCard("Bank Error",200),
            new ChargeCard("X-mas Fund",1000),new StreetRepair()};
    }
    @Override
    public String toString(){
        return "Community chess";
    }
    @Override 
    public String getName(){
        return toString();
    }
}

