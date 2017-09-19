package com.example.nilkesh.xmlfinalparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView1);

        List<FoodModel> food = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is=getAssets().open("food.xml");
            Log.e("is","is:  " + is);
            food = parser.parse(is);

            ArrayAdapter<FoodModel> adapter =new ArrayAdapter<FoodModel>
                    (this,android.R.layout.simple_list_item_1, food);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}

    }
}

