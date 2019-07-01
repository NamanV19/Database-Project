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
public class RoomInfo {
    int room_no;
    String room_type;
    int cost;
    String availability;
    
    RoomInfo(int room_no, String room_type, int cost, String availability){
        this.room_no = room_no;
        this.room_type = room_type;
        this.cost = cost;
        this.availability = availability;
    }
    
    // Returns room_no.
    public int getRoomNo(){
        return room_no;
    }
    
    // Returns room_type.
    public String roomType(){
        return room_type;
    }
    
    // Returns cost.
    public int getCost(){
        return cost;
    }
    
    // Returns availability.
    public String getAvailability(){
        return availability;
    }
}
