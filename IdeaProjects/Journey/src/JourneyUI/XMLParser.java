package JourneyUI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;

import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;


public class XMLParser {

	public static void main(String[] args) {
		try {
            File file = new File("bro.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("cities.xml"));
			Node root = doc.getElementsByTagName("routes").item(0);
			NodeList cardlist = root.getChildNodes();
			for (int i = 0; i < cardlist.getLength(); i++) {
				Node cardNode = cardlist.item(i);
				if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
					NodeList cardAttrs = cardNode.getChildNodes();
					// one card
					for (int j = 0; j < cardAttrs.getLength(); j++) {
						if (cardAttrs.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Node theNode = cardAttrs.item(j);
                            String s = theNode.getNodeName();
                            if (s.equals("name")) {
                                System.out.println("City name: "
                                        + theNode.getTextContent());

                            } else if (s.equals("land")) {
                                NodeList landList = theNode.getChildNodes();
                                for (int k = 0; k < landList.getLength(); k++) {
                                    if (landList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                        System.out.println("Land neighbour: "
                                                + landList.item(k)
                                                .getTextContent());
                                    }
                                }

                            } else if (s.equals("sea")) {
                                NodeList seaList = theNode.getChildNodes();
                                for (int k = 0; k < seaList.getLength(); k++) {
                                    if (seaList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                        System.out.println("Sea neighbour: "
                                                + seaList.item(k)
                                                .getTextContent());
                                    }
                                }

                            }
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
