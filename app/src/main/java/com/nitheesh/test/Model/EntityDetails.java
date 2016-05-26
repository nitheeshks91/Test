package com.nitheesh.test.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 08468 on 5/24/2016.
 */
public class EntityDetails implements Serializable{

    @SerializedName("entity")
    Entity entity;

    @SerializedName("seed")
    String seed;

    @Override
    public String toString() {
        return "EntityDetails{" +
                "entity=" + entity +
                ", seed='" + seed + '\'' +
                '}';
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
