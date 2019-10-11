package models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Content {

    private int productID;
    private String productName;
    private int quantity;


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("productID", productID).append("productName", productName).append("quantity", quantity).toString();
    }

}
