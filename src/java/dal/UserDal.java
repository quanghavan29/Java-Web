/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import entity.Categories;
import entity.Product;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserDal {

    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;

    public User getUser(String username, String password) {
        String query = "select * from [User]\n"
                + "where username = ? and password = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8));
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean checkUserExist(String username) {
        String query = "select * from [User]\n"
                + "where username = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void Register(String username, String password, String phone, String address) {
        String query = "insert into [User]\n"
                + "values(?, ?, '', ?, ?, 1, 'ROLE_user')";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        UserDal userDal = new UserDal();
        System.out.println(userDal.checkUserExist("mra"));
    }
}
