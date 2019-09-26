package org.al.ecommerce.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Details {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "sales_id")
    private int salesId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", salesId=" + salesId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
