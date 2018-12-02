package game;

import behaviours.ISell;

import java.util.HashMap;

public class Vendor {

    private HashMap<ISell, Integer> shopStock;

    public Vendor() {
        this.shopStock = new HashMap<>();
    }

    public int getShopStock(ISell item) {
        if (this.shopStock.containsKey(item)) {
            return this.shopStock.get(item);
        } else {
            return 0;
        }
    }

    public int getNumberOfItems() {
        return this.shopStock.size();
    }

    public void changeStockLevel(ISell item, int number){
        if(this.shopStock.containsKey(item)){
            int currentStockValue = this.getShopStock(item);
            this.shopStock.replace(item, currentStockValue + number);
        } else {
            this.shopStock.put(item, number);
        }
    }

}