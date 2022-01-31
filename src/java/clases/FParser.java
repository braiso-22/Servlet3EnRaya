/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.io.FileInputStream;
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
    
    private static FParser gestorArchivo = null;
    
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
    private File archivo;
    private Document doc;
    private NodeList casillas;
    
    private FParser() {
        
        archivo = new File ("src" + File.separator + "recursos" + File.separator + "3ralla.xml");
        
        try ( FileInputStream fis = new FileInputStream(archivo);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = fabrica.newDocumentBuilder();
            doc = dB.parse(new InputSource(isr));
            
            Element raiz = doc.getDocumentElement();
            
            casillas = doc.getDocumentElement().getChildNodes();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static FParser getInstance() {
        
        if (gestorArchivo == null)
            gestorArchivo = new FParser();
        
        return gestorArchivo;
        
    }
    
    public int getValor (int casilla) {
        
        return Integer.parseInt(casillas.item(casilla).getTextContent());
        
    }
    
    public int[] getCasillas () {
        
        int nCasillas = casillas.getLength() -1;
        
        int[] arrayCasillas = new int[nCasillas];
        
        for (int i = 0; i < nCasillas; i++)
            arrayCasillas[i] = getValor(i);
        
        return arrayCasillas;
        
    }
    
    public void setValor (int casilla, int valor) {
        
        casillas.item(casilla).setTextContent(String.valueOf(valor));
        
        guardar();
        
    }
    
    public int getTurno () {
        
        return Integer.parseInt(casillas.item(9).getTextContent());
        
    }
    
    public void clear() {
        
        for (int i = 0; i < 10; i++)
            setValor(i, 0);
        
        guardar();
        
    }
    
    private void guardar() {
        
        try {
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(archivo));
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
