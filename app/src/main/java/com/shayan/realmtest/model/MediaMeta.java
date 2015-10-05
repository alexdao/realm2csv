package com.shayan.realmtest.model;

import io.realm.RealmObject;

/**
 * Created by alex on 10/5/15.
 */
public class MediaMeta extends RealmObject{

    private String title;
    private String ogtype;
    private String image;
    private String url;
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOgtype() {
        return ogtype;
    }

    public void setOgtype(String ogtype) {
        this.ogtype = ogtype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
