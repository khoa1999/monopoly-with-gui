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
public class GotoGo extends Card{

    @Override
    public void Instruction(Player player) {
        player.move(Start.getStart());
    }
    
}
