package com.journaldev.xmlparsing;

import java.util.List;

class Constellation {
    private List<Group> mGroups;
    private List<LinkSection> mLinkSections;
    private List<Text> mTexts;

    public List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(List<Group> groups) {
        mGroups = groups;
    }

    public List<LinkSection> getLinkSections() {
        return mLinkSections;
    }

    public void setLinkSections(List<LinkSection> linkSections) {
        mLinkSections = linkSections;
    }

    public List<Text> getTexts() {
        return mTexts;
    }

    public void setTexts(List<Text> texts) {
        mTexts = texts;
    }
}
