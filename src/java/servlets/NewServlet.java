package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import clases.Controller;
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
                //cont.pasaCasilla(1);
            }
            if (a2 != null) {
                //cont.pasaCasilla(2);
            }
            if (a3 != null) {
                //cont.pasaCasilla(2);
            }
            if (b1 != null) {
                //cont.pasaCasilla(2);
            }
            if (b2 != null) {
                //cont.pasaCasilla(2);
            }
            if (b3 != null) {
                //cont.pasaCasilla(2);
            }
            if (c1 != null) {
                //cont.pasaCasilla(2);
            }
            if (c2 != null) {
                //cont.pasaCasilla(2);
            }
            if (c3 != null) {
                //cont.pasaCasilla(2);
            }
            } catch (Exception e) {

            }

            String cadenaFinal = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>juego</title>\n"
                    + "        <style>\n"
                    + "            .cabecera {\n"
                    + "                margin: auto;\n"
                    + "                width: 50%;\n"
                    + "                height: 10vh;\n"
                    + "                background: red;\n"
                    + "            }\n"
                    + "            table{\n"
                    + "                margin: auto;\n"
                    + "                border: 3px solid green;\n"
                    + "                padding: 10px;\n"
                    + "            }\n"
                    + "            input{\n"
                    + "                width: 20vh;\n"
                    + "                height: 20vh;\n"
                    + "                font-size: 15vh;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class=\"cabecera\">\n"
                    + "            <h1>3 en raya</h1>\n"
                    + "        </div>\n"
                    + "        <form action=\"NewServlet\" method=\"get\">\n"
                    + "            <table>\n"
                    + "                <tr>\n"
                    + "                    <td><input type=\"submit\" name=\"A1\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"A2\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"A3\" value=\"\u200e\"></button></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td><input type=\"submit\" name=\"B1\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"B2\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"B3\" value=\"\u200e\"></button></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td><input type=\"submit\" name=\"C1\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"C2\" value=\"\u200e\"></button></td>\n"
                    + "                    <td><input type=\"submit\" name=\"C3\" value=\"\u200e\"></button></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </form>\n"
                    + "    </body>\n"
                    + "\n"
                    + "</html>\n"
                    + "";
            Controller cont = new Controller();
           

            cont.cambiaValores(cadenaFinal);
            out.println(cadenaFinal);

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
