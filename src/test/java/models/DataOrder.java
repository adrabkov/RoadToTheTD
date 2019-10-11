package models;



import java.util.ArrayList;
import java.util.List;

public class DataOrder {

    public static Order createOrderObject() {

        Order order = new Order();
        CommonFunctions commonFunctions= new CommonFunctions();

        order.setOrderID(commonFunctions.getOrderID());
        order.setShoperName(commonFunctions.getShoperName());
        order.setShoperEmail(commonFunctions.getShoperEmail());

        List<Content> contents = new ArrayList<>();

        Content content = new Content();
        content.setProductID(commonFunctions.getProductID());
        content.setProductName(commonFunctions.getProductName());
        content.setQuantity(commonFunctions.getQuantity());
        contents.add(content);

        content = new Content();
        content.setProductID(commonFunctions.getProductID());
        content.setProductName(commonFunctions.getProductName());
        content.setQuantity(commonFunctions.getQuantity());
        contents.add(content);

        order.setContents(contents);

        order.setOrderCompleted(true);
        return order;
    }
}
