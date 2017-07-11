
package models;

import java.io.Serializable;

public class Items implements Serializable{

    
private int id;
    private String model;
    private int quantity;

    
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
}


