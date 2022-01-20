package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brais.fernandezvazqu
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "\n"
                    + "<head>\n"
                    + "    <link rel=\"stylesheet\" href=\"css.css\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <table >\n"
                    + "        <form method=\"get\">\n"
                    + "            <tr>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "                <td><input type=\"button\"></td>\n"
                    + "            </tr>\n"
                    + "        </form>\n"
                    + "\n"
                    + "    </table>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");

        } catch (Exception e) {

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
