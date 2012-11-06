/*
 * This class provides:
 * 
 * 1) methods to work with server connection,
 * 2) methods to process db data;
 * 3) local copy of DB data (stored in resultSet objects) to provide quick data
 *    processing in comparison with sql queries.
 * 4) connection used for login and work;
 */


package crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kexital
 */
public class LocDbProvider {
    // 
    private static Connection conn = null;
    private static Statement stmnt = null;
    
    // TODO review access midifiers:
    public static ResultSet firmData = null;  
    private static ResultSet contatsData = null;
//    private static ResultSet sf = null;
//    private static ResultSet sdf = null;
//    private static ResultSet sdff = null;
    private static int firmListLength;
    
    private static int fTLenth;
    
    
    public LocDbProvider() {
        try { 
            setConection();
            loadFirmData();
            // set FirmListLength before using of any of gui-related
            // methods like getFirmList.
            setFirmListLength();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocDbProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }
    
    String serverIP ="192.168.3.3", port = "3306", dbname = "CRM",
                user = "cs4pc", pass = "0229065nenet";
    String selectQuery = "SELECT * FROM Companies;";
    String conQuery = "jdbc:mysql://" + serverIP +":"+
                port+ "/" + dbname +"?user=" + user +
                "&" + "password=" + pass;
    private void setConection() throws SQLException {
        try {
            System.out.print("setting a connection............     ");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.3.115:3306/CRM?user=cs4pc&password=0229065nenet");
            System.out.println("OK");
        } 
        catch (SQLException e) {
            System.out.println( "CRM Connection error:" + e);
            conn.close();
        }
        finally {
          //TODO : Call crm err vindow with err summary  
        }
    }
    private void loadFirmData() throws SQLException{
        try {
            System.out.print("Loading FirmTble.........  ");
            stmnt = conn.createStatement();
            firmData = stmnt.executeQuery(selectQuery);
            System.out.println("OK");
        } catch (Exception e) { 
            System.out.println("CRM SQL Select or conn error:" + e);
            conn.close();
        }
        finally {
            //TODO : Call crm err vindow with err summary
            //TODO close connection when program laods all data or exits;
        }
    }
    
    public int getFirmListLength (){
        return firmListLength;
    }
    private void setFirmListLength(){
//        !!! Set FirmListLength before using of any
//        of gui-related methods like getFirmList
        try {
            firmData.last();
            firmListLength=firmData.getRow();
            firmData.first();
        } catch (SQLException ex) {
            System.out.println("CRM_Connection_related_error. PrintStack:" + ex);
            Logger.getLogger(LocDbProvider.class.getName()).log(Level.INFO, null, ex);
        }
       
                
//      TODO Fogot about using System.err - its depricated for production, 
//      because of its using may cause you to lose important error information.
//      You are able to use it during testing or development but not Production.
//      Use Logger (java.util.logging.Logger) or other loggin framework instead.
//      System.err;
        
    };

//    public final String[] getFirmList() throws SQLException {
//        firmData.last();
//        fTLenth = firmData.getRow();
//        int rowLength = 6;  // length without table "autoicnrement" and "ID" fields
//        String arr[] = new String[fTLenth];
//        try { 
//            
//            firmData.first();
//            int top = 0;
//            do {
//                    for (int i=0; i<rowLength; i++){
//                        arr[top] = firmData.getString(i+2);   //+2 ass we should begun from 1 (resultset colomns id begin from 1) + we skip ID field (additional +1)
//                        top++;
//                    } 
//                    
//                } while (firmData.next());
//            }
//            catch (Exception e) {
//                
//            }
//        return arr;
//        
//    }
     public final String getFirmList(int carret) throws SQLException  {
        // length without table "autoicnrement" and "ID" fields = 6
        // even list elements - 2-nd ResultSet row, odd- 6-th
        // TODO AbstractList get elements by i position begining from
        // 0 (as used to use String arrays)

        carret++;
        String value;
        String arr[] = new String[fTLenth];
        
             if (carret == 1) { 
                 firmData.first();
                 value = firmData.getString(2);
             } else { 
                 if (carret == 2){
                     firmData.first();
                     value = firmData.getString(6);
                 } else{
                     /// сцука ппц метод напиши красиво
                 if (carret%2 != 0) {
                     firmData.absolute((carret+1)/2);
                     value =firmData.getString(2);                
                 } else { 
                     firmData.absolute(carret/2);
                     value = firmData.getString(6); }
                 }
            }
        return value;   
        
     
    }
     public final String[] getAllFirmData() throws SQLException {
        firmData.last();
        fTLenth = firmData.getRow();
        int rowLength = 6;  // length without table "autoicnrement" and "ID" fields
        String arr[] = new String[fTLenth];
        try { 
            
            firmData.first();
            int top = 0;
            do {
                    for (int i=0; i<rowLength; i++){
                        arr[top] = firmData.getString(i+2);   //+2 ass we should begun from 1 (resultset colomns id begin from 1) + we skip ID field (additional +1)
                        top++;
                    } 
                    
                } while (firmData.next());
            }
            catch (Exception e) {
                
            }
        return arr;
        
    }
    
//    public static void main ( String[] args) throws SQLException {
//        LocDbProvider d = new LocDbProvider();
//        d.setConection();
//        d.loadFirmData();
//        while (firmData.next()) {
//            for (int i=1;i<5;i++){
//               System.out.print(firmData.getString(i)+" ");
//               conn.close();
//            }
//            System.out.println();
//            
//        }
            
            
       
//    }
    
    
}
    
