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
@WebServlet(urlPatterns = {"/TresEnRaya"})
public class TresEnRaya extends HttpServlet {

    /*
        Metodo que recibe la petición con sus parametros y genera un HTML
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Controller cont = new Controller();

        try ( PrintWriter out = response.getWriter()) {
            try {
                /* 
                    Variables que buscan dentro de la petición los parametros 
                    para cada casilla que se puede pulsar
                 */
                String a1 = request.getParameter("A1");
                String a2 = request.getParameter("A2");
                String a3 = request.getParameter("A3");
                String b1 = request.getParameter("B1");
                String b2 = request.getParameter("B2");
                String b3 = request.getParameter("B3");
                String c1 = request.getParameter("C1");
                String c2 = request.getParameter("C2");
                String c3 = request.getParameter("C3");
                String restart = request.getParameter("clear");

                boolean hayParametro = false;

                /*
                    En cada uno de estos if se comprueba que el parametro no
                    está a null (lo que quiere decir que ha sido pulsada en web)
                    y que además esa casilla no tiene ya un valor en el 
                    controlador.
                
                    Si la condición es true se procede a guardar en el
                    controlador la casilla que se ha pulsado y que hay parametro
                    para evitar que se pase un turno la primera vez que se abre
                    el juego.
                 */
                if (a1 != null && cont.isFree(FParser.A1)) {
                    cont.pasaCasilla(FParser.A1);
                    hayParametro = true;
                }
                if (a2 != null && cont.isFree(FParser.A2)) {
                    cont.pasaCasilla(FParser.A2);
                    hayParametro = true;
                }
                if (a3 != null && cont.isFree(FParser.A3)) {
                    cont.pasaCasilla(FParser.A3);
                    hayParametro = true;
                }
                if (b1 != null && cont.isFree(FParser.B1)) {
                    cont.pasaCasilla(FParser.B1);
                    hayParametro = true;
                }
                if (b2 != null && cont.isFree(FParser.B2)) {
                    cont.pasaCasilla(FParser.B2);
                    hayParametro = true;
                }
                if (b3 != null && cont.isFree(FParser.B3)) {
                    cont.pasaCasilla(FParser.B3);
                    hayParametro = true;
                }
                if (c1 != null && cont.isFree(FParser.C1)) {
                    cont.pasaCasilla(FParser.C1);
                    hayParametro = true;
                }
                if (c2 != null && cont.isFree(FParser.C2)) {
                    cont.pasaCasilla(FParser.C2);
                    hayParametro = true;
                }
                if (c3 != null && cont.isFree(FParser.C3)) {
                    cont.pasaCasilla(FParser.C3);
                    hayParametro = true;
                }
                boolean ganado = false;

                /*
                    Aquí se comprueba si ha ganado el jugador X o el O y se
                    manda al navegador una alerta de quien es el ganador
                 */
                if (cont.ganaX()) {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Gana x');");
                    out.println("</script>");
                    ganado = true;
                    cont.limpiaCasillas();
                }
                if (cont.ganaO()) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Gana O');");
                    out.println("</script>");
                    ganado = true;
                    cont.limpiaCasillas();
                }

                /*
                    Aquí se comprueba si es el fin de la partida o si se ha 
                    pulsado restart para borrar las casillas en el controlador.
                    
                    Si no es ninguna de estas entonces se pasa turno si se ha
                    pulsado un boton y no se ha ganado
                 */
                if (cont.finDePartida() || restart != null) {
                    cont.limpiaCasillas();
                } else {
                    if (hayParametro && !ganado) {
                        cont.pasaTurno();
                    }
                }
            } catch (Exception e) {

            }

            /*
                Este es el codigo html que se envia en respuesta a la petición, 
                lo tenemos en String para poder modificarlo según las jugadas 
                que se vayan ejecutando. 
                
                Donde haya <input type=submit name=A1 value=\u200e> el \u200e es
                un espacio en blanco y se sustituye por X o O en cada turno.
             */
            String cadena1 = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "    <title>juego</title>"
                    + "    <style>"
                    + "        .cabecera {"
                    + "            margin: auto;"
                    + "            width: 50%;"
                    + "            height: 10vh;"
                    + "            background: red;"
                    + "        }"
                    + ""
                    + "        table {"
                    + "            margin: auto;"
                    + "            border: 3px solid green;"
                    + "            padding: 10px;"
                    + "        }"
                    + ""
                    + "        input {"
                    + "            width: 20vh;"
                    + "            height: 20vh;"
                    + "            font-size: 15vh;"
                    + "        }"
                    + "        table.restart {"
                    + "            margin: auto;"
                    + "            border: 3px solid blue;"
                    + "            width: 50%;"
                    + "            padding: 10px;"
                    + "        }"
                    + "        input.restart {"
                    + "            width: 100%;"
                    + "            height: 10vh;"
                    + "            font-size: 7vh;"
                    + "        }"
                    + "    </style>"
                    + "</head>"
                    + "<body>"
                    + "    <div class=cabecera>"
                    + "        <h1>3 EN RAYA</h1>"
                    + "    </div>"
                    + "    <form action=TresEnRaya method=get>"
                    + "        <table>"
                    + "            <tr>"
                    + "                <td><input type=submit name=A1 value=\u200e></td>"
                    + "                <td><input type=submit name=A2 value=\u200e></td>"
                    + "                <td><input type=submit name=A3 value=\u200e></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td><input type=submit name=B1 value=\u200e></td>"
                    + "                <td><input type=submit name=B2 value=\u200e></td>"
                    + "                <td><input type=submit name=B3 value=\u200e></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td><input type=submit name=C1 value=\u200e></td>"
                    + "                <td><input type=submit name=C2 value=\u200e></td>"
                    + "                <td><input type=submit name=C3 value=\u200e></td>"
                    + "            </tr>"
                    + "        </table>"
                    + "    </form>"
                    + "    <form>"
                    + "        <table class=\"restart\">"
                    + "            <tr>"
                    + "                <td><input type=submit name=clear value=RESTART class=\"restart\"></td>"
                    + "            </tr>"
                    + "        </table>"
                    + "    </form>"
                    + "</body>"
                    + "</html>";
            
            // Aquí es donde se mofican los valores del html desde el controlador
            
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
    /*
        Metodo que recibe la petición del navegador cuando es enviada por GET
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
    /*
        Metodo que recibe la petición del navegador cuando es enviada por POST
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
