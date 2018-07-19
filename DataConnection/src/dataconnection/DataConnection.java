/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author amruth
 */
public class DataConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String sql = "select * from login where user=? and password=?";
        String url = "jdbc:mysql://localhost:3306/exza?useSSL=true";
        String userMysql = "amruth";
        String pwdMysql = "root";
        String dbUser, dbPwd;
        boolean login = false;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Test");
        Connection con = DriverManager.getConnection(url,userMysql,pwdMysql);
        System.out.println("Database connected:");
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "user");
        stmt.setString(2, "pwd");
        ResultSet rs = stmt.executeQuery();
        System.out.println("Query Data:" + rs.getFetchSize());
        while (rs.next()) {
            dbUser = rs.getString("user");
            dbPwd = rs.getString("password");

            if (dbUser.equals("user") && dbPwd.equals("pwd")) {

                login = true;
            }
        }
    }

}
