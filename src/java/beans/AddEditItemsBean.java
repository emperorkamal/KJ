package beans;

import daos.ItemsDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Items;


@Named("addEditItemsBean")
@ViewScoped
public class AddEditItemsBean implements Serializable{
    private final ItemsDao ItemsDao = new ItemsDao();
    private int id;
    private int quantity;
    private String model;
    private float weight;
    private String cirat;
    private String color;
    private int cost;
    private String trader;

    

    public AddEditItemsBean() {        
    }
    
    @PostConstruct
    public void init(){                
        try {
            
            if(id > 0){
            Items item = new Items();
           item.getId();
           item.getModel();
           item.getQuantity();
           item.getWeight();
           item.getCirat();
           item.getCost();
           item.getColor();
           item.getTrader();
           
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    
        public int getQuantity(){
        return this.id;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

            public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model=model;
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

    public void saveItems() {
        try {
           Items item = new Items();
           
          

           item.setModel(model);
           item.setQuantity(quantity);
           item.setWeight(weight);
           item.setCirat(cirat);
           item.setColor(color);
           item.setCost(cost);
           item.setTrader(trader);

            
            if (getId() > 0) {
                ItemsDao.updateItem(item);
            } else {
                ItemsDao.insertItem(item);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }


       
    }
}
