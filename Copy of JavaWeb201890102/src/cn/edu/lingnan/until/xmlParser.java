package cn.edu.lingnan.until;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class xmlParser {

	public static  HashMap<String,String> parser(String xmlPath)
	{
	    HashMap<String,String> hm = new HashMap<String,String>();
	    String basePath = 
	   	     Thread.currentThread().getContextClassLoader().getResource("").getPath();
	   		xmlPath = basePath + xmlPath;
		try {
			//ʵ����һ��SAXParserFactory����
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//ͨ��factory���һ��SAXParser���󣬼�SAX������
			SAXParser saxParser = factory.newSAXParser();
			//saxParser�������parser��������XML�ļ�
			File f = new File(xmlPath);//�¼�Դ
			XmlHandler1 xh = new XmlHandler1();//�¼�������
			saxParser.parse(f, xh);
			hm = xh.getHashMap();
//			System.out.println("----  "+hm.get("user"));
//			System.out.println("----  "+hm.get("driver"));
			
		} catch (ParserConfigurationException e) {
	
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return hm;
	}
	
	
//	public static void main(String[] args) {
//		String xmlPath = "database.conf.xml";
//		System.out.println(xmlParser.parser(xmlPath));
//	}

}
