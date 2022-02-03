package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import clases.Controller;
import clases.FParser;
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
        Controller cont = new Controller();
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String a1 = request.getParameter("A1");
                String a2 = request.getParameter("A2");
                String a3 = request.getParameter("A3");
                String b1 = request.getParameter("B1");
                String b2 = request.getParameter("B2");
                String b3 = request.getParameter("B3");
                String c1 = request.getParameter("C1");
                String c2 = request.getParameter("C2");
                String c3 = request.getParameter("C3");
                if (a1 != null) {
                    cont.pasaCasilla(FParser.A1);
                }
                if (a2 != null) {
                    cont.pasaCasilla(FParser.A2);
                }
                if (a3 != null) {
                    cont.pasaCasilla(FParser.A3);
                }
                if (b1 != null) {
                    cont.pasaCasilla(FParser.B1);
                }
                if (b2 != null) {
                    cont.pasaCasilla(FParser.B2);
                }
                if (b3 != null) {
                    cont.pasaCasilla(FParser.B3);
                }
                if (c1 != null) {
                    cont.pasaCasilla(FParser.C1);
                }
                if (c2 != null) {
                    cont.pasaCasilla(FParser.C2);
                }
                if (c3 != null) {
                    cont.pasaCasilla(FParser.C3);
                }
            } catch (Exception e) {

            }

            String cadena1 = "<!DOCTYPE html>"
                    + "<html>"
                    + "    <head>"
                    + "        <title>juego</title>"
                    + "        <style>"
                    + "            .cabecera {"
                    + "                margin: auto;"
                    + "                width: 50%;"
                    + "                height: 10vh;"
                    + "                background: red;"
                    + "            }"
                    + "            table{"
                    + "                margin: auto;"
                    + "                border: 3px solid green;"
                    + "                padding: 10px;"
                    + "            }"
                    + "            input{"
                    + "                width: 20vh;"
                    + "                height: 20vh;"
                    + "                font-size: 15vh;"
                    + "            }"
                    + "        </style>"
                    + "    </head>"
                    + "    <body>"
                    + "        <div class=\"cabecera\">"
                    + "            <h1>3 en raya</h1>"
                    + "        </div>"
                    + "        <form action=\"NewServlet\" method=\"get\">"
                    + "            <table>"
                    + "                <tr>"
                    + "                    <td><input type=\"submit\" name=\"A1\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"A2\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"A3\" value=\"\u200e\"></button></td>"
                    + "                </tr>"
                    + "                <tr>"
                    + "                    <td><input type=\"submit\" name=\"B1\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"B2\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"B3\" value=\"\u200e\"></button></td>"
                    + "                </tr>"
                    + "                <tr>"
                    + "                    <td><input type=\"submit\" name=\"C1\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"C2\" value=\"\u200e\"></button></td>"
                    + "                    <td><input type=\"submit\" name=\"C3\" value=\"\u200e\"></button></td>"
                    + "                </tr>"
                    + "            </table>"
                    + "        </form>"
                    + "    </body>"
                    + ""
                    + "</html>"
                    + "";

            cadena1 = cont.cambiaValores(cadena1);
            out.println(cadena1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
