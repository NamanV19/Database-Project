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
public class CheckInDetails {
    int id;
    String first_name;
    String last_name;
    String address;
    int contact_no;
    int personal_id_no;
    String room_type;
    int room_no;
    String check_in_date;
    String check_out_date;
    int total_cost;
    
    CheckInDetails(int id, String first_name, String last_name, String address, int contact_no, int personal_id_no, String room_type, int room_no, String check_in_date, String check_out_date, int total_cost){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.contact_no = contact_no;
        this.personal_id_no = personal_id_no;
        this.room_type = room_type;
        this.room_no = room_no;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_cost = total_cost;
    }
    
    // Returns id.
    public int getId(){
        return id;
    }
    
    // Returns first_name.
    public String getFirstName(){
        return first_name;
    }
    
    // Returns last_name.
    public String getLastName(){
        return last_name;
    }
    
    // Returns address.
    public String getAddress(){
        return address;
    }
    
    // Returns contact_no.
    public int getContactNo(){
        return contact_no;
    }
    
    // Returns personal_id_no.
    public int getPersonalIdNo(){
        return personal_id_no;
    }
    
    // Returns room_type.
    public String getRoomType(){
        return room_type;
    }
    
    // Returns room_no.
    public int getRoomNo(){
        return room_no;
    }
    
    // Returns check_in_date.
    public String getCheckInDate(){
        return check_in_date;
    }
    
    // Returns check_out_date.
    public String getCheckOutDate(){
        return check_out_date;
    }
    
    // Returns total_cost.
    public int getTotalCost(){
        return total_cost;
    }
}
