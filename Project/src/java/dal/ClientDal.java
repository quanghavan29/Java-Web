/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import entity.Cart;
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
public class ClientDal {

    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Product> getAllProductPagging(int pagIndex) {
        String query = "SELECT * FROM\n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY productId ASC)\n"
                + "as rownum, * from Product p) tbl\n"
                + "join Categories c on tbl.categoriesId = c.categoriesId\n"
                + "where rownum between ? and ?";
        List<Product> listP = new ArrayList<>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, pagIndex * 4 - 3);
            ps.setInt(2, pagIndex * 4);
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

    public List<Product> getAllProductSearchPagging(int pagIndex, String txtSearch) {
        String query = "SELECT * FROM\n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY productId ASC)\n"
                + "as rownum, * from Product p where productName like ?) tbl\n"
                + "join Categories c on tbl.categoriesId = c.categoriesId\n"
                + "where rownum between ? and ?";
        List<Product> listP = new ArrayList<>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, pagIndex * 4 - 3);
            ps.setInt(3, pagIndex * 4);
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

    public int totalPage() {
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
            if (count % 4 > 0) {
                totalPage = count / 4 + 1;
            } else {
                totalPage = count / 4;
            }
        } catch (Exception e) {
        }
        return totalPage;
    }

    public int totalPageSearch(String txtSearch) {
        String query = "select count(*) from Product\n"
                + "where productName like ?";
        int count = 0;
        int totalPage = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count % 4 > 0) {
                totalPage = count / 4 + 1;
            } else {
                totalPage = count / 4;
            }
        } catch (Exception e) {
        }
        return totalPage;
    }

    public Product getProduct(int productId) {
        String query = "select * from Product p\n"
                + "join Categories c\n"
                + "on p.categoriesId = c. categoriesId\n"
                + "where productId = ?";
        Product product = new Product();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories(rs.getInt(8), rs.getString(9));
                product = new Product(
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        categories);
            }
        } catch (Exception e) {
        }
        return product;
    }

    public int getQuantityProductInCartByProductId(int userId, int productId) {
        String query = "select c.quantity from Cart c\n"
                + "where userId = ? and productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return 0;
    }

    public void addProductToCart(int userId, int productId, int quantity) {
        String query = "insert into Cart\n"
                + "values(?, ?, ?)";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void updateQuantityProductInCart(int userId, int productId, int quantity) {
        String query = "update Cart\n"
                + "set quantity = ?\n"
                + "where userId = ? and productId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(2, userId);
            ps.setInt(3, productId);
            ps.setInt(1, quantity);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public List<Cart> getAllProductInCartByUserId(int userId) {
        List<Cart> listCart = new ArrayList<>();
        String query = "select * from Cart c\n"
                + "join [User] u\n"
                + "on c.userId = u.userId\n"
                + "join Product p\n"
                + "on c.productId = p.productId\n"
                + "join Categories cg\n"
                + "on p.categoriesId = cg.categoriesId\n"
                + "where u.userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
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
                Categories categories = new Categories(rs.getInt("categoriesId"), rs.getString("categoriesName"));
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getInt(17),
                        rs.getString("productDescription"),
                        rs.getString("image"),
                        categories);
                Cart cart = new Cart(rs.getInt("cartId"), user, product, rs.getInt("quantity"));
                listCart.add(cart);
            }
        } catch (Exception e) {
        }
        return listCart;
    }

    public void deleteCartItemByCartId(int cartId) {
        String query = "delete from Cart\n"
                + "where cartId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, cartId);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void updateQuantityCartItem(int cartId, int quantity) {
        String query = "update Cart\n"
                + "set quantity = ?\n"
                + "where cartId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void checkOut(int userId, int productId, int quantity) {
        String query = "insert into Orders\n"
                + "values (?, ?, ?, getDate(), 'waiting_line')";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void DeleteCartItem(int userId) {
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

    public List<Order> getAllOrderByUserId(int userId) {
        List<Order> listOrder = new ArrayList<>();
        String query = "select * from Orders o\n"
                + "join [User] u\n"
                + "on o.userId = u.userId\n"
                + "join Product p\n"
                + "on o.productId = p.productId\n"
                + "join Categories cg\n"
                + "on p.categoriesId = cg.categoriesId\n"
                + "where u.userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, userId);
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
                Categories categories = new Categories(rs.getInt("categoriesId"), rs.getString("categoriesName"));
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getInt(19),
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

    public void editInformation(int userId, String fullName, String phone, String address) {
        String query = "update [User]\n"
                + "set fullName = ?,\n"
                + "phone = ?,\n"
                + "address = ?\n"
                + "where userId = ?";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ClientDal p = new ClientDal();
        System.out.println(p.getAllProductSearchPagging(1, "vans"));
    }
}
