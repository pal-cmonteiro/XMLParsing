/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.journaldev.xmlparsing;

import android.util.Xml;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class parses XML feeds from stackoverflow.com.
 * Given an InputStream representation of a feed, it returns a List of entries,
 * where each list element represents a single group (post) in the XML feed.
 */
public class ConstellationXmlParser {
    private static final String ns = null;

    // We don't use namespaces

    public Constellation parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readRoot(parser);
        } finally {
            in.close();
        }
    }

    private Constellation readRoot(XmlPullParser parser) throws XmlPullParserException, IOException {
        Constellation constellation = new Constellation();
        List<Section> sections = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "root");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("links")) {
                sections.add(readLinksSection(parser));
            } else if (name.equals("groups")) {
                sections.add(readGroupsSection(parser));
            } else if (name.equals("text")) {
                sections.add(readTextSection(parser));
            } else {
                skip(parser);
            }
        }
        constellation.setSections(sections);
        return constellation;
    }

    private ItemSection<Group> readGroupsSection(XmlPullParser parser) throws XmlPullParserException,IOException {
        parser.require(XmlPullParser.START_TAG, ns, "groups");
        String title, subtitle;
        @ItemSection.SectionLayout int layout;
        List<Group> groups = new ArrayList<>();

        title = getTitle(parser);
        subtitle = getSubtitle(parser);
        layout = getLayout(parser);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("group")) {
                groups.add(readGroup(parser));
            } else {
                skip(parser);
            }
        }
        return new ItemSection<>(title, subtitle, layout, groups);
    }


    // Parses the contents of an group. If it encounters a mTitle, summary, or link tag, hands them
    // off
    // to their respective &quot;read&quot; methods for processing. Otherwise, skips the tag.
    private Group readGroup(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "group");
        String id = "";
        String icon = "";
        String text = "";
        String tag = parser.getName();
        if (tag.equals("group")) {
            id = parser.getAttributeValue(ns, "id");
            icon = parser.getAttributeValue(ns, "icon");
            text = readText(parser);
        }
        parser.require(XmlPullParser.END_TAG, ns, "group");
        return new Group(id, icon, text);
    }



    private ItemSection<Link> readLinksSection(XmlPullParser parser) throws XmlPullParserException,IOException {
        parser.require(XmlPullParser.START_TAG, ns, "links");
        String title, subtitle;
        @ItemSection.SectionLayout int layout;
        List<Link> links = new ArrayList<>();

        title = getTitle(parser);
        subtitle = getSubtitle(parser);
        layout = getLayout(parser);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("link")) {
                links.add(readLink(parser));
            } else {
                skip(parser);
            }
        }
        return new ItemSection<>(title, subtitle, layout, links);
    }

    private String getSubtitle(XmlPullParser parser) {
        return parser.getAttributeValue(ns, "subtitle");
    }

    private String getTitle(XmlPullParser parser) {
        return parser.getAttributeValue(ns, "title");
    }

    private int getLayout(XmlPullParser parser) {
        if (parser.getAttributeValue(ns, "layout").equalsIgnoreCase("vertical")) {
            return LinearLayout.VERTICAL;
        }
        return LinearLayout.HORIZONTAL;
    }

    // Parses the contents of an link. If it encounters a mTitle, summary, or link tag, hands them
    // off
    // to their respective &quot;read&quot; methods for processing. Otherwise, skips the tag.
    private Link readLink(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "link");
        String uri = "";
        String href = "";
        String icon = "";
        String text = "";
        String tag = parser.getName();
        if (tag.equals("link")) {
            uri = parser.getAttributeValue(ns, "uri");
            href = parser.getAttributeValue(ns, "href");
            icon = parser.getAttributeValue(ns, "icon");
            text = readText(parser);
        }
        parser.require(XmlPullParser.END_TAG, ns, "link");
        return new Link(uri, href, icon, text);
    }

    // Parses the contents of an group. If it encounters a mTitle, summary, or link tag, hands them
    // off
    // to their respective &quot;read&quot; methods for processing. Otherwise, skips the tag.
    private TextSection readTextSection(XmlPullParser parser) throws XmlPullParserException, IOException {
        String title, subtitle, text = "";
        parser.require(XmlPullParser.START_TAG, ns, "text");
        String tag = parser.getName();
        title = getTitle(parser);
        subtitle = getSubtitle(parser);
        if (tag.equals("text")) {
            text = readText(parser);
        }
        parser.require(XmlPullParser.END_TAG, ns, "text");
        return new TextSection(title, subtitle, text);
    }

    // Processes mTitle tags in the feed.
    private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "mTitle");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "mTitle");
        return title;
    }

    // Processes mSubtitle tags in the group.
    private String readSubtitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "mSubtitle");
        String subtitle = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "mSubtitle");
        return subtitle;
    }

    // For the tags mTitle and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    // Skips tags the parser isn't interested in. Uses depth to handle nested tags. i.e.,
    // if the next tag after a START_TAG isn't a matching END_TAG, it keeps going until it
    // finds the matching END_TAG (as indicated by the value of "depth" being 0).
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
            case XmlPullParser.END_TAG:
                    depth--;
                    break;
            case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
