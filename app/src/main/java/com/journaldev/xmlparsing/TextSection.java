package com.journaldev.xmlparsing;

public class TextSection extends Section {

    private String mText;

    public TextSection(String title, String subtitle, String text) {
        super(title, subtitle);
        mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}