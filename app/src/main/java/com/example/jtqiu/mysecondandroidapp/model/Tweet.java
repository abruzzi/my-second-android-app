
package com.example.jtqiu.mysecondandroidapp.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tweet implements Serializable {

    @Expose
    private String content;
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @Expose
    private User sender;

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * 
     * @param sender
     *     The sender
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

}
