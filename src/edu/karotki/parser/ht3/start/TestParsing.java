package edu.karotki.parser.ht3.start;

import java.io.File;

import edu.karotki.parser.ht3.entity.Node;
import edu.karotki.parser.ht3.service.DomParserSlv;

public class TestParsing {

	public static void main(String[] args) {
		DomParserSlv parser = new DomParserSlv();
		Node doc = parser.parse(new File("menu.xml"));
		System.out.println(doc.getTag());
		for (int i = 0; i < doc.getChildNodes().size(); i++) {
			Node node1 = doc.getChildNodes().get(i);
			System.out.println(node1.getTag());
			if (node1.isNode()) {
				for (int j = 0; j < node1.getChildNodes().size(); j++) {
					Node node2 = node1.getChildNodes().get(j);
					System.out.println(node2.getTag());
					if (node2.isNode()) {
						for (int s = 0; s < node2.getChildNodes().size(); s++) {
							Node node3 = node2.getChildNodes().get(s);
							if (node3.isNode()) {
								for (int k = 0; k < node3.getChildNodes().size(); k++) {
									Node node4 = node3.getChildNodes().get(k);
									System.out.print(node4.getTextContent() + "   ");
									System.out.println("");
								}
							} else {
								System.out.print(node3.getTextContent() + "  ");
								System.out.println("");
							}
						}
					} else {
						System.out.println(node2.getTextContent());
					}
					System.out.println("***********************************************");
				}
			} else {
				System.out.println(node1.getTextContent());
			}

			System.out.println("-------------------------------------------------");
		}

	}

}
