package com.malo.smsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.malo.smsreader.Objects.File;
import com.malo.smsreader.Recyclers.XmlFileRecycler.XmlFilesAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<File> listFiles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFiles = new ArrayList<>();

        String[] path = null;
        try {
            path = getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0; i < path.length; i++) {

            long date = 0;
            int messageCount = 0;

            try {
                InputStream smsList = getAssets().open(path[0]);

                String[] hiddenFiles = new String[] {"images","webkit"};

                if (Arrays.asList(hiddenFiles).contains(path[i])) {
                    continue;
                }

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(smsList);

                date = Long.parseLong(doc.getElementsByTagName("smses").item(0).getAttributes().getNamedItem("backup_date").getNodeValue());
                messageCount = Integer.parseInt(doc.getElementsByTagName("smses").item(0).getAttributes().getNamedItem("count").getNodeValue());

            } catch (Exception e) {
                e.printStackTrace();
            }
            listFiles.add(new File(path[i],date,messageCount));
        }

        recyclerView = findViewById(R.id.list_xml_files);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        XmlFilesAdapter xmlFilesAdapter = new XmlFilesAdapter(listFiles);
        recyclerView.setAdapter(xmlFilesAdapter);
    }

}