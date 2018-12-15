/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Board;
import gameproject.Player;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ThuyTrang
 */
public class PayEveryBody extends Card{

    @Override
    public void Instruction(Player player) {
        LinkedList<Player> a =  Board.getPlayers();
        for (Iterator<Player> iterator = a.iterator(); iterator.hasNext();) {
            Player next = iterator.next();
            next.getPersonAcc().changeAmount(50);
            player.getPersonAcc().changeAmount(-50);
        }
    }
    
}
