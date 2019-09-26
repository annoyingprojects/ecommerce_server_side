package org.al.ecommerce.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    @Column(name = "price")
    private int price;

    @Column(name = "photo")
    private String photo;

    @Column(name = "date_view")
    private String dataView;

    @Column(name = "counter")
    private int counter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDataView() {
        return dataView;
    }

    public void setDataView(String dataView) {
        this.dataView = dataView;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", slug='" + slug + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", dataView='" + dataView + '\'' +
                ", counter=" + counter +
                '}';
    }
}
