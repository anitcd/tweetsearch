/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retrieval;

import java.sql.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author anirban
 */
    public class JDBC extends DefaultHandler {
    
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/TWT";

        //  Database credentials
        static final String USER = "root";
        //static final String PASS = "123456";  // from Local
        static final String PASS = "password";  // from achakrab@vma57.scss.tcd.ie
        
        public JDBC() throws Exception {

        }
   
   public String JDBCmain(int UID, long TweetID, int Rank, String Query) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      

      //System.out.println("UID: " + UID + "TID: " + TweetID + "Rank: " + Rank + "Query: " + Query);
      //String sql = "INSERT INTO `TWT`.`TweetLog` (`UID`, `TweetID`, `Rank`, `Query`) VALUES ('12', '102', '3', '#MAGA');";
      String sql = "INSERT INTO `TWT`.`TweetLog` (`UID`, `TweetID`, `Rank`, `Query`) VALUES ('" + UID +"', '" + TweetID +"', '" + Rank + "', '" + Query + "');";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
      return "Database created successfully...";
   }catch(SQLException se){
      //Handle errors for JDBC
       System.out.println("err1...");
      se.printStackTrace();
        return "err1...";
   }catch(Exception e){
      //Handle errors for Class.forName
       System.out.println("err2...");
      e.printStackTrace();
        return "err2..."+e.toString();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   //System.out.println("Goodbye!");
    
}//end main
}
