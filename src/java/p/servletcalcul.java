/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package p;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21655
 */
public class servletcalcul extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String xa = request.getParameter("a");
        String xb = request.getParameter("b");
        String op = request.getParameter("op");
        String msg ;
        if ((xa.equals("")) && (xb.equals(""))) {
            msg = "Entrer valeurs de a et b";
        } else if (!(xa.equals("")) && (xb.equals(""))) {
            msg = "Entrer valeur b";
        } else if ((xa.equals("")) && (!xb.equals(""))) {
            msg = "Entrer valeur a";
        } else {
            Double x = Double.parseDouble(xa);
            Double y = Double.parseDouble(xb);

            Calculatrice c = new Calculatrice();
            double res = 0;
            switch (op) {
                case "+":
                    res = c.somme(x, y);
                    break;
                case "-":
                    res = c.soustraction(x, y);
                    break;
                case "*":
                    res = c.multiplication(x, y);
                    break;
                case "/":
                    res = c.division(x, y);
                    break;
            }
            msg = "Resultat: " + res;
        }
        request.setAttribute("msg", msg);
        RequestDispatcher rd = request.getRequestDispatcher("calculatrice.jsp");
        rd.forward(request, response);
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
