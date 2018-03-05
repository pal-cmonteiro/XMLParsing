package com.journaldev.xmlparsing;

import java.util.List;

class Constellation {
    private List<Group> mGroups;
    private List<Section> mSections;

    public void setGroups(List<Group> groups) {
        mGroups = groups;
    }

    public List<Section> getSections() {
        return mSections;
    }

    public void setSections(List<Section> sections) {
        mSections = sections;
    }
}
