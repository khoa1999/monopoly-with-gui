/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Player;
import java.util.Iterator;

/**
 *
 * @author ThuyTrang
 */
public class StreetRepair extends Card{

    @Override
    public void Instruction(Player player) {
        int sum = 0,a = 0;
        for(Iterator<Property> it = player.getPersonAcc().getProperties().iterator();
                it.hasNext();){
            Property i = it.next();
            if(i instanceof Land){
                a = ((Land) i).getHouses();
            }
            if(a < 5){
                sum += a*40;
            }
            else{
                sum += 115;
            }
        }
        player.getPersonAcc().changeAmount(-sum);
    }
}
