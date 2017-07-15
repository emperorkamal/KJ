package beans;

import daos.ItemDetailsDao;
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
public class AddEditItemsBean implements Serializable {

    private final ItemsDao ItemsDao = new ItemsDao();
    private int id;
    private int quantity;
    private String model;
    private float weight;
    private float cirat;
    private String color;
    private float cost;
    private String trader;

    int item_id;
    Items item = new Items();
    private final ItemDetailsDao itemDetailsDao = new ItemDetailsDao();

    @Inject
    private beans.SessionBean sessionBean;

    public AddEditItemsBean() {
    }

    @PostConstruct
    public void init() {
       int item_id=sessionBean.getSelectedItemId();
        try {
            if(item_id>0){
            item = itemDetailsDao.buildItem(item_id);
            id=item.getId();
            model=item.getModel();
            quantity=item.getQuantity();
            weight=item.getWeight();
            cirat=item.getCirat();
            color=item.getColor();
            cost=item.getCost();
            trader=item.getTrader();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return this.model;
    }

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

    public void saveItems() {
        try {
            int item_id=sessionBean.getSelectedItemId();
            Items item = new Items();

            item.setModel(model);
            item.setQuantity(quantity);
            item.setWeight(weight);
            item.setCirat(cirat);
            item.setColor(color);
            item.setCost(cost);
            item.setTrader(trader);

            if (item_id > 0) {
                ItemsDao.updateItem(item, item_id);
            } else {
                ItemsDao.insertItem(item);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
