package com.journaldev.xmlparsing;

public class Group {// This class represents a single group (post) in the XML feed.

    // It includes the data members "title," "link," and "summary."
    String title;
    String subtitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}