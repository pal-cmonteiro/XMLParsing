package com.journaldev.xmlparsing;

public class Group {// This class represents a single group (post) in the XML feed.

    // It includes the data members "mTitle," "link," and "summary."
    String mTitle;
    String mSubtitle;

    public Group() {
    }

    public Group(String title, String subtitle) {
        mTitle = title;
        mSubtitle = subtitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
    }
}