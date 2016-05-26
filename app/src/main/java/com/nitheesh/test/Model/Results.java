package com.nitheesh.test.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 08468 on 5/24/2016.
 */
public class Results implements Serializable{


    @SerializedName("results")
    ArrayList<EntityDetails> entities;

    public ArrayList<EntityDetails> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<EntityDetails> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "Results{" +
                "entities=" + entities +
                '}';
    }
}
