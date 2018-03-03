package com.journaldev.xmlparsing;

public class Link {
    String mTitle;
    String mSubtitle;
    String mText;

    public Link(String title, String subtitle, String text) {
        mTitle = title;
        mSubtitle = subtitle;
        mText = text;
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

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
