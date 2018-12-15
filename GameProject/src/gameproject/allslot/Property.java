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
public abstract class Property implements Slot {

    protected int purchaseCost;

    protected int tax;

    protected Player owner = null;

    protected String name;

    protected boolean isMortaged = false;

    protected Player current;
    public abstract int calculateTax();
    public abstract void setMortaged();
    protected void setMortagedd(){
        this.isMortaged = true;
        this.owner.getPersonAcc().changeAmount((int) (0.5*purchaseCost));
    }
    public abstract void sell();
    public int getCost(){
        return purchaseCost;
    }
    public abstract void buy(Player player);
    protected void buyy(Player player){
        int oldCost = this.purchaseCost;
        if(this.isMortaged){
            this.purchaseCost = (int) 1.1*this.purchaseCost;
        }
        if(owner == null && 
                player.getPersonAcc().getAmount() >= this.purchaseCost){
            this.owner = player;
            this.owner.getPersonAcc().buyOrSell(this, true);
        }
        this.isMortaged = false;
        this.purchaseCost = oldCost;
    }
    @Override
        public void toDOSomething(Player player) {
        if(this.getOwner() == null && player.buy()){
            //tạm thời thì chỉ ai vô slot mới được mua slot đó
            if(player.getPersonAcc().getAmount() >= this.purchaseCost){
                this.buy(player);
                System.out.print("Ower: ");
                System.out.print(this.owner.getName() + " ");
                System.out.println(this.getName());
            }
        }
        else if(owner.getIndex() != player.getIndex()&& !this.isMortaged){
            this.current = player;
            player.getPersonAcc().changeAmount(-this.calculateTax());
            this.owner.getPersonAcc().changeAmount(this.calculateTax());
        }
    }
    public Player getOwner() {
        return owner;
    }
    public abstract void free(); 
    protected void freee() {
        this.owner = null;
    }
    @Override
    public boolean equals(Object obj){
        return obj.hashCode() == this.hashCode();
    }
}

