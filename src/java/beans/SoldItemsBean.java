/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.ItemsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Items;
import models.SoldItems;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "soldItemsBean")
@ViewScoped
public class SoldItemsBean implements Serializable{

    /**
     * Creates a new instance of SoldItemsBean
     */
    private int id;
    private String model;
    private float weight;
    private String cirat;
    private String color;
    private int cost;
    private String trader;
    private float price_without_cost;
     private float price_with_cost;
     private float total_price;
     private float profit;

    
    @Inject
    private beans.SessionBean sessionBean;

    private SoldItems soldSelectedItem;
    private final ItemsDao itemdao = new ItemsDao();
    private ArrayList<SoldItems> list;

    public SoldItemsBean() {
    }

    @PostConstruct
    public void init() {
        try {
            list = itemdao.buildSoldItem();
        } catch (Exception ex) {
            Logger.getLogger(SoldItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the cirat
     */
    public String getCirat() {
        return cirat;
    }

    /**
     * @param cirat the cirat to set
     */
    public void setCirat(String cirat) {
        this.cirat = cirat;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    public void back(){
        sessionBean.navigate("gold_sector.xhtml");
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
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

   
    
    

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(soldSelectedItem.getId());
    }

   
    public ArrayList<SoldItems> getList() {
        return list;
    }

    public void setList(ArrayList<SoldItems> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }

    public SoldItems getSoldSelectedItem() {
        return soldSelectedItem;
    }

    public void setSoldSelectedItem(SoldItems soldSelectedItem) {
        this.soldSelectedItem = soldSelectedItem;
    }

    public void deleteSelectedItem() {
        try {
            itemdao.deleteSoldItem(soldSelectedItem.getId());
            sessionBean.navigate("/view_sold_items.xhtml");
        } catch (Exception ex) {
            //sar t3deel hon bel information bean kant bus w 5aletha driver
            Logger.getLogger(SoldItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
