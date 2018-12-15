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
public class ChargeCard extends Card{
    private String name;
    private int amount;
    public ChargeCard(String name,int amount){
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void Instruction(Player player) {
        player.getPersonAcc().changeAmount(amount);
    }
}
