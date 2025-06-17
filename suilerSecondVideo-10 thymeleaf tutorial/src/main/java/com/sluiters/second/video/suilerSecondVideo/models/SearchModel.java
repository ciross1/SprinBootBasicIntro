package com.sluiters.second.video.suilerSecondVideo.models;

public class SearchModel {

    String searchTerm;


    public SearchModel() {
    }

    public SearchModel(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
