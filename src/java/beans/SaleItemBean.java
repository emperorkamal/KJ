/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import daos.ItemDetailsDao;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import daos.ItemsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.SessionBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.Items;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "saleItemBean")
@Dependent
public class SaleItemBean {
private int id ;
    private String model;
    private int quantity;
    private float weight;
    private float cirat;
    private String color;
    private float cost;
     private String trader;
     private float price_without_cost;
     private float price_with_cost;
     private float total_price;
     private float profit;

    

    

    
     Items item=new Items();
    private Items selectedItem;
    private final ItemDetailsDao itemdao = new ItemDetailsDao();
    //public Items item=new Items();
    /**
     * Creates a new instance of ItemDetailsBean
     */
    public SaleItemBean() {
    }
    
    @Inject
    private beans.SessionBean sessionBean;
    
        @PostConstruct
    public void init() {
        
        int item_id=sessionBean.getSelectedItemId();
        try {
            if(item_id>0){
            item = itemdao.buildItem(item_id);
            id=item.getId();
            model=item.getModel();
            quantity=item.getQuantity();
            weight=item.getWeight();
            cirat=item.getCirat();
            color=item.getColor();
            cost=item.getCost();
            trader=item.getTrader();
            
            price_without_cost=(float) ((weight*1228.0*32.15*0.71*cirat)/1000.0);
            price_with_cost=(float) ((weight*1228.0*32.15*0.71*cirat)/1000.0)+cost;
            total_price=(float) ((weight*1228.0*32.15*0.71*cirat)/1000.0)+cost+cost;
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void  updatePrice (){
    total_price=(float) ((weight*1228.0*32.15*0.71*cirat)/1000.0)+cost+profit;
        System.out.println(total_price);
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public float getCirat() {
        return cirat;
    }

    /**
     * @param cirat the cirat to set
     */
    public void setCirat(float cirat) {
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
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(float cost) {
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
    
        public Items getSelectedItem() {//selected model 
        return selectedItem;
    }

    public void setSelectedItem(Items selectedItem) {
        this.selectedItem = selectedItem;
    }
    
     

   

}
