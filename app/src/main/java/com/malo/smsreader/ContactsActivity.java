package com.malo.smsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        try {
            InputStream smsList = getAssets().open("file.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(smsList);

            NodeList nList = doc.getElementsByTagName("smses").item(0).getChildNodes();

            //Log.i("Maislol", Integer.toString(doc.getElementsByTagName("smses").item(0).getChildNodes().getLength()));

            for (int i=1; i<nList.getLength(); i+=2) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    //tv1.setText(tv1.getText() + nList.item(i).getAttributes().getNamedItem("body").getNodeValue() + "\n");
                }
            }

        } catch (Exception e) {e.printStackTrace();}
    }
}
