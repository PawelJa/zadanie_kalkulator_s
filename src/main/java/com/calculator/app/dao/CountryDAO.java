package com.calculator.app.dao;

import com.calculator.app.entity.Country;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDAO {

    final private String dataSource = "src/main/resources/data/data.xml";
    public File dataFile = new File(dataSource);

    private List<Country> list;

    public CountryDAO() {
        this.list = createList();
    }

    public List<Country> createList() {
        List<Country> list = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(dataFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("country");
            System.out.println("Root: " + doc.getDocumentElement().getNodeName());
            System.out.println("*********");
            System.out.println(nList.getLength());
            for (int i=0; i<nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Country country = new Country();
                    country.setId(eElement.getAttribute("id"));
                    country.setFullName(eElement.getElementsByTagName("fullName").item(0).getTextContent());
                    country.setOncost(Integer.valueOf(eElement.getElementsByTagName("oncost").item(0).getTextContent()));
                    country.setTaxPercent(Double.valueOf(eElement.getElementsByTagName("taxPercent").item(0).getTextContent()));
                    country.setCurrency(eElement.getElementsByTagName("currency").item(0).getTextContent());
                    list.add(country);
                    System.out.println(country);
                }

            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Country> getList() {
        return this.list;
    }
}
