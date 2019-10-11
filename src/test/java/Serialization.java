import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

import static models.DataOrder.createOrderObject;

public class Serialization {


    public static void main(String[] args) throws IOException, JAXBException {

        convertToJson();
        convertToXml();
    }

    public static void convertToJson() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Order order = createOrderObject();

        String jsonOrder = gson.toJson(order);
        System.out.println(jsonOrder);
    }

    public static void convertToXml() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(Order.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        Order order = createOrderObject();
        marshaller.marshal(order, stringWriter);
        stringWriter.close();
        System.out.println(stringWriter);
    }
}
