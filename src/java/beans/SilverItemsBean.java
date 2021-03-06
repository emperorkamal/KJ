/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import daos.SilverItemsDao;
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
 * @author Kamal Jabari
 */
@Named(value = "silverItemsBean")
@ViewScoped
public class SilverItemsBean implements Serializable{

    private int id ;
    private String model;
    private int quantity;
    private float weight;
    private String cirat;
    private String color;
    private int cost;
     private String trader;

    @Inject
    private beans.SessionBean sessionBean;
     
    private Items selectedItem;
    private final SilverItemsDao itemdao = new SilverItemsDao();
    private ArrayList<Items> list;

    
    public SilverItemsBean() {
    }
    
        @PostConstruct
    public void init() {
        try {
            list = itemdao.buildItem();
        } catch (Exception ex) {
            Logger.getLogger(SilverItemsBean.class.getName()).log(Level.SEVERE, null, ex);
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
    
        public Items getSelectedItem() {//selected model 
        return selectedItem;
    }

    public void setSelectedItem(Items selectedItem) {
        this.selectedItem = selectedItem;
    }
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedItem.getId());
    }
        public ArrayList<Items> getItem() {
        return list;
    }
            public ArrayList<Items> getList() {
        return list;
    }

    public void setList(ArrayList<Items> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }

    public void deleteSelectedItem() {
        try {
            itemdao.deleteItem(selectedItem.getId());
            sessionBean.navigate("/silver_sector.xhtml");
        } catch (Exception ex) {
            //sar t3deel hon bel information bean kant bus w 5aletha driver
            Logger.getLogger(SilverItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }}


}
