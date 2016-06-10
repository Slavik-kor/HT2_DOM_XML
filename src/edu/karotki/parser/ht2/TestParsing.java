package edu.karotki.parser.ht2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class TestParsing {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = Factory.newDocumentBuilder();
			Document doc = Builder.parse(new File("menu.xml"));
			doc.getDocumentElement().normalize();

			System.out.println("Меню ресторана Жемчужинка");
			System.out.println("-------------------------");

			NodeList mList = doc.getElementsByTagName("header").item(0).getChildNodes();
			NodeList cList = doc.getElementsByTagName("category");
			NodeList iList;
			for (int l = 0; l < cList.getLength(); l++) {
				NamedNodeMap attribute=cList.item(l).getAttributes();
				System.out.println(attribute.item(1).getNodeValue());
				System.out.println("-------------------------");
				for (int i = 0; i < mList.getLength(); i++) {
					System.out.println(mList.item(i).getTextContent().trim() + "  ");
				}
				System.out.println();
				System.out.println("-------------------------");
				iList = cList.item(l).getChildNodes();
				for (int i = 0; i < iList.getLength(); i++) {
					Node node1=iList.item(i);
					for (int j = 0; j < node1.getChildNodes().getLength(); j++) {
						Node node2=node1.getChildNodes().item(j);
						for (int k = 0; k < node2.getChildNodes().getLength(); k++) {
							Node node3=node2.getChildNodes().item(k);
							System.out.println(node3.getTextContent().trim() + "   ");
						}
					}
					System.out.println("***************************");
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
