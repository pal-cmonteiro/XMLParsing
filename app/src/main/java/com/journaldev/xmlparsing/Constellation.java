package com.journaldev.xmlparsing;

import java.util.List;

class Constellation {
    private List<Group> mGroups;
    private List<Link> mLinks;
    private List<Text> mTexts;

    public List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(List<Group> groups) {
        mGroups = groups;
    }

    public List<Link> getLinks() {
        return mLinks;
    }

    public void setLinks(List<Link> links) {
        mLinks = links;
    }

    public List<Text> getTexts() {
        return mTexts;
    }

    public void setTexts(List<Text> texts) {
        mTexts = texts;
    }
}
