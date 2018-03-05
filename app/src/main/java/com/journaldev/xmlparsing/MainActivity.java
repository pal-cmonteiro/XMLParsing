package com.journaldev.xmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView)findViewById(R.id.text);

        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            String fileName = "constellation.xml";
            InputStream in_s = getApplicationContext().getAssets().open(fileName);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);


            ConstellationXmlParser constellationXmlParser = new ConstellationXmlParser();
            Constellation constellation = constellationXmlParser.parse(in_s);

            String text="";
            for (Section section : constellation.getSections()) {
                text += "Section: " + section.getTitle() + ", " + section.getSubtitle();
                if (section instanceof ItemSection) {
                    text += ", " + ((ItemSection) section).getLayoutString() + "\n";
                    for (Object item : ((ItemSection) section).getItems()) {
                        if (item instanceof Group) {
                            Group group = (Group) item;
                            text += "Group: " +
                                    (group.getId() != null ? "id: " + group.getId() + ", " : "") +
                                    (group.getIcon() != null ? "icon: " + group.getIcon() + ", " : "") +
                                    "\n";
                        } else if (item instanceof Link) {
                            Link link = (Link) item;
                            text += "Link: " +
                                    (link.getUri() != null ? "uri: " + link.getUri() + ", " : "") +
                                    (link.getHref() != null ? "href: " + link.getHref() + ", " : "") +
                                    (link.getIcon() != null ? "icon: " + link.getIcon() + ", " : "") +
                                    "\n";
                        }
                    }
                } else if (section instanceof TextSection) {
                    TextSection textSection = (TextSection) section;
                    text += "\n" +
                            "text: " + textSection.getText() + "\n";
                }
                text +="\n";
            }



            textView.setText(text);



        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
