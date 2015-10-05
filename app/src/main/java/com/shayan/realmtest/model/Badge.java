package com.shayan.realmtest.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by alex on 10/5/15.
 */
public class Badge extends RealmObject {

    private String id;
    private String name;
    private Date dateAwarded;
    private Media _media;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAwarded() {
        return dateAwarded;
    }

    public void setDateAwarded(Date dateAwarded) {
        this.dateAwarded = dateAwarded;
    }

    public Media get_media() {
        return _media;
    }

    public void set_media(Media _media) {
        this._media = _media;
    }
}
