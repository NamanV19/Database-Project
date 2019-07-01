/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

/**
 *
 * @author Naman
 */
public class MenuInfo {
    int id;
    String food_name;
    int quantity;
    int cost;
    
    MenuInfo(int id, String food_name, int quantity, int cost){
        this.id = id;
        this.food_name = food_name;
        this.quantity = quantity;
        this.cost = cost;
    }
    
    // Returns id.
    public int getId(){
        return id;
    }
    
    // Returns food_name.
    public String getFoodName(){
        return food_name;
    }
    
    // Returns quantity.
    public int getQuantity(){
        return quantity;
    }
    
    // Returns cost.
    public int getCost(){
        return cost;
    }
}
