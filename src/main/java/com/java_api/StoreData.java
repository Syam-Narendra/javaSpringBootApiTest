package com.java_api;

public class StoreData {

    private String id; 
    private String title; 
    private String price; 
    private String description;
    private String category;
    private String imageUrl;
    private String sold;
    private String dateOfSale;
    

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return String return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return String return the sold
     */
    public String getSold() {
        return sold;
    }

    /**
     * @param sold the sold to set
     */
    public void setSold(String sold) {
        this.sold = sold;
    }

    /**
     * @return String return the dateOfSale
     */
    public String getDateOfSale() {
        return dateOfSale;
    }

    /**
     * @param dateOfSale the dateOfSale to set
     */
    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

}