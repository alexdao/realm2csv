package com.shayan.realmtest.model;

import io.realm.RealmObject;

/**
 * Created by alex on 10/5/15.
 */
public class Media extends RealmObject {

    private String url;
    private String name;
    private String type;
    private MediaMeta meta;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MediaMeta getMeta() {
        return meta;
    }

    public void setMeta(MediaMeta meta) {
        this.meta = meta;
    }
}
