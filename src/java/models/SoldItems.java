package models;

import java.io.Serializable;

public class SoldItems implements Serializable {

    private int sold_id;
    private int id;
    private String model;
    private float weight;
    private float cirat;
    private String color;
    private float cost;
    private int sold_quantity;
    private String trader;
    public float profit;
    private float price_without_cost;
    private float price_with_cost;
    private float total_price;
    private float pieces_price_without_cost;
    private float pieces_price_with_cost;
    private float pieces_total_price;
    
    /**
     * @return the id
     */
    
    
    public int getSold_id() {
        return sold_id;
    }

    public void setSold_id(int sold_id) {
        this.sold_id = sold_id;
    }
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCirat() {
        return cirat;
    }

    public void setCirat(float cirat) {
        this.cirat = cirat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public int getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getPrice_without_cost() {
        return price_without_cost;
    }

    public void setPrice_without_cost(float price_without_cost) {
        this.price_without_cost = price_without_cost;
    }

    public float getPrice_with_cost() {
        return price_with_cost;
    }

    public void setPrice_with_cost(float price_with_cost) {
        this.price_with_cost = price_with_cost;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }
    
    
    public float getPieces_price_without_cost() {
        return pieces_price_without_cost;
    }

    public void setPieces_price_without_cost(float pieces_price_without_cost) {
        this.pieces_price_without_cost = pieces_price_without_cost;
    }

    public float getPieces_price_with_cost() {
        return pieces_price_with_cost;
    }

    public void setPieces_price_with_cost(float pieces_price_with_cost) {
        this.pieces_price_with_cost = pieces_price_with_cost;
    }

    public float getPieces_total_price() {
        return pieces_total_price;
    }

    public void setPieces_total_price(float pieces_total_price) {
        this.pieces_total_price = pieces_total_price;
    }

}
