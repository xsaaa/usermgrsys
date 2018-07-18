package cn.edu.lingnan.until;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlVaildator1 {
	private static final String SCHEMALANG = "http://www.w3.org/2001/XMLSchema";
	public static boolean validator(String xmlPath,String xsdPath)
	{
		boolean flag = false;
		String basePath = 
	     Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath = basePath + xmlPath;
		xsdPath = basePath + xsdPath;
		
		
		//System.out.println("---  "+basePath);
		try {
			//创建模式工厂
		SchemaFactory sf = SchemaFactory.newInstance(SCHEMALANG);
		File f = new File(xsdPath);
		Schema s = sf.newSchema(f);
		Validator v = s.newValidator();
		Source source = new StreamSource(xmlPath);
		v.validate(source);
		flag = true;
		}
		 catch (SAXException e) {
			System.out.println("the shema validate failed...");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("create exception in IO...");
			e.printStackTrace();	
		}
		return flag;
	}
//
//	public static void main(String[] args) {
//		String xmlPath = "database.conf.xml";
//		String xsdPath = "database.conf.xsd";
//		System.out.println(validator(xmlPath,xsdPath));
//	}

}
