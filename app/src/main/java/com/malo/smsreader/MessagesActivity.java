package com.malo.smsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.malo.smsreader.Objects.Contact;
import com.malo.smsreader.Objects.Message;
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

        setTitle(getIntent().getStringExtra("contact_name"));

        try {
            InputStream smsList = getAssets().open(getIntent().getStringExtra("filename"));

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(smsList);

            NodeList nList = doc.getElementsByTagName("smses").item(0).getChildNodes();

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
                }
            }

        } catch (Exception e) {e.printStackTrace();}

        recyclerView = findViewById(R.id.list_messages);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        MessagesAdapter messagesAdapter = new MessagesAdapter(listMessages,this);
        recyclerView.setAdapter(messagesAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      return super.onOptionsItemSelected(item);
    }
}
