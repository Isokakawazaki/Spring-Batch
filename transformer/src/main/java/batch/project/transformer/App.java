package batch.project.transformer;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnexpectedInputException, ParseException, Exception{
    	
    	CustomItemCSVToXMLFileTransformer csvToxml = new CustomItemCSVToXMLFileTransformer();
    	csvToxml.csvToXmlFileTransformer("/Users/ibenabde/Desktop/SpringBatch_Repo/transformer/src/ressouces/csv/input/input.csv");
    	
    }
}
