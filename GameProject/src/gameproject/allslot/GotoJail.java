/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;
import gameproject.Board;
import gameproject.CanArrest;
import gameproject.Player;
/**
 *
 * @author ThuyTrang
 */
public class GotoJail implements Slot,CanArrest{
    private Player h;
    @Override
    public void toDOSomething(Player player) {
        h = player;
        for(int i= 0; i < Board.getSlots().length;i++){
            if(Board.getSlots()[i] instanceof Jail){
                Jail r = (Jail) Board.getSlots()[i];
                player.move(Board.getSlots()[i]);
                r.receivePrisoner(this);
            }
        }        
    }

    @Override
    public String getName() {
        return "Go to Jail slot";
    }

    @Override
    public Player getPrisoner() {
        return h;
    }
}