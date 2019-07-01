/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Naman
 */
public class Main_Window extends javax.swing.JFrame {

    /**
     * Creates new form Main_Window
     */
    int storer = 0;

    public Main_Window() {
        // Used to lay out components and set their default values.
        initComponents();
        // Automatically maximizes the window when we run this file.
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }
     
    public Connection getConnection() {
        Connection con;

        try {
            // The DriverManager class has a function called the getConnection(String url) which establishes connection 
            // or connects Java to the database by using the given database URL.
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotel management system?allowMultipleQueries=true", 
                    "root", "password108");
            // JOptionPane.showMessageDialog(null, "Connected");
            // Returns the connection to the URL.
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    // Checks if the necessary text fields are filled or not.
    public boolean inputCheck() {
        // Checks if the fields fname (refers to first name), lname (refers to last name), address (refers to address), cno (refers to contact number),
        // cid (refers to customer id number), rt (refers to room type), rn (refers to room number), and checkIn (refers to check in date).
        if (fname.getText() == null || lname.getText() == null || address.getText() == null || cno.getText() == null || cid.getText() == null || rt.getSelectedItem().toString() == null
                || rn.getSelectedItem().toString() == null || checkIn.getDate() == null) {
            // If one of the field is empty, return false.
            return false;
        } else {
            // Else return true.
            try {
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        }
    }
    
    // To retrieve data from table (checkindetails) in the database. This data will then be added
    // in JTable which will store the checkindetails (check the function ShowCheckInDetailsInTable() ).
    public ArrayList<CheckInDetails> getCheckInDetails() {
        // Creates CIn_details_list which is an ArrayList which stores CheckInDetails objects.
        ArrayList<CheckInDetails> cIn_details_list = new ArrayList<CheckInDetails>();
        // con which is an object of type Connection is created to receive connection to the URL.
        Connection con = getConnection();
        // Select data from all fields in table checkindetails.
        String query = "SELECT * FROM checkindetails";
        
        // Object of type Statement is declared.
        Statement st;
        // Object of type ResultSet is declared.
        ResultSet rs;

        try {
            // createStatement() method returns a Statement object which will be used to send 
            // SQL statements to the database.
            st = con.createStatement();
            // Above query is executed.
            rs = st.executeQuery(query);
            // Creates object cIn_Details which is of type CheckInDetails.
            CheckInDetails cIn_Details;
            
            // .next() to iterate through each row in the table checkindetails (the data is now stored in ResultSet object).
            while (rs.next()) {
                // Get the data from each field in a row. For example, rs.getInt("id) retrieves the
                // data from id field in table checkindetails in database, etc.
                cIn_Details = new CheckInDetails(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getInt("contact_no"), rs.getInt("personal_id_no"), rs.getString("room_type"), rs.getInt("room_no"), rs.getString("check_in_date"), rs.getString("check_out_date"), rs.getInt("total_cost"));
                // Add cIn_Details to ArrayList cIn_details_list.
                cIn_details_list.add(cIn_Details);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Returns the ArrayList cIn_details_list.
        return cIn_details_list;
    }
    
    // Populate the JTable (In this case cInDetails).
    public void ShowCheckInDetailsInTable() {
        // Creates an ArrayList list which will store the array from the getCheckInDetails() function.
        ArrayList<CheckInDetails> list = getCheckInDetails();
        DefaultTableModel model = (DefaultTableModel) cInDetails.getModel();
        
        // Creates an array row of type Object and size 11 (As there are eleven data that can be extracted from each
        // CheckInDetails object in ArrayList list).
        Object[] row = new Object[11];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFirstName();
            row[2] = list.get(i).getLastName();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getContactNo();
            row[5] = list.get(i).getPersonalIdNo();
            row[6] = list.get(i).getCheckInDate();
            row[7] = list.get(i).getCheckOutDate();
            row[8] = list.get(i).getRoomType();
            row[9] = list.get(i).getRoomNo();
            row[10] = list.get(i).getTotalCost();
            
            // Adds the data (all the details in a row) into JTable cInDetails.
            model.addRow(row);
        }
    }
    
    // Similar to the function getCheckInDetails(), except this function deals with Transactions object.
    public ArrayList<Transactions> getTransactionsDetails() {
        ArrayList<Transactions> transactions_details_list = new ArrayList<Transactions>();
        Connection con = getConnection();
        String query = "SELECT * FROM transactions";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Transactions transaction_Details;

            while (rs.next()) {
                transaction_Details = new Transactions(rs.getInt("id"), rs.getInt("food_id"), rs.getInt("quantity"));
                transactions_details_list.add(transaction_Details);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        return transactions_details_list;
    }
    
    // Populate the JTable (In this case transaction_list).
    public void ShowTransactionDetailsInTable() {
        ArrayList<Transactions> list = getTransactionsDetails();
        DefaultTableModel model = (DefaultTableModel) transaction_list.getModel();

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFoodId();
            row[2] = list.get(i).getQuantity();

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

        fname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        checkIn = new com.toedter.calendar.JDateChooser();
        checkOut = new com.toedter.calendar.JDateChooser();
        INSERT = new java.awt.Button();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaction_list = new javax.swing.JTable();
        rn = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        rt = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        totalP = new javax.swing.JTextField();
        totalCost = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        cInDetails = new javax.swing.JTable();
        menu_and_room = new javax.swing.JButton();
        refresh = new java.awt.Button();
        cOut2 = new java.awt.Button();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().setLayout(null);
        getContentPane().add(fname);
        fname.setBounds(145, 81, 109, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText(" First Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 84, 99, 21);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 51));
        jLabel2.setText("Last Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(48, 120, 91, 21);
        getContentPane().add(lname);
        lname.setBounds(145, 117, 109, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(185, 802, 0, 0);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 51));
        jLabel4.setText("Address:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(69, 156, 70, 21);
        getContentPane().add(address);
        address.setBounds(145, 153, 109, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 51));
        jLabel5.setText("Contact No:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(44, 192, 95, 21);
        getContentPane().add(cno);
        cno.setBounds(145, 189, 109, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 51));
        jLabel6.setText(" Customer ID:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(26, 225, 113, 21);
        getContentPane().add(cid);
        cid.setBounds(145, 225, 109, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 51));
        jLabel7.setText("Room No:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(58, 300, 80, 21);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setText("   Check In Date:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(39, 345, 133, 21);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 51));
        jLabel9.setText("Check Out Date:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(39, 393, 133, 21);
        getContentPane().add(checkIn);
        checkIn.setBounds(176, 345, 194, 30);
        getContentPane().add(checkOut);
        checkOut.setBounds(176, 393, 194, 30);

        INSERT.setActionCommand("INSERT");
        INSERT.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        INSERT.setForeground(new java.awt.Color(0, 153, 51));
        INSERT.setLabel("CHECK IN");
        INSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTActionPerformed(evt);
            }
        });
        getContentPane().add(INSERT);
        INSERT.setBounds(10, 551, 165, 45);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 51));
        jLabel10.setText(" ID:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(108, 48, 31, 21);
        getContentPane().add(id);
        id.setBounds(145, 45, 109, 30);

        transaction_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food ID", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transaction_list);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(380, 298, 452, 243);

        rn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        getContentPane().add(rn);
        rn.setBounds(142, 298, 133, 29);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("Room Type:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(41, 261, 97, 21);

        rt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "King", "Queen" }));
        rt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtActionPerformed(evt);
            }
        });
        getContentPane().add(rt);
        rt.setBounds(142, 261, 133, 28);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setText("Total Price (With Tax):");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 466, 185, 66);
        getContentPane().add(totalP);
        totalP.setBounds(199, 486, 171, 30);

        totalCost.setActionCommand("INSERT");
        totalCost.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalCost.setForeground(new java.awt.Color(0, 153, 51));
        totalCost.setLabel("TOTAL COST");
        totalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCostActionPerformed(evt);
            }
        });
        getContentPane().add(totalCost);
        totalCost.setBounds(185, 551, 156, 45);

        cInDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "Contact No", "Customer ID", "Check In Date", "Check Out Date", "Room Type", "Room No", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cInDetails);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(280, 40, 983, 243);

        menu_and_room.setForeground(new java.awt.Color(0, 204, 0));
        menu_and_room.setText("Menu and Room");
        menu_and_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_and_roomActionPerformed(evt);
            }
        });
        getContentPane().add(menu_and_room);
        menu_and_room.setBounds(18, 11, 121, 23);

        refresh.setLabel("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(280, 300, 90, 24);

        cOut2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cOut2.setForeground(new java.awt.Color(0, 153, 51));
        cOut2.setLabel("CHECK OUT");
        cOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cOut2ActionPerformed(evt);
            }
        });
        getContentPane().add(cOut2);
        cOut2.setBounds(380, 551, 172, 45);

        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\Java Wallpaper\\backgrounds-blank-blue-953214.jpg")); // NOI18N
        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 1340, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void totalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCostActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = getConnection();
            // Calculates the total cost (number of days stayed in hotel * price of room per night)
            PreparedStatement ps = con.prepareStatement("UPDATE checkindetails INNER JOIN room ON checkindetails.room_no = room.room_no "
                    + "SET checkindetails.total_cost = TIMESTAMPDIFF(DAY, check_in_date, check_out_date) * room.cost WHERE checkindetails.total_cost = 0");
         
            // If the customer buys food, it we be added to the value in the total cost field in table checkindetails.
            PreparedStatement ps2 = con.prepareStatement("UPDATE checkindetails INNER JOIN (transactions INNER JOIN menu ON transactions.food_id = menu.id) ON transactions.id = checkindetails.id SET checkindetails.total_cost = transactions.quantity * menu.cost + checkindetails.total_cost");
            ps.executeUpdate();
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Total cost calculated successfully");

            DefaultTableModel cInT = (DefaultTableModel) cInDetails.getModel();
            cInT.setRowCount(0);

            ShowCheckInDetailsInTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Operation failed");
        }

    }//GEN-LAST:event_totalCostActionPerformed
    
    // Insert customer details into checkindetails table. The availability status of a room (chosen by the customer) will be changed to 'NA'
    // (Short form of not available). The customer id is inserted into the id column in table transactions.
    private void INSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTActionPerformed
        if (inputCheck() != false) {
            System.out.println(inputCheck());
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO checkindetails (first_name, last_name, address, contact_no, personal_id_no, room_type, room_no, check_in_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                PreparedStatement ps2 = con.prepareStatement("UPDATE room SET room.availability = 'NA' WHERE room.room_no = ? ");
                PreparedStatement ps3 = con.prepareStatement("INSERT INTO transactions (id) VALUES(?)");

                ps.setString(1, fname.getText());
                ps.setString(2, lname.getText());
                ps.setString(3, address.getText());
                ps.setString(4, cno.getText());

                SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                String formatted_date = dformat.format(checkIn.getDate());

                int rN = Integer.parseInt((String) rn.getSelectedItem().toString());

                ps.setString(5, cid.getText());
                ps.setString(6, rt.getSelectedItem().toString());
                ps.setInt(7, rN);
                ps.setString(8, formatted_date);

                ps2.setInt(1, rN);

                ps.executeUpdate();
                ps2.executeUpdate();

                PreparedStatement psq = con.prepareStatement("SELECT id FROM checkindetails");
                ResultSet rs = psq.executeQuery();

                int last_id = 0;

                while (rs.next()) {
                    last_id = rs.getInt("id");
                }

                ps3.setInt(1, last_id);

                ps3.executeUpdate();

                JOptionPane.showMessageDialog(null, "Room successfully booked");

                DefaultTableModel cInT = (DefaultTableModel) cInDetails.getModel();
                cInT.setRowCount(0);

                DefaultTableModel transactions = (DefaultTableModel) transaction_list.getModel();
                transactions.setRowCount(0);

                ShowCheckInDetailsInTable();
                ShowTransactionDetailsInTable();
            } catch (SQLException ex) {
                // ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Room is not booked");
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or More Field Are Empty");
        }
    }//GEN-LAST:event_INSERTActionPerformed
    
    // The second frame (MenuandRoom) will be visible. This frame shows details about room and menu.
    private void menu_and_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_and_roomActionPerformed
        // TODO add your handling code here:

        MenuandRoom second_frame = new MenuandRoom();
        second_frame.setVisible(true);
    }//GEN-LAST:event_menu_and_roomActionPerformed

    // Populate the JTable with the latest data available.
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel cInT = (DefaultTableModel) cInDetails.getModel();
        cInT.setRowCount(0);

        ShowCheckInDetailsInTable();

        DefaultTableModel transactions = (DefaultTableModel) transaction_list.getModel();
        transactions.setRowCount(0);

        ShowTransactionDetailsInTable();
       
    }//GEN-LAST:event_refreshActionPerformed
    
    // Shows the available room of a particular type (chosen by the user).
    private void rtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT room_no FROM room WHERE room.availability = 'A' AND room.room_type = ?");
                
            ps.setString(1, rt.getSelectedItem().toString());
            rn.removeAllItems();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rn.addItem(rs.getString("room_no"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_rtActionPerformed
    
    private void cOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cOut2ActionPerformed
        // TODO add your handling code here:
        if (id.getText() != null && checkOut.getDate() != null) {
            try {
                Connection con = getConnection();
                // If the SQL statement below is executed, it will fill the field check_out_date in table checkindetails.
                PreparedStatement ps = con.prepareStatement("UPDATE checkindetails SET check_out_date = ? WHERE checkindetails.id = ?");
                // The room which was not available will now be available as the customer checked out from the hotel.
                PreparedStatement ps2 = con.prepareStatement("UPDATE checkindetails INNER JOIN room ON checkindetails.room_no = room.room_no SET room.availability = 'A' WHERE checkindetails.id = ?");
                SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                String formatted_date2 = dformat.format(checkOut.getDate());

                int fid = Integer.parseInt(id.getText());

                ps.setString(1, formatted_date2);
                ps.setInt(2, fid);

                ps.executeUpdate();
                
                ps2.setInt(1, fid);
                
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Check Out Successfull");

                DefaultTableModel cInT = (DefaultTableModel) cInDetails.getModel();
                cInT.setRowCount(0);

                ShowCheckInDetailsInTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                JOptionPane.showMessageDialog(null, "Check out failed");
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_cOut2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button INSERT;
    private javax.swing.JTextField address;
    private javax.swing.JTable cInDetails;
    private java.awt.Button cOut2;
    private com.toedter.calendar.JDateChooser checkIn;
    private com.toedter.calendar.JDateChooser checkOut;
    private javax.swing.JTextField cid;
    private javax.swing.JTextField cno;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lname;
    private javax.swing.JButton menu_and_room;
    private java.awt.Button refresh;
    private javax.swing.JComboBox<String> rn;
    private javax.swing.JComboBox<String> rt;
    private java.awt.Button totalCost;
    private javax.swing.JTextField totalP;
    private javax.swing.JTable transaction_list;
    // End of variables declaration//GEN-END:variables
}
