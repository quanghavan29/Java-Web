/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AdminDal;
import dal.ClientDal;
import entity.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class UpdateProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int productId = Integer.parseInt(request.getParameter("productId"));
            ClientDal cdal = new ClientDal();
            AdminDal adal = new AdminDal();
            List<Categories> listCategories = adal.getAllCategory();
            request.setAttribute("product", cdal.getProduct(productId));
            request.setAttribute("listCategories", listCategories);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productDescription = request.getParameter("productDescription");
        int categoriesId = Integer.parseInt(request.getParameter("categoriesId"));
        AdminDal adal = new AdminDal();
        adal.updateProduct(categoriesId, productName, price, quantity, productDescription, image, productId);
        response.sendRedirect("listProduct");
//        
//        response.getWriter().println(productName);
//        response.getWriter().println(price);
//        response.getWriter().println(image);
//        response.getWriter().println(quantity);
//        response.getWriter().println(productDescription);
//        response.getWriter().println(categoriesId);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
