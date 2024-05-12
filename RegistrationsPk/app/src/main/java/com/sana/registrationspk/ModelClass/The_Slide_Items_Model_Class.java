package com.sana.registrationspk.ModelClass;

public class The_Slide_Items_Model_Class {
    private int featured_image;
    private String the_caption_Title;

    public The_Slide_Items_Model_Class(int hero, String title) {
        this.featured_image = hero;
        this.the_caption_Title = title;
    }

    public int getFeatured_image() {
        return this.featured_image;
    }

    public String getThe_caption_Title() {
        return this.the_caption_Title;
    }

    public void setFeatured_image(int featured_image2) {
        this.featured_image = featured_image2;
    }

    public void setThe_caption_Title(String the_caption_Title2) {
        this.the_caption_Title = the_caption_Title2;
    }
}
