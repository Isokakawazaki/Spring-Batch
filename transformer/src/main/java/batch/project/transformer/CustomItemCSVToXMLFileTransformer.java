package batch.project.transformer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class CustomItemCSVToXMLFileTransformer {

	public void csvToXmlFileTransformer(String csvFilePath)
			throws UnexpectedInputException, ParseException, Exception, IOException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

		Document newDoc = domBuilder.newDocument();

		// Root element
		Element rootElement = newDoc.createElement("Sites");
		newDoc.appendChild(rootElement);

		File csvFile = new File(csvFilePath);
		BufferedReader reader = new BufferedReader(new FileReader(csvFile));
		LineNumberReader lineNumberReader = new LineNumberReader(reader) ;
		
		while ((reader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(reader.readLine(), ", ", false);
			List<String> nodesName = new ArrayList<>();
			List<String> nodesAttribute = new ArrayList<>();
			int counter = 0;
			if (counter == 0) {
				String strToken;
				while (st.hasMoreTokens()) {
					strToken = st.nextToken().toString();
					
					nodesName.add(strToken.substring(strToken.indexOf("_") + 1));
					nodesAttribute.add(strToken.substring(0, st.nextToken().toString().indexOf("_")));
				}
				counter++;
			}
			
			if (nodesName != null && nodesAttribute != null) {
				int i = 0;
				String initialNodeName = null;
				Element node = null;
				//use for ?
				for(String nodeName : nodesName) {
					if (!initialNodeName.equals(nodeName)){
						node = newDoc.createElement(nodeName);
						initialNodeName = nodeName;
					}
					else {
						node.setAttribute(nodesAttribute.get(i), setAttributeValue(lineNumberReader, i));
						i++;
					}
				}
			}
		}
	}

	private String setAttributeValue(LineNumberReader reader, int i) throws IOException {
		List<String> attributesAndValues = new ArrayList<>();
		if (reader.getLineNumber()>=1) {
			attributesAndValues.add(new StringTokenizer(reader.readLine(), ", ", false).nextToken());
		}
		return attributesAndValues.get(i);
	}
}