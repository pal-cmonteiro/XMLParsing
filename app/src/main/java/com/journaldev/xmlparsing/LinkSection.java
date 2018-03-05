package com.journaldev.xmlparsing;

import java.util.List;

public class LinkSection extends Section {
    private String mLayout;
    private List<Link> mLinks;

    LinkSection(String title, String subtitle, String layout, List<Link> links) {
        super(title, subtitle);
        mLayout = layout;
        mLinks = links;
    }

    public String getLayout() {
        return mLayout;
    }

    public void setLayout(String layout) {
        mLayout = layout;
    }

    public List<Link> getLinks() {
        return mLinks;
    }

    public void setLinks(List<Link> links) {
        mLinks = links;
    }
}
