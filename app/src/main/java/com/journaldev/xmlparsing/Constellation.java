package com.journaldev.xmlparsing;

import java.util.List;

class Constellation {
    private List<Group> mGroups;
    private List<LinkSection> mLinkSections;
    private List<TextSection> mTextSections;

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

    public List<TextSection> getTextSections() {
        return mTextSections;
    }

    public void setTextSections(List<TextSection> textSections) {
        mTextSections = textSections;
    }
}
