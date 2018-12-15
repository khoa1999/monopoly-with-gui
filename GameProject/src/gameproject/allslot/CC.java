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
public abstract class CC implements Slot {

    protected Card[] cards;

    public Card[] getCards() {
        return cards;
    }
    public Card getCard(){
        return cards[(int) Math.random()*cards.length];
    }
    @Override
    public void toDOSomething(Player player){
        this.getCard().Instruction(player);
    }
}

