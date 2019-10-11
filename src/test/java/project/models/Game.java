package project.models;

import a1qa.selenium.forms.PageInfo;

@PageInfo(xpath = "//span[@id]/a/img", pageName = "Main page")
public class Game implements Comparable<Game> {

    private final String Name;
    private final int Discount;
    private final String Price;

    public Game(String name, int discount, String price) {
        Name = name;
        Discount = discount;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public int getDiscount() {
        return Discount;
    }

    public String getPrice() {
        return Price;
    }

    @Override
    public int compareTo(Game o) {
        return this.getDiscount() - o.getDiscount();
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + " , Discount: " + this.Discount + ", Price: " + this.Price;
    }
}
