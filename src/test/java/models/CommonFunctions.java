package models;

import org.apache.commons.lang.RandomStringUtils;

public class CommonFunctions {

    private int orderID = randomOrderId();
    private String shoperName = randomName();
    private int quantity = randomQuantity();
    private String productName = randomProductName();
    private String shoperEmail = randomEmail();
    private int productID = randomProductId();

    private static int randomOrderId() {
        return (int) (Math.random() * 100000);
    }

    private static String randomName() {
        String[] name = {"John", "Marcus", "Susan", "Henry", "Dennis", "Panteleimon"};
        int random = (int) (Math.random() * name.length);
        return name[random];
    }

    private static String randomEmail() {
        String randomString = RandomStringUtils.random(5, true, true);
        return randomString + "@gmail.com";
    }

    private static int randomQuantity() {
        return (int) (Math.random() * 100);
    }

    private static String randomProductName() {
        return RandomStringUtils.random(7, true, false);
    }

    private static int randomProductId() {
        return (int) (Math.random() * 1000);
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getShoperEmail() {
        return shoperEmail;
    }

    public int getProductID() {
        return productID;
    }

    public String getShoperName() {
        return shoperName;
    }
}
