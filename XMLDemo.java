package com.louis.xml;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.naming.ldap.PagedResultsControl;
import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLDemo {
    /**
     * DOM解析XML
     * 1.基于树形结构,通过解析器一次性把文档加载到内存中,所以会比较占用内存,可以随机访问
     * 更加灵活,更适合在WEB开发中使用
     */
    @Test
    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
        //1.创建一个DOM解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.通过工厂对象创建解析器对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //3.解析文档
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/louis/xml/test.xml");
        //此代码完成后,整个XML文档已经被加载到内存中,以树状存储
        Document doc = documentBuilder.parse(is);
        //4.从内存中读取数据
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        //次循环会迭代两次
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            p = new Person();
            //获取节点的属性值
            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            //获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                } else if ("address".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if ("tel".equals(nodeName)) {
                    p.setTel(item.getFirstChild().getNodeValue());
                } else if ("fax".equals(nodeName)) {
                    p.setFax(item.getFirstChild().getNodeValue());
                } else if ("email".equals(nodeName)) {
                    p.setEmail(item.getFirstChild().getNodeValue());
                }
            }
            persons.add(p);
        }
        System.out.println("结果: ");
        System.out.println(Arrays.toString(persons.toArray()));

    }

    /**
     * SAX解析的特点:
     * 1,基于事件驱动
     * 2.顺序读取,速度快
     * 3.不能任意读取节点(灵活性差)
     */
    public static class XMLDwmo {
        @Test
        public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
            //1.创建一个SAX解析器工厂对象
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            //2.通过工厂对象创建SAX对象
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //3.创建一个数据处理器（需要我们自己来编写）
            PersonHandler personHandler = new PersonHandler();
            //4.开始解析
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/louis/xml/test.xml");
            saxParser.parse(is, personHandler);
            List<Person> persons = personHandler.getPersons();
            for (Person p : persons) {
                System.out.println(p);
            }
        }
    }
}