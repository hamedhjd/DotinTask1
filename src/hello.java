//package com.tutorialspoint.xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class hello {
    public static void main(String[] args) {
        System.out.println("Hello, World !!!");
        try {
            File inputFile = new File("C:/Users/ghazalak/Desktop/xml.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("deposit");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("deposit roll no : "
                            + eElement.getAttribute("rollno"));
                    System.out.println("customerNumber: "
                            + eElement
                            .getElementsByTagName("customerNumber")
                            .item(0)
                            .getTextContent());
                    System.out.println("depositType: "
                            + eElement
                            .getElementsByTagName("depositType")
                            .item(0)
                            .getTextContent());
                    System.out.println("depositBalance: "
                            + eElement
                            .getElementsByTagName("depositBalance")
                            .item(0)
                            .getTextContent());
                    System.out.println("durationInDays: "
                            + eElement
                            .getElementsByTagName("durationInDays")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
