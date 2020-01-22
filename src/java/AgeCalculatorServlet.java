/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 798419
 */
public class AgeCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int counter;//

    @Override
    public void init() throws ServletException {
        counter = 0;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String yourAge = request.getParameter("yourAge");
        String message = null;
        System.out.println("yourage: " + yourAge);
        request.setAttribute("yourAge", yourAge);
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;

        if (yourAge != null) {
            Integer num;
            try {
                num = Integer.parseInt(yourAge);
                if (num >= 0) {
                    message = "your next birthday is " + (num + 1) + "<br>";
                } else {
                    message = "You must give your current age.<br>";
                }
            } catch (Exception e) {
                System.out.println("exception");
                message = "You must enter a number.<br>";
            }
            System.out.println("message: " + message);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/agecalculator.jsp").forward(request, response);
        }
        
        if (message == null) {
            System.out.println("message: " + message);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/agecalculator.jsp").forward(request, response);
        }

    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
