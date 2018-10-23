package BL;

import java.io.Serializable;

public class Entry implements Serializable {

    private int id;
    private String desc;
    private int amount;
    private int place;
    private static final int maximum = 75;

    public Entry(int id, String desc, int place) {
        this.id = id;
        this.desc = desc;
        this.place = place;
        amount = 1;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getAmount() {
        return amount;
    }

    public int getPlace() {
        return place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void incAmount() throws Exception {
        if (amount > maximum){
            System.out.println(amount);
            System.out.println(maximum);
            throw new Exception("Maximum amount reached");
        } else {
            amount += 1;
        }

    }

    public void decAmount() throws Exception {
        if (amount < 0) {
            throw new Exception("You can't have less than zero");

        } else {
            amount -= 1;
        }
    }

}
