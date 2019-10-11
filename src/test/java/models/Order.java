package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "orderID")
    private int orderID;

    @XmlElement(name = "shoperName")
    private String shoperName;

    @XmlElement(name = "shoperEmail")
    private String shoperEmail;

    @XmlElement(name = "contents")
    private List<Content> contents = new ArrayList();

    @XmlElement(name = "orderCompleted")
    private boolean orderCompleted;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShoperName() {
        return shoperName;
    }

    public void setShoperName(String shoperName) {
        this.shoperName = shoperName;
    }

    public String getShoperEmail() {
        return shoperEmail;
    }

    public void setShoperEmail(String shoperEmail) {
        this.shoperEmail = shoperEmail;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    @Override
    public String toString() {
        return "[shoperName = " + shoperName + ", orderCompleted = " + orderCompleted + ", orderID = " + orderID + ", contents = " + contents + ", shoperEmail = " + shoperEmail + "]";
    }
}
