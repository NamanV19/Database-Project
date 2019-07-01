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
public class Transactions implements Transaction{
    int id;
    int food_id;
    int quantity;
    
    Transactions(int id, int food_id, int quantity){
        this.id = id;
        this.food_id = food_id;
        this.quantity = quantity;
    }
    
    // Returns id.
    public int getId(){
        return id;
    }
    
    // Returns food_id.
    public int getFoodId(){
        return food_id;
    }
    
    // Returns quantity.
    public int getQuantity(){
        return quantity;
    }
}
