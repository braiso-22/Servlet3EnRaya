/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author rodrigo.garciaedreir
 */
public class FParser {

    /*
    Una variable que contendrá un objeto de esta clase, pues esta clase sigue
    el patrón Singleton, que permite una sola instanciación de la misma.
    El objeto almacenado en esta variable se podrá obtener mediante el método
    getInstance()
    */
    private static FParser gestorArchivo = null;
    
    /*
    Estas variables finales contienen la localización que tendrán
    las "casillas" que nosotros vemos en el tres en raya (Letras = Dirección
    horizontal - Números = Dirección vertical) tal cuál las ve DOM en el archivo
    XML.
    Así pués, si queremos actuar sobre la casilla "A1", actuaríamos en DOM sobre
    el valor "0".
    Si queremos actuar sobre el espacio en DOM dónde se almacena el turno,
    actuaríamos sobre el valor 9.
    */
    public static final int A1 = 0;
    public static final int A2 = 1;
    public static final int A3 = 2;
    public static final int B1 = 3;
    public static final int B2 = 4;
    public static final int B3 = 5;
    public static final int C1 = 6;
    public static final int C2 = 7;
    public static final int C3 = 8;
    public static final int TURNO = 9;
    
    /*
    Esta variable guarda la localización el archivo, se emplea en el constructor
    y en el método guardar()
    */
    private File archivo;
    
    /*
    Esta variable guarda el documento que DOM formará a partir del XML, también
    para ser usado en el constructor y guardar()
    */
    private Document doc;
    
    /*
    En esta variable se almacenan las casillas que DOM interpreta en el XML,
    actuaremos sobre esta variable para tratar la información.
    */
    private NodeList casillas;

    // Constructor puesto como privado, sigue un patrón Singleton.
    private FParser() {

        // Se instancia la variable archivo con el XML que emplearemos.
        archivo = new File("3ralla.xml");

        try {
            /*
            Si el archivo no existe, se crea, y se escribe la estructura que
            seguirá nuestro XML en el archivo.
            */
            if (archivo.createNewFile()) {
                FileWriter fw = new FileWriter(archivo, false);
                /*
                La información del archivo se interpretará en el futuro de la
                siguiente manera: las etiquetas desde <A1> hasta <C3>
                representan una posición del tablero:
                - Si en esa posición existe un "0", esa posición está vacía.
                - Si existe un "1", esa posición ha sido marcada por el jugador
                uno, que está jugando con las "X".
                - Si existe un "2", esa posición ha sido marcada por el jugador
                dos, que está jugando con las "O".
                La etiqueta <TURNO> representa el turno actual en el que se
                encuentra la partida.
                */
                fw.write("<partida><A1>0</A1><A2>0</A2><A3>0</A3><B1>0</B1><B2>0</B2><B3>0</B3><C1>0</C1><C2>0</C2><C3>0</C3><TURNO>0</TURNO></partida>");
                fw.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(FParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Tras crear el XML o comprobar que existe uno, comenzamos a crear el
        árbol DOM del mismo.
        */
        try ( FileInputStream fis = new FileInputStream(archivo);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            // Se crea un gestor de documentos, vinculado a nuestro XML.
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = fabrica.newDocumentBuilder();
            doc = dB.parse(new InputSource(isr));

            // Se accede a la etiqueta raíz del XML, en este caso: <partida>
            Element raiz = doc.getDocumentElement();

            /*
            Se obtienen los hijos de esa etiqueta, en este caso comprenden desde
            <A1> a <C3> más la etiqueta <TURNO>
            Esta variable la usaremos más adelante para escribir sobre el
            documento del DOM.
            */
            casillas = raiz.getChildNodes();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /*
    El método getInstance() se emplea em patrones singleton para asegurar que
    solo se crea un objeto de la clase en cuestión y que ese mismo objeto es el
    que se distribuye a todos los procesos que pidan uno.
    */
    public static FParser getInstance() {
        
        if (gestorArchivo == null) {
            gestorArchivo = new FParser();
        }

        return gestorArchivo;

    }

    // Devuelve el valor de la casilla que se le indique
    public int getValor(int casilla) {

        /*
        Se accede a la variable casillas, obtenemos el item de casillas que
        coincide con el integer que se nos ha pasado (en el código de mis
        compañeros, nos pasaran una de las variables finales de arriba por
        parámetro), se obtiene el String que contiene ese item y se pasa a int.
        */
        return Integer.parseInt(casillas.item(casilla).getTextContent());

    }

    // Devuelve los valores de todas las casillas. Exluye el turno.
    public int[] getCasillas() {

        // Todo el XML menos la última etiqueta, que es <TURNO>.
        int nCasillas = casillas.getLength() - 1;

        int[] casillas = new int[nCasillas];

        for (int i = 0; i < nCasillas; i++) {
            casillas[i] = getValor(i);
        }

        return casillas;

    }

    // Establece en la etiqueta del XML indicada, el valor indicado.
    public void setValor(int casilla, int valor) {

        casillas.item(casilla).setTextContent(String.valueOf(valor));

        guardar();

    }

    // Devuelve el turno actual.
    public int getTurno() {
        
        return Integer.parseInt(casillas.item(9).getTextContent());

    }

    // Establece el valor de todas las etiquetas del XML a 0.
    public void clear() {

        for (int i = 0; i < 10; i++) {
            setValor(i, 0);
        }

        guardar();

    }

    // Vuelca el contenido actual de la variable "doc" en el XML.
    private void guardar() {

        try {

            // Se prepara el transformer para guardar en archivo.
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            // Se guarda "doc" en "archivo".
            transformer.transform(new DOMSource(doc), new StreamResult(archivo));

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
