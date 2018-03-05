package com.journaldev.xmlparsing;

class Group {

    private String mId;
    private String mIcon;
    private String mText;

    public Group(String id, String icon, String text) {
        mId = id;
        mIcon = icon;
        mText = text;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
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
