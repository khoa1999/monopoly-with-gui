/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author ThuyTrang
 */
import gameproject.allslot.Slot;
import java.util.LinkedList;

public class Board {

    private  static Slot[] slots;

    private static LinkedList<Player> Players;

    private static transient Board theBoard = null;

    private Board() {

    }
    public static void setPlayers(LinkedList<Player> listPlayer){
        Players = listPlayer;
    }

    public static void setSlots(Slot[] slots) {
        Board.slots = slots;
    }
    
    public static Board getBoard() {
        if(theBoard == null){
            theBoard = new Board();
        }
        return theBoard;
    }

    public static LinkedList getPlayers() {
        return Players;
    }
    public static void setPlayer(LinkedList<Player> Players){
        Board.Players = Players;
    }
    
    /*public static Player searchPlayer(int index){
        for(Player i:Players){
            if(i.getIndex() == index){
                return i;
            }
        }
        return null;
    }
    public static void setAPlayer(Player player){
        int a = Players.indexOf(searchPlayer(player.getIndex()));
        if(a != -1){
            Players.set(a, player);
        }
    }*/

    public static Slot[] getSlots() {
        return slots;
    }
}

