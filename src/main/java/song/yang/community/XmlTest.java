package song.yang.community;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Auther: song
 * @Date: 2019/8/27 15:32
 * @Description:
 */
public class XmlTest {

    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src\\main\\resources\\1.xml");
            NodeList student = document.getElementsByTagName("student");
            Element item = (Element) student.item(0);
            System.out.println("元素节点名称："+item.getElementsByTagName("name").item(0).getNodeName()+"--文本节点:"+item.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            printAttribute(item.getElementsByTagName("name").item(0));
            System.out.println("元素节点名称："+item.getElementsByTagName("是").item(0).getNodeName()+"--文本节点:"+item.getElementsByTagName("是").item(0).getFirstChild().getNodeValue());
            System.out.println("元素节点名称："+item.getElementsByTagName("age").item(0).getNodeName()+"--文本节点:"+item.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAttribute(Node node){
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            System.out.println(item.getNodeName()+" ----"+item.getNodeValue());
        }
    }
}
