package com.example.kevinteasdaledube.exercicexml;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParserFile {

    final static String TAG_BOOK = "book";
    final static String TAG_TITLE = "title";
    final static String TAG_AUTHOR = "author";
    final static String TAG_SUMMARY = "summary";
    final static String TAG_ISBN = "isbn";
    final static String TAG_LOCATION = "localization";
    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getBookFromFile(InputStream is) throws XmlPullParserException, IOException {

        Book curBook = null;
        String text = " ";


            XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp =   xmlFactory.newPullParser();
            xpp.setInput(is, "utf-8");
            int event = xpp.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();

                switch (event){

                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase(TAG_BOOK)){
                            curBook = new Book();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase(TAG_BOOK)){
                            this.books.add(curBook);
                        }else if (tagName.equalsIgnoreCase(TAG_TITLE)){
                            curBook.setTitle(text);
                        }else if (tagName.equalsIgnoreCase(TAG_AUTHOR)){
                            curBook.setAuthor(text);
                        }else if (tagName.equalsIgnoreCase(TAG_SUMMARY)){
                            curBook.setSummary(text);
                        }else if (tagName.equalsIgnoreCase(TAG_ISBN)){
                            curBook.setIsbn(text);
                        }else if (tagName.equalsIgnoreCase(TAG_LOCATION)){
                            curBook.setLocalization(text);
                        }
                            break;
                        default:
                            break;

                }
                event = xpp.next();
            }


        return books;
    }

}
