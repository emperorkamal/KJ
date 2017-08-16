/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.ItemDetailsDao;
import daos.ItemsDao;
import daos.ReceiptDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import models.Items;
import models.Receipt;
import models.SoldItems;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "receiptBean")
@ViewScoped
public class ReceiptBean implements Serializable {

    private int customer_id;
    private int receipt_id;
    private String customer_name;
    private String customer_phone;
    private String customer_address;

    private int sold_id;
    private int id;
    private int quantity;
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
    private int item_id;

    Items item = new Items();
    Receipt receipt = new Receipt();
    private Items selectedItem;
    private final ItemDetailsDao itemdao = new ItemDetailsDao();
    private final ItemsDao Insertitemdao = new ItemsDao();
    private final ReceiptDao receiptdao = new ReceiptDao();

    @Inject
    private beans.SessionBean sessionBean;

    @PostConstruct
    public void init() {

        item_id = sessionBean.getSelectedItemId();
        profit = sessionBean.getProfit();
        sold_quantity = sessionBean.getSold_quantity();
        customer_name = sessionBean.getCustomer_name();
        customer_phone = sessionBean.getCustomer_phone();
        customer_address = sessionBean.getCustomer_address();

        try {

            if (item_id > 0) {
                item = itemdao.buildItem(item_id);
                id = item.getId();
                model = item.getModel();
                quantity = item.getQuantity();
                weight = item.getWeight();
                cirat = item.getCirat();
                color = item.getColor();
                cost = item.getCost();
                trader = item.getTrader();

                profit = sessionBean.getProfit();
                sold_quantity = sessionBean.getSold_quantity();

                price_without_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0);
                price_with_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost;
                total_price = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost + profit;

                pieces_price_without_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) * sold_quantity;
                pieces_price_with_cost = (float) (((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost) * sold_quantity;
                pieces_total_price = total_price * sold_quantity;

            }
        } catch (Exception ex) {
            Logger.getLogger(ItemDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePrice(int item_id) throws Exception {
        //setProfit(sessionBean.getProfit());
        setProfit(profit);
        int item_ids = sessionBean.getSelectedItemId();
        item = itemdao.buildItem(item_ids);
        id = item.getId();
        model = item.getModel();
        quantity = item.getQuantity();
        weight = item.getWeight();
        cirat = item.getCirat();
        color = item.getColor();
        cost = item.getCost();
        trader = item.getTrader();
        //profit=sessionBean.getProfit();
        price_without_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0);
        price_with_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost;
        total_price = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost + profit;

        pieces_price_without_cost = (float) ((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) * sold_quantity;
        pieces_price_with_cost = (float) (((weight * 1228.0 * 32.15 * 0.71 * cirat) / 1000.0) + cost) * sold_quantity;
        pieces_total_price = total_price * sold_quantity;

        reload();
        customer_name = sessionBean.getCustomer_name();
        customer_phone = sessionBean.getCustomer_phone();
        customer_address = sessionBean.getCustomer_address();

        receipt.setCustomer_id(1);
        receipt.setCustomer_name(customer_name);
        receipt.setCustomer_phone(customer_phone);
        receipt.setCustomer_address(customer_address);
        receipt.setId(id);
        receipt.setModel(model);
        receipt.setWeight(weight);
        receipt.setCirat(cirat);
        receipt.setColor(color);
        receipt.setCost(cost);
        receipt.setSold_quantity(sold_quantity);
        receipt.setTrader(trader);
        receipt.setPrice_without_cost(price_without_cost);
        receipt.setPrice_with_cost(price_with_cost);
        receipt.setTotal_price(total_price);
        receipt.setProfit(profit);
        receipt.setPieces_price_without_cost(pieces_price_without_cost);
        receipt.setPieces_price_with_cost(pieces_price_with_cost);
        receipt.setPieces_total_price(pieces_total_price);

        receiptdao.insertReceipt(receipt);

        System.out.println(total_price);
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    /**
     * @return the id
     */
    private UIComponent mybutton;

    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public void saveItem() {

        try {
            if (quantity < sold_quantity) {

                FacesMessage message = new FacesMessage("Invalid Quantity !");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(mybutton.getClientId(context), message);
            } else {
                int item_id = sessionBean.getSelectedItemId();
                SoldItems item = new SoldItems();

                item.setId(item_id);
                item.setModel(model);
                item.setWeight(weight);
                item.setCirat(cirat);
                item.setColor(color);
                item.setCost(cost);
                item.setSold_quantity(sold_quantity);
                item.setTrader(trader);
                item.setProfit(profit);
                item.setPrice_without_cost(price_without_cost);
                item.setPrice_with_cost(price_with_cost);
                item.setTotal_price(total_price);
                item.setPieces_price_without_cost(pieces_price_without_cost);
                item.setPieces_price_with_cost(pieces_price_with_cost);
                item.setPieces_total_price(pieces_total_price);

                Insertitemdao.insertSoldItem(item);

                if (quantity == 1) {
                    itemdao.deleteItem(item_id);
                } else {
                    Items updated_item = new Items();

                    updated_item.setId(item_id);
                    updated_item.setModel(model);
                    updated_item.setQuantity(quantity - sold_quantity);
                    updated_item.setWeight(weight);
                    updated_item.setCirat(cirat);
                    updated_item.setColor(color);
                    updated_item.setCost(cost);
                    updated_item.setTrader(trader);

                    itemdao.updateItem(updated_item, item_id);
                }

                sessionBean.navigate("receipt.xhtml");
            }
            //sessionBean.navigate("/gold_sector.xhtml");
        } catch (Exception ex) {
            Logger.getLogger(AddEditItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
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

    public int getSold_id() {
        return sold_id;
    }

    /**
     * Creates a new instance of ItemDetailsBean
     */
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

    public int getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity;
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

    public Items getSelectedItem() {//selected model 
        return selectedItem;
    }

    public void setSelectedItem(Items selectedItem) {
        this.selectedItem = selectedItem;
    }

}