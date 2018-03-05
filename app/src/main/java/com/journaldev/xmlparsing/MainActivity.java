package com.journaldev.xmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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


            ConstellationXmlPaser constellationXmlPaser = new ConstellationXmlPaser();
            Constellation constellation = constellationXmlPaser.parse(in_s);

                String text="";
//            ArrayList<Country> countries=  parseXML(parser);
//            for(Country country:countries)
//            {
//
//                text+= "id : "+country.getId()+" name : "+country.getName()+" capital : "+country.getCapital()+"\n";
//            }
            for (LinkSection linkSection : constellation.getLinkSections()) {
                text += "LinkSection: " + linkSection.getTitle() + ", " + linkSection.getSubtitle()
                        + ", " + linkSection.getLayout()+"\n";
                for (Link link : linkSection.getLinks()) {
                    text += "Link: " +
                            (link.getUri() != null ? "uri: "+link.getUri() + ", ": "") +
                            (link.getHref() != null ? "href: "+link.getHref() + ", ": "") +
                            (link.getIcon() != null ? "icon: "+link.getIcon() + ", ": "") +
                            "\n";
                }
                text +="\n";
            }

            for (TextSection textSection : constellation.getTextSections()) {
                text += "textSection: " + textSection.getTitle() + ", " + "subtitle: " + textSection.getSubtitle() + "\n" +
                        "text: " + textSection.getText() + "\n";
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
