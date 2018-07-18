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
        // ���һ���ɱ��ַ���
    	sb.delete(0, sb.length());
    }

  
    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
        // ���ɱ��ַ��������ݴ���ĳ��������
    	hm.put(qName.toLowerCase(), sb.toString().trim());
    }

    
   
    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        //�Ѷ�����ch�ַ������е����ݴ���ɱ��ַ���
    	sb.append(ch,start,length);
    }

    public HashMap<String,String> getHashMap()
    {
    	return hm;
    }
    

}
