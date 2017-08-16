

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author OthmanKurdi
 */
public class Receipt implements Serializable{

    private int receipt_id;
    private int customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_address;
    private int id;
    private String model;
    private float weight;
    private float cirat;
    private String color;
    private float cost;
    private int sold_quantity;
    private String trader;
    private float price_without_cost;
    private float price_with_cost;
    private float total_price;
    private float profit;
    private float pieces_price_without_cost;
    private float pieces_price_with_cost;
    private float pieces_total_price;

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
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

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
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