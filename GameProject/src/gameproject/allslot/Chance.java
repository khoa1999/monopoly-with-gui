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
public class Chance extends CC {

    public Chance() {
        this.cards = new Card[]{new Back3step(),new getOutOfJail(),
            new PayEveryBody(),new ChargeCard("Bank Error",200), 
            new ChargeCard("Poor Tax",-15), new ChargeCard("Loan Mature",150)};
    }
    @Override
    public String toString(){
        return "Chance slot";
    }
    @Override
    public String getName(){
        return toString();
    }
}

