
package models;

import java.io.Serializable;

public class Items implements Serializable{

    
private int id;
    private String model;
    private int quantity;
    private int weight;
    private String cirat;
    private String color;
    private int cost;

    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String getCirat() {
        return cirat;
    }


    public void setCirat(String cirat) {
        this.cirat = cirat;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getCost() {
        return cost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }
}


