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
        long customer_number;
        float amount;
        int duration;
        String deposit_type;
        System.out.println("DOTIN TASK1!!!");
        try {
            File inputFile = new File("C:/Users/ghazalak/Desktop/xml.txt"); //در مورد آدرس دهی رلتیو و ابسولوت بخون :)
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("deposit");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    customer_number = Long.valueOf(eElement
                            .getElementsByTagName("customerNumber")
                            .item(0)
                            .getTextContent());
                    deposit_type = String.valueOf(eElement
                            .getElementsByTagName("depositType")
                            .item(0)
                            .getTextContent());
                    amount = Float.valueOf(eElement
                            .getElementsByTagName("depositBalance")
                            .item(0)
                            .getTextContent());
                    duration = Integer.valueOf(eElement
                            .getElementsByTagName("durationInDays")
                            .item(0)
                            .getTextContent());
                    //System.out.println(customer_number + " " + amount + " " + duration);
                    Deposit dp = new Deposit(); // همه اسمایی که میذاری حتی اگه متغیر موقتن، باید معنی دار باشن. اسم این متغیر دیپازیته مثلا نه دی پی
                    dp.amount = amount;
                    dp.duration = duration;
                    dp.customer_number = customer_number;
                    dp.deposit_type = deposit_type;
                    dp.calculate(); // اسامی توابعت باید کاملا گویای کاری که میکنن باشن. کلکیولیت چی؟ مثلا کلکیولیت دیپازیت اینترست
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
