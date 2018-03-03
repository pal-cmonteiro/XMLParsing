package com.journaldev.xmlparsing;

public class Text {// This class represents a single group (post) in the XML feed.

    // It includes the data members "mTitle," "link," and "summary."
    private String mTitle;
    private String mSubtitle;
    private String mText;

    public Text(String title, String subtitle, String text) {
        mTitle = title;
        mSubtitle = subtitle;
        mText = text;
    }

    public Text() {

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
        subtitle = subtitle;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}