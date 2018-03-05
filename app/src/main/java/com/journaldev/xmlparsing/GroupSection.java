package com.journaldev.xmlparsing;

import java.util.List;

public class GroupSection extends Section {
    private String mLayout;
    private List<Group> mGroups;

    public GroupSection(String title, String subtitle, String layout, List<Group> groups) {
        super(title,subtitle);
        mLayout = layout;
        mGroups = groups;
    }

    public String getLayout() {
        return mLayout;
    }

    public void setLayout(String layout) {
        mLayout = layout;
    }

    public List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(List<Group> groups) {
        mGroups = groups;
    }
}