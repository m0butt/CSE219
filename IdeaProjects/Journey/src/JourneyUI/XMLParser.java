package JourneyUI;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import java.io.File;
import java.io.IOException;

/**
 * Created by omar on 11/22/14.
 */
public class XMLParser {
    public void action(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("cities.xml"));
            org.w3c.dom.Node root = doc.getElementsByTagName("routes").item(0);
            NodeList cardlist = root.getChildNodes();
            for (int i = 0; i < cardlist.getLength(); i++) {
                org.w3c.dom.Node cardNode = cardlist.item(i);
                if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList cardAttrs = cardNode.getChildNodes();
                    // one card
                    for (int j = 0; j < cardAttrs.getLength(); j++) {
                        if (cardAttrs.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            org.w3c.dom.Node theNode = cardAttrs.item(j);
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
