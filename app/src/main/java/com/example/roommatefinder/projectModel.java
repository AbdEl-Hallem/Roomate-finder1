package com.example.roommatefinder;

public class projectModel {
    private String edit_text_price_posts, edit_size, edit_text_no_beds, edit_text_no_baths,
            edit_text_no_roommates, edit_text_full_address_posts, edit_text_area_posts;
    private String add_photo_posts;

    public  projectModel(){

    }

    public projectModel(String edit_text_price_posts, String edit_size, String edit_text_no_beds, String edit_text_no_baths, String edit_text_no_roommates, String edit_text_full_address_posts, String edit_text_area_posts, String add_photo_posts) {
        this.edit_text_price_posts = edit_text_price_posts;
        this.edit_size = edit_size;
        this.edit_text_no_beds = edit_text_no_beds;
        this.edit_text_no_baths = edit_text_no_baths;
        this.edit_text_no_roommates = edit_text_no_roommates;
        this.edit_text_full_address_posts = edit_text_full_address_posts;
        this.edit_text_area_posts = edit_text_area_posts;
        this.add_photo_posts = add_photo_posts;
    }

    public String getEdit_text_price_posts() {
        return edit_text_price_posts;
    }

    public void setEdit_text_price_posts(String edit_text_price_posts) {
        this.edit_text_price_posts = edit_text_price_posts;
    }

    public String getEdit_size() {
        return edit_size;
    }

    public void setEdit_size(String edit_size) {
        this.edit_size = edit_size;
    }

    public String getEdit_text_no_beds() {
        return edit_text_no_beds;
    }

    public void setEdit_text_no_beds(String edit_text_no_beds) {
        this.edit_text_no_beds = edit_text_no_beds;
    }

    public String getEdit_text_no_baths() {
        return edit_text_no_baths;
    }

    public void setEdit_text_no_baths(String edit_text_no_baths) {
        this.edit_text_no_baths = edit_text_no_baths;
    }

    public String getEdit_text_no_roommates() {
        return edit_text_no_roommates;
    }

    public void setEdit_text_no_roommates(String edit_text_no_roommates) {
        this.edit_text_no_roommates = edit_text_no_roommates;
    }

    public String getEdit_text_full_address_posts() {
        return edit_text_full_address_posts;
    }

    public void setEdit_text_full_address_posts(String edit_text_full_address_posts) {
        this.edit_text_full_address_posts = edit_text_full_address_posts;
    }

    public String getEdit_text_area_posts() {
        return edit_text_area_posts;
    }

    public void setEdit_text_area_posts(String edit_text_area_posts) {
        this.edit_text_area_posts = edit_text_area_posts;
    }

    public String getAdd_photo_posts() {
        return add_photo_posts;
    }

    public void setAdd_photo_posts(String add_photo_posts) {
        this.add_photo_posts = add_photo_posts;
    }
}
