/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 798419
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String btnA = request.getParameter("add");
        System.out.println(btnA+" --->get bntA");
        String btnB = request.getParameter("sub");
        System.out.println(btnB+" --->get bntB");
        String btnC = request.getParameter("mul");
        System.out.println(btnC+" --->get bntC");
        String btnD = request.getParameter("div");
        System.out.println(btnD+" --->get bntD");
        String message;
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        request.setAttribute("btnA", btnA);
        request.setAttribute("btnB", btnB);
        request.setAttribute("btnC", btnC);
        request.setAttribute("btnD", btnD);
        double result=0;

        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;

        if ("".equals(first) || "".equals(second) || first == null || second == null) {
            message = "Result: ---";
            System.out.println("result: ----");
        } else {
            try {
                double num1 = Double.parseDouble(first);
                double num2 = Double.parseDouble(second);
                System.out.println(first + "-------" + second);
                    

                if (request.getAttribute("btnA").equals("add")) {
                    result = num1 + num2;
                    message = "Result: " + result;
                    System.out.println("add: " + result);
                } else if (request.getAttribute("btnB").equals("sub")) {
                    result = num1 - num2;
                    message = "Result: " + result;
                    System.out.println("sub: " + result);
                } else if (request.getAttribute("btnC").equals("mul")) {
                    result = num1 * num2;
                    message = "Result: " + result;
                    System.out.println("mul: " + result);
                } else if (request.getAttribute("btnD").equals("div")) {
                    if (num2 == 0) {
                        message = "Result: invalid";
                    } else {
                        result = num1 / num2;
                        message = "Result: " + result;
                    }
                    System.out.println("div: " + result);
                } else {
                    message = "Nothing";
                }
                System.out.println("get number");
            } catch (Exception e) {
//                e.printStackTrace();
                message = "Result: invalid";
                System.out.println("exception");
            }
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/arithmeticcalculator.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
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
