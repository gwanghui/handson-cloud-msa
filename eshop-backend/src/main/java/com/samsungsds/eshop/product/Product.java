package com.samsungsds.eshop.product;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.samsungsds.eshop.payment.Money;

@Entity
public class Product {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String picture;
    @Column(nullable = false)
    private Money priceUsd;
    @ElementCollection
    @CollectionTable(name="product_category", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name="category")
    private Set<String> categories;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Money getPriceUsd() {
        return this.priceUsd;
    }

    public void setPriceUsd(Money priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Set<String> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", picture='" + getPicture() + "'" +
            ", priceUsd='" + getPriceUsd() + "'" +
            ", categories='" + getCategories() + "'" +
            "}";
    }

}
