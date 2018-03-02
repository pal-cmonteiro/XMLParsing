package com.journaldev.xmlparsing;public class Groupy{// This class represents a single group (post) in the XML feed.
    // It includes the data members "title," "link," and "summary."
    static class Group {
        public final java.lang.String title;
        public final java.lang.String subtitle;

        Group(java.lang.String title, java.lang.String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }

        public Group() {
            
        }
    }}