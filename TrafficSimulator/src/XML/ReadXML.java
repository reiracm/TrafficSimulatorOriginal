package XML;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ReadXML{
    
public void cargarXml()
{
    //Se crea un SAXBuilder para poder parsear el archivo
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File( "archivo.xml" );
    try
    {
        //Se crea el documento a traves del archivo
        Document document = (Document) builder.build( xmlFile );
 
        //Se obtiene la raiz 'tables'
        Element rootNode = document.getRootElement();
 
        //Se obtiene la lista de hijos de la raiz 'tables'
        List list = rootNode.getChildren( "Calle" );
 
        //Se recorre la lista de hijos de 'tables'
        for ( int i = 0; i < list.size(); i++ )
        {
            //Se obtiene el elemento 'tabla'
            Element tabla = (Element) list.get(i);
 
            //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
            String nombreTabla = tabla.getAttributeValue("nombre");
 
            System.out.println( "Calle: " + nombreTabla );
 
            //Se obtiene la lista de hijos del tag 'tabla'
            List lista_campos = tabla.getChildren();
 
            System.out.println( "\tPosIniX\t\tPosIniY\t\tPosFinX\t\tPosFinY" );
 
            //Se recorre la lista de campos
            for ( int j = 0; j < lista_campos.size(); j++ )
            {
                //Se obtiene el elemento 'campo'
                Element campo = (Element)lista_campos.get( j );
         
                //Se obtienen los valores que estan entre los tags '<campo></campo>'
                //Se obtiene el valor que esta entre los tags '<nombre></nombre>'
                String PosXI = campo.getChildTextTrim("PosXIni");
                int IniX = Integer.parseInt(PosXI);
 
                //Se obtiene el valor que esta entre los tags '<tipo></tipo>'
                String PosYI = campo.getChildTextTrim("PosYIni");
                int IniY = Integer.parseInt(PosYI);
 
                //Se obtiene el valor que esta entre los tags '<valor></valor>'
                String PosXF = campo.getChildTextTrim("PosXFin");
                int FinX = Integer.parseInt(PosXF);
                
                //Se obtiene el valor que esta entre los tags '<valor></valor>'
                String PosYF = campo.getChildTextTrim("PosYFin");
                int FinY = Integer.parseInt(PosYF);
 
                System.out.println( "\t"+IniX+"\t\t"+IniY+"\t\t"+FinX+"\t\t"+FinY);
            }
        }
    }catch ( IOException io ) {
        System.out.println( io.getMessage() );
    }catch ( JDOMException jdomex ) {
        System.out.println( jdomex.getMessage() );
    }
}

    public static void main(String [] args){
        ReadXML rx = new ReadXML();
        rx.cargarXml();
    }
}
