package com.journaldev.xmlparsing;

public class Link {

    private String mUri;
    private String mHref;
    private String mIcon;
    private String mText;

    public Link(String uri, String href, String icon, String text) {
        mUri = uri;
        mHref = href;
        mIcon = icon;
        mText = text;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
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