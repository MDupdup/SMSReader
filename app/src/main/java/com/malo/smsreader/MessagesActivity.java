package com.malo.smsreader;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.malo.smsreader.Objects.Contact;
import com.malo.smsreader.Objects.Message;
import com.malo.smsreader.RecyclerTools.ClickListener;
import com.malo.smsreader.RecyclerTools.DividerItemDecorator;
import com.malo.smsreader.RecyclerTools.RecyclerTouchListener;
import com.malo.smsreader.Recyclers.ContactsRecycler.ContactsAdapter;
import com.malo.smsreader.Recyclers.MessageRecycler.MessagesAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MessagesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Message> listMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        listMessages = new ArrayList<>();

        try {
            InputStream smsList = getAssets().open(getIntent().getStringExtra("filename"));

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(smsList);

            NodeList nList = doc.getElementsByTagName("smses").item(0).getChildNodes();

            //Log.i("Maislol", Integer.toString(doc.getElementsByTagName("smses").item(0).getChildNodes().getLength()));

            ArrayList<String> listNums = new ArrayList<String>();

            Log.i("LOL", Integer.toString(nList.getLength()));

            for (int i=1; i<nList.getLength(); i+=2) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    String name = nList.item(i).getAttributes().getNamedItem("contact_name").getNodeValue();
                    String number = nList.item(i).getAttributes().getNamedItem("address").getNodeValue();
                    if(number.contains("+33")) {number = number.replace("+33","0");}

                    if(!number.equals(getIntent().getStringExtra("phone_number"))) {continue;}

                    int type = Integer.parseInt(nList.item(i).getAttributes().getNamedItem("type").getNodeValue());
                    String body = nList.item(i).getAttributes().getNamedItem("body").getNodeValue();
                    long date = Long.parseLong(nList.item(i).getAttributes().getNamedItem("date").getNodeValue());
                    String readableDate = nList.item(i).getAttributes().getNamedItem("readable_date").getNodeValue();
                    String subject = nList.item(i).getAttributes().getNamedItem("subject").getNodeValue();
                    if(subject.equals("null")) {subject = "";}

                    listMessages.add(new Message(new Contact(number,name),type,body,date,readableDate,subject));

//                    if(!listNums.contains(number)) {
//                        listNums.add(number);
//
//                    }

                    //listContacts.add(new Contact(number,name));
/*                    Log.i("DEHORS",number);
                    if(listContacts.size() > 0) {
                        Log.i("LOL",listContacts.get(0).getNumber());
                        for(int j = 0; j < listContacts.size(); j++) {
                            Log.i("LOL0",listContacts.get(j).getNumber());
                            if(!listContacts.get(j).getNumber().equals(number)) {
                                Log.i("LOL2",listContacts.get(j).getNumber());

                            }
                        }
                    }*/

                    //tv1.setText(tv1.getText() + nList.item(i).getAttributes().getNamedItem("body").getNodeValue() + "\n");
                }
            }

        } catch (Exception e) {e.printStackTrace();}

        recyclerView = findViewById(R.id.list_messages);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MessagesAdapter messagesAdapter = new MessagesAdapter(listMessages,this);
        recyclerView.setAdapter(messagesAdapter);
    }
}
