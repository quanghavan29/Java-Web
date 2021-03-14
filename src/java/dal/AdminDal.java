/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import entity.Categories;
import entity.Order;
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
public class AdminDal {

    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;

    public int countUser() {
        String query = "select count(*) from [User]";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countProduct() {
        String query = "select count(*) from Product";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countOrder() {
        String query = "select count(*) from Orders";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> getAllProductPagging(int pageIndex) {
        String query = "SELECT * FROM\n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY productId ASC)\n"
                + "as rownum, * from Product p) tbl\n"
                + "join Categories c on tbl.categoriesId = c.categoriesId\n"
                + "where rownum between ? and ?";
        List<Product> listP = new ArrayList<>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, pageIndex * 5 - 4);
            ps.setInt(2, pageIndex * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories(rs.getInt(9), rs.getString(10));
                listP.add(new Product(
                        rs.getInt(2),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        categories));
            }
        } catch (Exception e) {
        }
        return listP;
    }

    public int totalPageListProduct() {
        String query = "select count(*) from Product";
        int count = 0;
        int totalPage = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count % 5 > 0) {
                totalPage = count / 5 + 1;
            } else {
                totalPage = count / 5;
            }
        } catch (Exception e) {
        }
        return totalPage;
    }

    public List<User> getAllUserPagging(int pageIndex) {
        String query = "SELECT * FROM\n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY userId ASC)\n"
                + "as rownum, * from [User]) tbl\n"
                + "where rownum between ? and ?";

        List<User> listUser = new ArrayList<>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, pageIndex * 5 - 4);
            ps.setInt(2, pageIndex * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getString(9));
                listUser.add(user);
            }
        } catch (Exception e) {
        }
        return listUser;
    }

    public int totalPageListUser() {
        String query = "select count(*) from [User]";
        int count = 0;
        int totalPage = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count % 5 > 0) {
                totalPage = count / 5 + 1;
            } else {
                totalPage = count / 5;
            }
        } catch (Exception e) {
        }
        return totalPage;
    }

    public List<Order> getAllOrderPagging(int pageIndex) {
        List<Order> listOrder = new ArrayList<>();
        String query = "select * from\n"
                + "(select ROW_NUMBER() over  (order by orderDate DESC)\n"
                + "as rownum, * from Orders) o\n"
                + "join Product p\n"
                + "on o.productId = p.productId\n"
                + "join [User] u\n"
                + "on u.userId = o.userId\n"
                + "where rownum between ? and ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, pageIndex * 5 - 4);
            ps.setInt(2, pageIndex * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getBoolean("gender"),
                        rs.getString("role"));
                Categories categories = new Categories();
                categories.setCategoriesId(rs.getInt("categoriesId"));
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getInt(12),
                        rs.getString("productDescription"),
                        rs.getString("image"),
                        categories);
                Order order = new Order(rs.getInt("orderId"), user, product, rs.getInt("quantity"), rs.getDate("orderDate"), rs.getString("status"));
                listOrder.add(order);
            }
        } catch (Exception e) {
        }
        return listOrder;
    }

    public int totalPageListOrder() {
        String query = "select count(*) from Orders";
        int count = 0;
        int totalPage = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count % 5 > 0) {
                totalPage = count / 5 + 1;
            } else {
                totalPage = count / 5;
            }
        } catch (Exception e) {
        }
        return totalPage;
    }

    public void insertNewUser(String username, String password, String fullName, String phone, String address, boolean gender, String role) {
        String query = "insert into [User]\n"
                + "values(?, ?, ?, ?, ?, ?, ?)";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setBoolean(6, gender);
            ps.setString(7, role);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAccount(int userId) {
        String query = "delete from [User]\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCartByUserId(int userId) {
        String query = "delete from Cart\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrderByUserId(int userId) {
        String query = "delete from Orders\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrderByOrderId(int orderId) {
        String query = "delete from Orders\n"
                + "where orderId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateStatusOrder(int orderId) {
        String query = "update Orders\n"
                + "set status = 'success'\n"
                + "where orderId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User getUserByUsername(int userId) {
        String query = "select * from [User]\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
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

    public void updateAccount(String password, String fullName, String phone, String address, boolean gender, String role, int userId) {
        String query = "update [User]\n"
                + "set password = ?,\n"
                + "fullName = ?,\n"
                + "phone = ?,\n"
                + "address = ?,\n"
                + "gender = ?,\n"
                + "role = ?\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, fullName);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setBoolean(5, gender);
            ps.setString(6, role);
            ps.setInt(7, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Categories> getAllCategory() {
        List<Categories> list = new ArrayList<Categories>();
        String query = "select * from Categories";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Categories(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProductByProductId(int productId) {
        String query = "delete from Product\n"
                + "where productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(int categoriesId, String productName, float price, int quantity, String description, String image) {
        String query = "insert into Product\n"
                + "values(?, ?, ?, ?, ?, ?)";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, categoriesId);
            ps.setString(2, productName);
            ps.setFloat(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, description);
            ps.setString(6, image);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public float totalAmountOfSales() {
        String query = "select sum(o.quantity * p.price) \n"
                + "from Orders o\n"
                + "join Product p\n"
                + "on o.productId = p. productId\n"
                + "where o.status = 'success'";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void deleteOrderByProductId(int productId) {
        String query = "delete from Orders\n"
                + "where productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCartByProductId(int productId) {
        String query = "delete from Cart\n"
                + "where productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int categoriesId, String productName, float price, int quantity, String productDescription, String image, int productId) {
        String query = "update Product\n"
                + "set categoriesId = ?,\n"
                + "productName = ?,\n"
                + "price = ?,\n"
                + "quantity = ?,\n"
                + "productDescription = ?,\n"
                + "[image] = ?\n"
                + "where productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, categoriesId);
            ps.setString(2, productName);
            ps.setFloat(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, productDescription);
            ps.setString(6, image);
            ps.setInt(7, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        AdminDal adal = new AdminDal();
        System.out.println(adal.totalAmountOfSales());
    }
}
