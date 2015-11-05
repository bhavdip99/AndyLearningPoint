package com.bhavdip.learningpoint;


public class Product {
    public int id;
    public String date;
    public int total;
    
    public Product(){
        super();
    }
    
    public Product(int id, String date, int total) {
        super();
        this.id = id;
        this.date = date;
        this.total = total;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.date + " [$" + this.total + "]";
    }
}