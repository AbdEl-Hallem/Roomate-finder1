package com.example.roommatefinder;

import java.util.List;

public class projectModel {
    private String edit_text_price_posts, edit_size, edit_text_no_beds, edit_text_no_baths,
            edit_text_no_roommates, edit_text_full_address_posts, edit_text_area_posts;
    private String edit_text_first_name_fill_information, edit_text_last_name_fill_information , edit_text_gender_fill_information ,
            edit_text_phone_number_fill_information , edit_text_birth_date_fill_information , edit_text_national_id_fill_information;
    private String add_photo;
    private List<String> post_images;
    private String date;
    private String propertytype;
    private String adtitle;
    private String addesc;
    private List<String> interests;

    private String uid;

    public projectModel(String furinture, String garage
            , String parking, String internet, String balacony, String garden, String workout, String security
            , String pets) {
        this.furinture = furinture;
        this.garage = garage;
        this.parking = parking;
        this.internet = internet;
        this.balacony = balacony;
        this.garden = garden;
        this.workout = workout;
        this.security = security;
        this.pets = pets;
    }

    public projectModel(String date, String adtitle, String addesc) {
        this.date = date;
        this.adtitle = adtitle;
        this.addesc = addesc;
    }

    private String furinture;
    private String garage;

    public List<String> getInterests() {
        return interests;
    }
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public String getAddesc() {
        return addesc;
    }

    public void setAddesc(String addesc) {
        this.addesc = addesc;
    }

    public String getFurinture() {
        return furinture;
    }

    public void setFurinture(String furinture) {
        this.furinture = furinture;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getBalacony() {
        return balacony;
    }

    public void setBalacony(String balacony) {
        this.balacony = balacony;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getWashingmachines() {
        return washingmachines;
    }

    public void setWashingmachines(String washingmachines) {
        this.washingmachines = washingmachines;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getAirconditioner() {
        return airconditioner;
    }

    public void setAirconditioner(String airconditioner) {
        this.airconditioner = airconditioner;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public projectModel(String date, String propertytype, String adtitle, String addesc, String furinture, String garage, String parking, String internet, String balacony, String garden, String workout, String security, String pets, String washingmachines, String tv, String airconditioner, String other) {
        this.date = date;
        this.propertytype = propertytype;
        this.adtitle = adtitle;
        this.addesc = addesc;
        this.furinture = furinture;
        this.garage = garage;
        this.parking = parking;
        this.internet = internet;
        this.balacony = balacony;
        this.garden = garden;
        this.workout = workout;
        this.security = security;
        this.pets = pets;
        this.washingmachines = washingmachines;
        this.tv = tv;
        this.airconditioner = airconditioner;
        this.other = other;
    }

    private String parking;
    private String internet;
    private String balacony;
    private String garden;
    private String workout;
    private String security;
    private String pets;
    private String washingmachines;
    private String tv;
    private String airconditioner;
    private String other;

    public projectModel(String id) {
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    boolean isFavorite;

//    public Boolean getFavorite() {
//        return isFavorite;
//    }
//
//    public void setFavorite(Boolean favorite) {
//        isFavorite = favorite;
//    }
//
//    private Boolean isFavorite;
//
//    public projectModel(Boolean isFavorite) {
//        this.isFavorite = isFavorite;
//    }


    public  projectModel(){

    }

    public projectModel(String edit_text_first_name_fill_information, String add_photo) {
        this.edit_text_first_name_fill_information = edit_text_first_name_fill_information;
        this.add_photo = add_photo;
    }
//    public boolean isFavorite() {
//        return isFavorite;
//    }
//
//    public void setIsFavorite(boolean isFavorite) {
//
//        this.isFavorite = isFavorite;
//    }

    public projectModel(String edit_text_last_name_fill_information, String edit_text_gender_fill_information, String edit_text_phone_number_fill_information, String edit_text_birth_date_fill_information, String edit_text_national_id_fill_information) {
        this.edit_text_last_name_fill_information = edit_text_last_name_fill_information;
        this.edit_text_gender_fill_information = edit_text_gender_fill_information;
        this.edit_text_phone_number_fill_information = edit_text_phone_number_fill_information;
        this.edit_text_birth_date_fill_information = edit_text_birth_date_fill_information;
        this.edit_text_national_id_fill_information = edit_text_national_id_fill_information;

    }

    public String getEdit_text_last_name_fill_information() {
        return edit_text_last_name_fill_information;
    }

    public void setEdit_text_last_name_fill_information(String edit_text_last_name_fill_information) {
        this.edit_text_last_name_fill_information = edit_text_last_name_fill_information;
    }

    public String getEdit_text_gender_fill_information() {
        return edit_text_gender_fill_information;
    }

    public void setEdit_text_gender_fill_information(String edit_text_gender_fill_information) {
        this.edit_text_gender_fill_information = edit_text_gender_fill_information;
    }

    public String getEdit_text_phone_number_fill_information() {
        return edit_text_phone_number_fill_information;
    }

    public void setEdit_text_phone_number_fill_information(String edit_text_phone_number_fill_information) {
        this.edit_text_phone_number_fill_information = edit_text_phone_number_fill_information;
    }

    public String getEdit_text_birth_date_fill_information() {
        return edit_text_birth_date_fill_information;
    }

    public void setEdit_text_birth_date_fill_information(String edit_text_birth_date_fill_information) {
        this.edit_text_birth_date_fill_information = edit_text_birth_date_fill_information;
    }

    public String getEdit_text_national_id_fill_information() {
        return edit_text_national_id_fill_information;
    }

    public void setEdit_text_national_id_fill_information(String edit_text_national_id_fill_information) {
        this.edit_text_national_id_fill_information = edit_text_national_id_fill_information;
    }

    public String getEdit_text_first_name_fill_information() {
        return edit_text_first_name_fill_information;
    }

    public void setEdit_text_first_name_fill_information(String edit_text_first_name_fill_information) {
        this.edit_text_first_name_fill_information = edit_text_first_name_fill_information;
    }

    public String getAdd_photo() {
        return add_photo;
    }

    public void setAdd_photo(String add_photo) {
        this.add_photo = add_photo;
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

    public List<String> getPost_images() {
        return post_images;
    }

    public void setPost_images(List<String> post_images) {
        this.post_images = post_images;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}