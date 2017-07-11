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
        
    public void saveItems() {
        try {
           Items item = new Items();
           
          

           item.setModel(model);
           item.setQuantity(quantity);

            
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
