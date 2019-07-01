/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Naman
 */
public class MenuandRoom extends javax.swing.JFrame {

    /**
     * Creates new form MenuandRoom
     */
    public static int no_of_rooms;
    
    Main_Window main_window;
    public MenuandRoom() {
        // Used to lay out components and set their default values.
        initComponents();
        // Sets the background colour of JFrame to cyan.
        getContentPane().setBackground(Color.cyan);
    }
    
    public Connection getConnection(){
        Connection con;
        
        try{
            // The DriverManager class has a function called the getConnection(String url) which establishes connection 
            // or connects Java to the database by using the given database URL.
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotel management system?allowMultipleQueries=true", "root", "password108");
            // JOptionPane.showMessageDialog(null, "Connected");
            // Returns the connection to the URL.
            return con;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean inputCheck(){
        // Checks if the fields menu_id (refers to menu id), menu_foodname (refers to food name), menu_cost (refers to cost), menu_quantity (menu_quantity)
        if(menu_id.getText() == null || menu_foodname.getText() == null || menu_cost.getText() == null || menu_quantity.getText() == null){
            // If one of the field is empty, return false.
            return false;
        }
        
        else{
            try{
                // Else return true.
                return true;
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        }
    }
    
    // Similar to the function getCheckInDetails(), except this function deals with RoomInfo object.
    public ArrayList<RoomInfo> getRoomDetails()
    {
        ArrayList<RoomInfo> room_details_list = new ArrayList<RoomInfo>();
        Connection con = getConnection();
        String query = "SELECT * FROM room";
        
        Statement st;
        ResultSet rs;

        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            RoomInfo room_details;
            
            while(rs.next()){
                room_details = new RoomInfo(rs.getInt("room_no"), rs.getString("room_type"), rs.getInt("cost"), rs.getString("availability"));
                room_details_list.add(room_details);
            }
        } catch(SQLException ex){
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return room_details_list;
    }
    
    // Populate the JTable (In this case rInfos).
    public void ShowRoomDetailsInTable(){
        ArrayList<RoomInfo> list = getRoomDetails();
        DefaultTableModel model = (DefaultTableModel)rInfos.getModel();
        
        Object[] row = new Object[4];
        for(int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getRoomNo();
            row[1] = list.get(i).roomType();
            row[2] = list.get(i).getCost();
            row[3] = list.get(i).getAvailability();
 
            model.addRow(row);
        }
    }
     
    // Similar to the function getCheckInDetails(), except this function deals with MenuInfo object.
    public ArrayList<MenuInfo> getMenuDetails()
    {
        ArrayList<MenuInfo> menu_details_list = new ArrayList<MenuInfo>();
        Connection con = getConnection();
        String query = "SELECT * FROM menu";
        
        Statement st;
        ResultSet rs;

        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            MenuInfo menu_details;
            
            while(rs.next()){
                menu_details = new MenuInfo(rs.getInt("id"), rs.getString("food_name"), rs.getInt("quantity"), rs.getInt("cost"));
                menu_details_list.add(menu_details);
            }
        } catch(SQLException ex){
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return menu_details_list;
    }
    
    // Populate the JTable (In this case menus).
     public void ShowMenuDetailsInTable(){
        ArrayList<MenuInfo> list = getMenuDetails();
        DefaultTableModel model = (DefaultTableModel)menus.getModel();
        
        Object[] row = new Object[4];
        for(int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFoodName();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getCost();
 
            model.addRow(row);
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        room_editcost = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        room_type = new javax.swing.JComboBox<>();
        room_no = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        room_availability = new javax.swing.JTextField();
        room_cost = new javax.swing.JTextField();
        room_insert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rInfos = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        menu_id = new javax.swing.JTextField();
        menu_foodname = new javax.swing.JTextField();
        menu_cost = new javax.swing.JTextField();
        menu_quantity = new javax.swing.JTextField();
        purchase = new javax.swing.JButton();
        menu_insert = new javax.swing.JButton();
        menu_delete = new javax.swing.JButton();
        menu_editCost = new javax.swing.JButton();
        menu_editQuantity = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        checkIn_id = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        menus = new javax.swing.JTable();
        refresh2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        main_page = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        room_editcost.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        room_editcost.setForeground(new java.awt.Color(255, 153, 51));
        room_editcost.setText("Edit Cost");
        room_editcost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_editcostActionPerformed(evt);
            }
        });
        jPanel1.add(room_editcost);
        room_editcost.setBounds(20, 250, 110, 29);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Room No: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 40, 90, 21);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(68, 182, 0, 0);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Room Type:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 80, 110, 21);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(68, 188, 0, 0);

        room_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "King", "Queen" }));
        room_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_typeActionPerformed(evt);
            }
        });
        jPanel1.add(room_type);
        room_type.setBounds(160, 80, 95, 32);
        jPanel1.add(room_no);
        room_no.setBounds(160, 30, 95, 32);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Availability:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(60, 180, 100, 21);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText(" Cost:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(110, 130, 60, 21);
        jPanel1.add(room_availability);
        room_availability.setBounds(160, 180, 95, 32);
        jPanel1.add(room_cost);
        room_cost.setBounds(160, 130, 95, 32);

        room_insert.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        room_insert.setForeground(new java.awt.Color(255, 153, 51));
        room_insert.setText("Insert");
        room_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_insertActionPerformed(evt);
            }
        });
        jPanel1.add(room_insert);
        room_insert.setBounds(150, 250, 110, 29);

        rInfos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Room Type", "Cost", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rInfos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(310, 20, 480, 260);

        refresh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 153, 51));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh);
        refresh.setBounds(310, 300, 100, 29);

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\Java Wallpaper\\blue.jpg")); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 850, 410);

        jTabbedPane1.addTab("Room", jPanel1);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Check In ID:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(34, 40, 103, 21);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Food Name:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(41, 121, 96, 21);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Quantity:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(61, 207, 76, 21);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Cost:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(95, 164, 42, 21);
        jPanel2.add(menu_id);
        menu_id.setBounds(143, 74, 97, 32);
        jPanel2.add(menu_foodname);
        menu_foodname.setBounds(143, 117, 97, 32);
        jPanel2.add(menu_cost);
        menu_cost.setBounds(143, 160, 97, 32);
        jPanel2.add(menu_quantity);
        menu_quantity.setBounds(143, 203, 97, 32);

        purchase.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        purchase.setForeground(new java.awt.Color(0, 0, 204));
        purchase.setText("Purchase");
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });
        jPanel2.add(purchase);
        purchase.setBounds(32, 301, 110, 32);

        menu_insert.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu_insert.setForeground(new java.awt.Color(0, 0, 204));
        menu_insert.setText("Insert");
        menu_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_insertActionPerformed(evt);
            }
        });
        jPanel2.add(menu_insert);
        menu_insert.setBounds(260, 300, 90, 32);

        menu_delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu_delete.setForeground(new java.awt.Color(0, 0, 204));
        menu_delete.setText("Delete");
        menu_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(menu_delete);
        menu_delete.setBounds(350, 300, 87, 32);

        menu_editCost.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu_editCost.setForeground(new java.awt.Color(0, 0, 204));
        menu_editCost.setText("Edit Cost");
        menu_editCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editCostActionPerformed(evt);
            }
        });
        jPanel2.add(menu_editCost);
        menu_editCost.setBounds(440, 300, 118, 32);

        menu_editQuantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu_editQuantity.setForeground(new java.awt.Color(0, 0, 204));
        menu_editQuantity.setText("Edit Quantity");
        menu_editQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(menu_editQuantity);
        menu_editQuantity.setBounds(560, 300, 150, 32);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Menu ID:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(61, 78, 76, 21);

        checkIn_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIn_idActionPerformed(evt);
            }
        });
        jPanel2.add(checkIn_id);
        checkIn_id.setBounds(143, 36, 97, 32);

        menus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food Name", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(menus);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(260, 20, 450, 260);

        refresh2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        refresh2.setForeground(new java.awt.Color(0, 0, 204));
        refresh2.setText("Refresh");
        refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh2ActionPerformed(evt);
            }
        });
        jPanel2.add(refresh2);
        refresh2.setBounds(150, 303, 93, 30);

        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\Java Wallpaper\\SimpleWallpaper2.jpg")); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(0, 0, 840, 410);

        jTabbedPane1.addTab("Menu", jPanel2);

        main_page.setText("Main Page");
        main_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_pageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_page)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_page)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void main_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_pageActionPerformed
        // TODO add your handling code here:
        
        // This JFrame will not be visible.
        this.setVisible(false);
    
        
        
    }//GEN-LAST:event_main_pageActionPerformed

    private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
        // TODO add your handling code here:
        if(checkIn_id.getText() != null && menu_id.getText() != null && menu_quantity.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // PreparedStatement object ps is needed to store the precompiled SQL statement.
                // The SQL statement is:
                // "UPDATE menu SET menu.quantity = ? WHERE menu.id = ?". If executed, it sets the quantity field of a record (where 
                // the id is specified by the user) in table menu to a quantity set by the owner/staff. In this case, it will be equal
                // to the value of the dishes available.
                PreparedStatement ps = con.prepareStatement("UPDATE menu SET quantity = ? WHERE id = ?");
                // The below sql statement will select the quantity of a particular dish (decided by the customer).
                PreparedStatement ps2 = con.prepareStatement("SELECT quantity FROM menu WHERE id = ?");
                // Inputs the food_id (dish ordered by the customer), quantity (its quantity), 
                // into the existing id (this id represents the particular customer) in the transactions table.  
                PreparedStatement ps3 = con.prepareStatement("UPDATE transactions SET food_id = ?, quantity = ? WHERE id = ?");
                // PreparedStatement ps3 = con.prepareStatement("INSERT INTO transactions (id, food_id, quantity) VALUES (?, ?, ?)");
                
                // Converts the text in menu_id JTextfield to Integer. This needs to be done in order
                // for the SQL statement to be executed, as the id in table quantity is of type int.
                int menuId = Integer.parseInt(menu_id.getText());
                ps2.setInt(1, menuId);
                ResultSet rs = ps2.executeQuery();
                // Moving the pointer forward so that it points to the data (according to SQL query).
                rs.next();
                // Retrieves the quantity of a particular dish.
                int get_quantity = rs.getInt("quantity");
                // Takes the input of the customer (the quantity of a dish ordered) and convert it into int.
                int quantity_ordered = Integer.parseInt(menu_quantity.getText());
                
                // If the stock of the dish is 0, it means that the dish is out of stock.
                if(get_quantity == 0){
                    JOptionPane.showMessageDialog(null, "Food is finished");
                }
                
                // Else if the customer tries to order more than what is available, the below message will pop up on screen.
                else if(get_quantity-quantity_ordered < 0){
                    JOptionPane.showMessageDialog(null, "Ordered quantity is greater than quantity available");
                }
                
                // If the quantity ordered is lesser than the stock, the purchase will be successful. 
                else{
                    // Set the quantity of the dish to the quantity available - the quantity of the dish ordered.
                    ps.setInt(1, get_quantity-quantity_ordered);
                    // Inputs the id of the dish.
                    ps.setInt(2, menuId);
                    
                   // This one fills the first parameter (food_id) in the SQL statement.
                   ps3.setInt(1, menuId);
                    
                   // This one fills the second parameter (quantity).
                   ps3.setInt(2, quantity_ordered);
                    
                    // Converts the text in checkIn_id JTextfield to Integer.
                    int checkin_id = Integer.parseInt(checkIn_id.getText());
                    
                    // This one fills the third parameter (id).
                    ps3.setInt(3, checkin_id);
                    
                   // ps3.setInt(1, checkin_id);
                   // ps3.setInt(2, menuId);
                   // ps3.setInt(3, quantity_ordered);
                            
                    // SQL statement ("UPDATE menu SET quantity = ? WHERE id = ?") executed.
                    ps.executeUpdate();
                    // SQL statement ("UPDATE transactions SET food_id = ?, quantity = ? WHERE id = ?") executed.
                    ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Food purchased successfully");
                    DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
                    
                    // Clears the content of menuInfosList (which refers to JTable menus).
                    menuInfosList.setRowCount(0);
                    
                    // Calls the function ShowMenuDetailsInTable().
                    ShowMenuDetailsInTable();
                }
            }
            
            catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unsuccessful food purchase");
            }
        }

        else{
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    
    }//GEN-LAST:event_purchaseActionPerformed

    private void menu_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_insertActionPerformed
        // TODO add your handling code here:
        if(inputCheck() != false){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // The SQL statement is: 
                // "INSERT INTO menu(food_name, quantity, cost) VALUES (?, ?, ?)". If executed, it inserts values set by the staff into
                // the fields food_name, quantity, and cost in table menu.
                PreparedStatement ps = con.prepareStatement("INSERT INTO menu(food_name, quantity, cost) VALUES(?, ?, ?)");
                
                // Converts object of type String (menu_cost.getText()) to Integer type. This process needs to be carried out as the 
                // cost field in the table menu is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer.
                int menuCost = Integer.parseInt(menu_cost.getText());
                
                // Similar to the case above, except that it converts the text (String) in JTextfield menu_quantity to Integer. 
                int menuQuantity = Integer.parseInt(menu_quantity.getText());
                
                ps.setString(1, menu_foodname.getText());
                ps.setInt(2, menuQuantity);
                ps.setInt(3, menuCost);
                
                // Executes the SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Food inserted successfully");
                
                DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
                // Clears the content of menuInfosList (which refers to JTable menus).
                menuInfosList.setRowCount(0);
                
                // Calls the function ShowMenuDetailsInTable().
                ShowMenuDetailsInTable();
            }
            catch(SQLException ex){
               // ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Insert food failed");
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_menu_insertActionPerformed

    private void menu_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_deleteActionPerformed
        // TODO add your handling code here:
        if(menu_id.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // Deletes a record (dish details) where the id is specified by the user.
                PreparedStatement ps = con.prepareStatement("DELETE FROM menu where id = ?");
                
                // Converts object of type String (menu_id.getText()) to Integer type. This process needs to be carried out as the 
                // id field in the table menu is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer.
                int menuId = Integer.parseInt(menu_id.getText());
                ps.setInt(1, menuId);
                
                // Executes the SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Food menu deleted successfuly");
                
                DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
                // Clears the content of menuInfosList (which refers to JTable menus).
                menuInfosList.setRowCount(0);
                
                // Calls the function ShowMenuDetailsInTable().
                ShowMenuDetailsInTable();
            }
            catch(SQLException ex){
                // ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Delete menu failed");
            }
        }
        else{
              JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_menu_deleteActionPerformed

    private void room_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_insertActionPerformed
        // TODO add your handling code here:
        if(room_type.getSelectedItem().toString() != null && room_cost.getText() != null && room_availability.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // The SQL statement is: 
                // "INSERT INTO room(room_type, cost, availability) VALUES (?, ?, ?)". If executed, it inserts values set by the staff into
                // the fields room_type, cost, and availability in table room.
                PreparedStatement ps = con.prepareStatement("INSERT INTO room(room_type, cost, availability) VALUES (?, ?, ?)");
                
                // Converts object of type String (room_cost.getText()) to Integer type. This process needs to be carried out as the 
                // cost field in the table room is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer.
                int roomCost = Integer.parseInt(room_cost.getText());
                
                // The parameters in the SQL statement (which is "?") must be filled before the SQL statement can be executed.
                // This one fills the first parameter (room_type). Note that the room_type.getSelectedItem() refers to the option chosen
                // by the staff from the list of options in the combobox. toString() method simply converts it to String data type.
                ps.setString(1, room_type.getSelectedItem().toString());
                // This one fills the second parameter (roomCost).
                ps.setInt(2, roomCost);
                // While this one fills the third parameter (room_availability).
                ps.setString(3, room_availability.getText());
                
                // Executes the above SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "New room added");
                
                DefaultTableModel rInfosList= (DefaultTableModel)rInfos.getModel();
                // Clears the content of rInfosList (which refers to JTable rInfos).
                rInfosList.setRowCount(0);
                
                // Calls the function ShowRoomDetailsInTable().
                ShowRoomDetailsInTable();
                
            }catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Addition of new room failed");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_room_insertActionPerformed

    private void room_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_typeActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_room_typeActionPerformed
    
    // Edits the cost of a dish selected by the staff/owner.
    private void menu_editCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editCostActionPerformed
        // TODO add your handling code here:
        if(menu_cost.getText() != null && menu_id.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // The SQL statement is:
                // "UPDATE menu SET menu.cost = ? WHERE menu.id = ?". If executed, it sets the cost field of a record (where 
                // the id is specified by the user) in the table menu to the price that the owner wishes to set.
                PreparedStatement ps = con.prepareStatement("UPDATE menu SET menu.cost = ? WHERE menu.id = ?");
                
                // converts object of type String (menu_cost.getText()) to Integer type. This process needs to be carried out as the 
                // cost field in the table menu is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer. Integer can be converted to int as shown in the line below:
                int menuCost = Integer.parseInt(menu_cost.getText());
                // Similar to the case above, except that it converts the text (String) in JTextfield menu_id to Integer. 
                int menuId = Integer.parseInt(menu_id.getText());
                
                  
                // The parameters in the SQL statement (which is "?") must be filled before the SQL statement can be executed.
                // This one fills the first parameter (cost).
                ps.setInt(1, menuCost);
                // While this one fills the second parameter (menuId).
                ps.setInt(2, menuId);
                
                // Executes the SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cost edited successfully");
                
                DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
                // Clears the content of menuInfosList (which refers to JTable menus).
                menuInfosList.setRowCount(0);
                
                // Calls the function ShowMenuDetailsInTable().
                ShowMenuDetailsInTable();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_menu_editCostActionPerformed

    private void room_editcostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_editcostActionPerformed
        // TODO add your handling code here:
          if(room_cost.getText() != null && room_no.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // The SQL statement is: 
                // "UPDATE room SET room.cost = ? WHERE room.room_no = ?". If executed, it sets the cost field of a record (where 
                // the id (room_no) is specified by the user) in the table room to the price that the owner wishes to set.
                PreparedStatement ps = con.prepareStatement("UPDATE room SET room.cost = ? WHERE room.room_no = ?");
                
                // Basically converts object of type String (room_cost.getText()) to Integer type. This process needs to be carried out as the 
                // cost field in the table room is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer. Integer can be converted to int as shown in the line below:
                int roomCost = Integer.parseInt(room_cost.getText());
                // Similar to the case above, except that it converts the text (String) in JTextfield room_no to Integer. 
                int roomNo = Integer.parseInt(room_no.getText());
                
                // The parameters in the SQL statement (which is "?") must be filled before the SQL statement can be executed.
                // This one fills the first parameter (cost).
                ps.setInt(1, roomCost);
                // While this one fills the second parameter (room_no).
                ps.setInt(2, roomNo);
                
                // Executes the SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Room cost edited successfully");
                
                DefaultTableModel rInfosList= (DefaultTableModel)rInfos.getModel();
                // Clears the content of rInfosList (which refers to JTable rInfos).
                rInfosList.setRowCount(0);
                
                // Calls the function ShowRoomDetailsInTable().
                ShowRoomDetailsInTable();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_room_editcostActionPerformed
    
    // Simply edits the quantity of a dish selected by the staff/owner.
    private void menu_editQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editQuantityActionPerformed
        // TODO add your handling code here:
        if(menu_quantity.getText() != null && menu_id.getText() != null){
            try{
                // con which is an object of type Connection is created to receive connection to the URL.
                Connection con = getConnection();
                // The SQL statement is:
                // "UPDATE menu SET menu.quantity = ? WHERE menu.id = ?". If executed, it sets the quantity field of a record (where 
                // the id is specified by the user) in table menu to a quantity set by the owner/staff.
                PreparedStatement ps = con.prepareStatement("UPDATE menu SET menu.quantity = ? WHERE menu.id = ?");
                
                // Basically converts object of type String (menu_quantity.getText()) to Integer type. This process needs to be carried out as the 
                // quantity field in the table menu is of type int and hence, for the above SQL statement to be executed, we need
                // to convert the String to Integer. Integer can be converted to int as in the line below:
                int menuQuantity = Integer.parseInt(menu_quantity.getText());
                // Similar to the case above, except that it converts the text (String) in JTextfield menu_id to Integer. 
                int menuId = Integer.parseInt(menu_id.getText());
                
                // The parameters in the SQL statement (which is "?") must be filled before the SQL statement can be executed.
                // This one fills the first parameter (quantity).
                ps.setInt(1, menuQuantity);
                // While this one fills the second parameter (id).
                ps.setInt(2, menuId);
                
                // Executes the SQL statement.
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Quantity edited successfully");
                
                DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
                // Clears the content of menuInfosList (which refers to JTable menus).
                menuInfosList.setRowCount(0);
                
                // Calls the function ShowMenuDetailsInTable().
                ShowMenuDetailsInTable();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_menu_editQuantityActionPerformed

    private void checkIn_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIn_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkIn_idActionPerformed

    private void refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel menuInfosList= (DefaultTableModel)menus.getModel();
        menuInfosList.setRowCount(0);
                
        ShowMenuDetailsInTable();
    }//GEN-LAST:event_refresh2ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel rInfosList= (DefaultTableModel)rInfos.getModel();
        rInfosList.setRowCount(0);
                
        ShowRoomDetailsInTable();
    }//GEN-LAST:event_refreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuandRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuandRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkIn_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton main_page;
    private javax.swing.JTextField menu_cost;
    private javax.swing.JButton menu_delete;
    private javax.swing.JButton menu_editCost;
    private javax.swing.JButton menu_editQuantity;
    private javax.swing.JTextField menu_foodname;
    private javax.swing.JTextField menu_id;
    private javax.swing.JButton menu_insert;
    private javax.swing.JTextField menu_quantity;
    private javax.swing.JTable menus;
    private javax.swing.JButton purchase;
    private javax.swing.JTable rInfos;
    private javax.swing.JButton refresh;
    private javax.swing.JButton refresh2;
    private javax.swing.JTextField room_availability;
    private javax.swing.JTextField room_cost;
    private javax.swing.JButton room_editcost;
    private javax.swing.JButton room_insert;
    private javax.swing.JTextField room_no;
    private javax.swing.JComboBox<String> room_type;
    // End of variables declaration//GEN-END:variables
}
