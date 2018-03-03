package com.journaldev.xmlparsing;

public class Link {

    private String mUrl;
    private String mHref;
    private String mIcon;
    private String mText;

    public Link(String url, String href, String icon, String text) {
        mUrl = url;
        mHref = href;
        mIcon = icon;
        mText = text;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}