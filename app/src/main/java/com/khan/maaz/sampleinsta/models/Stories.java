package com.khan.maaz.sampleinsta.models;

import com.khan.maaz.sampleinsta.R;

public class Stories {
    private int stories_images;
    private String uploader;

    public Stories (String uploader, int stories_images)
    {
      this.stories_images=stories_images;
        this.uploader=uploader;
    }



    public int getStory() {
       return stories_images;
    }

    public void setStory(int stories_images) {
        this.stories_images = stories_images;
   }

    public String getUploader() {
       return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
