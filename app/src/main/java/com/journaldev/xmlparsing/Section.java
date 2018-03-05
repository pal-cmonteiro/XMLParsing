package com.journaldev.xmlparsing;

public abstract class Section {
    String mTitle;
    String mSubtitle;

    public Section(String title, String subtitle) {
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
