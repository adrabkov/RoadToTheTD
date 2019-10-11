import models.Order;
import utils.JsonToOdjects;
import utils.XmlToObjects;

public class Deserialization {

    private static final String FILE_PATH_JSON = "src/test/resources/order.json";
    private static final String FILE_PATH_XML = "src/test/resources/order.xml";

    public static void main(String[] args) {

        convertFromJson();
        convertFromXml();
    }

    public static void convertFromJson() {

        Order order = JsonToOdjects.mapToObject(FILE_PATH_JSON, Order.class);
        System.out.println(order.toString());
    }

    public static void convertFromXml() {

        Order order = XmlToObjects.mapToObject(FILE_PATH_XML, Order.class);
        System.out.println(order.toString());
    }
}
