/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Board;
import gameproject.Player;

/**
 *
 * @author ThuyTrang
 */
public class Tax implements Slot{
    private final int tax; 
    public Tax(int tax) {
        this.tax = tax;
    }

    @Override
    public void toDOSomething(Player player) {
        player.getPersonAcc().changeAmount(-tax);
        System.out.println(player.getName() + " losts " + String.valueOf(tax));
    }

    @Override
    public String getName() {
       return "Tax";
    }
    
}
