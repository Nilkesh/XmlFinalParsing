package com.example.nilkesh.xmlfinalparsing;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NILKESH on 9/20/2017.
 */

public class XmlPullParserHandler
{
    private List<FoodModel> employees= new ArrayList<FoodModel>();
    private FoodModel food;
    private String text;

    public List<FoodModel> getfoodModels() {
        return getfoodModels();
    }

    public List<FoodModel> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            // create a new instance of employee
                            food = new FoodModel();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            // add employee object to list
                            employees.add(food);
                        }else if (tagname.equalsIgnoreCase("id")) {
                            food.setId(Integer.parseInt(text));
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            food.setName(text);
                        } else if (tagname.equalsIgnoreCase("cost")) {
                            food.setCost(Integer.parseInt(text));
                        }
                        else if (tagname.equalsIgnoreCase("description")) {
                            food.setDescription(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();
        }
        catch (IOException e) {e.printStackTrace();}

        return employees;
    }
}

