package com.louis.xml;

import org.xml.sax.SAXException;

import javax.naming.ldap.PagedResultsControl;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class XMLDwmo {

    public void saxParseXML() throws ParserConfigurationException, SAXException {
        //1.创建一个SAX解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2.通过工厂对象创建SAX对象
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3.创建一个数据处理器（需要我们自己来编写）
        PersonHandler personHandler = new PersonHandler();
        //4.开始解析
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/louis/xml/test.xml");
        try {
            saxParser.parse(is,personHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
