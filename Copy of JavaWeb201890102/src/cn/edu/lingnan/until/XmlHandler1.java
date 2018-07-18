package cn.edu.lingnan.until;

import java.util.HashMap;
import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler1 extends DefaultHandler{

	private StringBuffer sb = new StringBuffer();
	private HashMap<String,String> hm = new HashMap<String,String>();
	
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        // 清空一个可变字符串
    	sb.delete(0, sb.length());
    }

  
    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
        // 将可变字符串的内容存入某个介质中
    	hm.put(qName.toLowerCase(), sb.toString().trim());
    }

    
   
    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        //把读到的ch字符数组中的内容存入可变字符串
    	sb.append(ch,start,length);
    }

    public HashMap<String,String> getHashMap()
    {
    	return hm;
    }
    

}
