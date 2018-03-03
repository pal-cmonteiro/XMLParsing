package com.journaldev.xmlparsing;

import java.util.List;

public class LinkSection {
    private String mTitle;
    private String mSubtitle;
    private String mLayout;
    private List<Link> mLinks;

    LinkSection(String title, String subtitle, String layout, List<Link> links) {
        mTitle = title;
        mSubtitle = subtitle;
        mLayout = layout;
        mLinks = links;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
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
