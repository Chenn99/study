package com.louis.xml;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.naming.ldap.PagedResultsControl;
import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class XMLDemo {
    /**
     * 使用第三方xstream组件实现XML的解析与生成
     */
    @Test
    public void xStream(){
        Person p = new Person();
        p.setPersonid("1212");
        p.setAddress("北京");
        p.setEmail("louis@163.com");
        p.setTel("32478256");
        p.setName("louis");

        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("person",Person.class);
        xStream.useAttributeFor(Person.class,"personid");
        String xml = xStream.toXML(p);
        System.out.println(xml);

        //解析XML
        Person person = (Person)xStream.fromXML(xml);
        System.out.println(person);
    }

    /**
     * 从XML文件中读取对象
     */
    @Test
    public void xmlDeCoder() throws FileNotFoundException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.xml"));
        XMLDecoder decoder = new XMLDecoder(in);
        Person p  = (Person)decoder.readObject();
        System.out.println(p);
    }

    /**
     * 把对象转成xml文件写入
     */
    @Test
    public void xmlEnCoder() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person p = new Person();
        p.setPersonid("1212");
        p.setAddress("北京");
        p.setEmail("louis@163.com");
        p.setTel("32478256");
        p.setName("louis");
        xmlEncoder.writeObject(p);
        xmlEncoder.close();
    }

    /**
     * DOM4j解析XML
     * 基于树型结构,第三方组件
     * 解析速度快,效率更高,使用的JAvA中的迭代器实现数据读取,在WEB框架中使用较多(Hibernate)
     */
    @Test
    public void dom4jParseXML() throws DocumentException {
        //1 创建DOM4J的解析器对象
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/louis/xml/test.xml");
        org.dom4j.Document doc = reader.read(is);
        org.dom4j.Element rootElement = doc.getRootElement();
        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        while(iterator.hasNext()){
            p = new Person();
            org.dom4j.Element e = iterator.next();
            p.setPersonid(e.attributeValue("personid"));
            Iterator<org.dom4j.Element> iterator1 = e.elementIterator();
            while (iterator1.hasNext()){
                org.dom4j.Element next = iterator1.next();
                String tag = next.getName();
                if ("name".equals(tag)) {
                    p.setName(next.getText());
                } else if ("address".equals(tag)) {
                    p.setAddress(next.getText());
                } else if ("tel".equals(tag)) {
                    p.setTel(next.getText());
                } else if ("fax".equals(tag)) {
                    p.setFax(next.getText());
                }else if ("email".equals(tag)) {
                    p.setEmail(next.getText());
                }
            }
            persons.add(p);
        }
        System.out.println("结果: ");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    /**
     * JDOM解析XML
     * 1.与DOM类似基于树型结构,
     * 2.与DOM的区别:
     * (1)第三方开源的组件
     * (2)实现使用JAVA的Collection接口
     * (3)效率比DOM更快
     *
     */
    @Test
    public void jdomParseXML() throws IOException, JDOMException {
        // 创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/louis/xml/test.xml");
        org.jdom2.Document build = builder.build(is);
        Element rootElement = build.getRootElement();
        List<Person> list = new ArrayList<>();
        Person person = null;
        List<Element> children = rootElement.getChildren();
        for (Element element : children) {
            person = new Person();
            String personid = element.getAttributeValue("personid");
            person.setPersonid(personid);
            List<Element> children1 = element.getChildren();
            for (Element e : children1) {
                String tag = e.getName();
                if ("name".equals(tag)) {
                    person.setName(e.getText());
                } else if ("address".equals(tag)) {
                    person.setAddress(e.getText());
                } else if ("tel".equals(tag)) {
                    person.setTel(e.getText());
                } else if ("fax".equals(tag)) {
                    person.setFax(e.getText());
                }else if ("email".equals(tag)) {
                    person.setEmail(e.getText());
                }
            }
            list.add(person);
        }
        System.out.println("结果: ");
        System.out.println(Arrays.toString(list.toArray()));
    }
    /**
     * DOM解析XML
     * 1.基于树形结构,通过解析器一次性把文档加载到内存中,所以会比较占用内存,可以随机访问
     * 更加灵活,更适合在WEB开发中使用
     */
//    @Test
//    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
//        //1.创建一个DOM解析器工厂对象
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        //2.通过工厂对象创建解析器对象
//        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//        //3.解析文档
//        InputStream is = Thread.currentThread().getContextClassLoader()
//                .getResourceAsStream("com/louis/xml/test.xml");
//        //此代码完成后,整个XML文档已经被加载到内存中,以树状存储
//        Document doc = documentBuilder.parse(is);
//        //4.从内存中读取数据
//        NodeList personNodeList = doc.getElementsByTagName("person");
//        ArrayList<Person> persons = new ArrayList<>();
//        Person p = null;
//        //次循环会迭代两次
//        for (int i = 0; i < personNodeList.getLength(); i++) {
//            Node personNode = personNodeList.item(i);
//            p = new Person();
//            //获取节点的属性值
//            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
//            p.setPersonid(personid);
//            //获取当前节点的所有子节点
//            NodeList childNodes = personNode.getChildNodes();
//            for (int j = 0; j < childNodes.getLength(); j++) {
//                Node item = childNodes.item(j);
//                String nodeName = item.getNodeName();
//                if ("name".equals(nodeName)) {
//                    p.setName(item.getFirstChild().getNodeValue());
//                } else if ("address".equals(nodeName)) {
//                    p.setAddress(item.getFirstChild().getNodeValue());
//                } else if ("tel".equals(nodeName)) {
//                    p.setTel(item.getFirstChild().getNodeValue());
//                } else if ("fax".equals(nodeName)) {
//                    p.setFax(item.getFirstChild().getNodeValue());
//                } else if ("email".equals(nodeName)) {
//                    p.setEmail(item.getFirstChild().getNodeValue());
//                }
//            }
//            persons.add(p);
//        }
//        System.out.println("结果: ");
//        System.out.println(Arrays.toString(persons.toArray()));
//
//    }

    /**
     * SAX解析的特点:
     * 1,基于事件驱动
     * 2.顺序读取,速度快
     * 3.不能任意读取节点(灵活性差)
     */
//    public static class XMLDwmo {
//        @Test
//        public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
//            //1.创建一个SAX解析器工厂对象
//            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//            //2.通过工厂对象创建SAX对象
//            SAXParser saxParser = saxParserFactory.newSAXParser();
//            //3.创建一个数据处理器（需要我们自己来编写）
//            PersonHandler personHandler = new PersonHandler();
//            //4.开始解析
//            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/louis/xml/test.xml");
//            saxParser.parse(is, personHandler);
//            List<Person> persons = personHandler.getPersons();
//            for (Person p : persons) {
//                System.out.println(p);
//            }
//        }
//    }
}