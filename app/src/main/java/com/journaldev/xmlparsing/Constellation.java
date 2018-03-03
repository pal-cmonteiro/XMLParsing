package com.journaldev.xmlparsing;

import java.util.List;

class Constellation {
    private List<Group> mGroups;
    private List<Text> mTexts;

    public List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(List<Group> groups) {
        mGroups = groups;
    }

    public List<Text> getTexts() {
        return mTexts;
    }

    public void setTexts(List<Text> texts) {
        mTexts = texts;
    }
}
