package com.adffacescookbook.chapter4.view.beans;

import java.io.IOException;
import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.io.UnsupportedEncodingException;

import javax.faces.context.FacesContext;

public class NavigationBean {
    public NavigationBean() {
    }

    public void downloadReadmeFile(FacesContext facesContext, OutputStream outputStream) {
        OutputStreamWriter w = null;
        try {
            w = new OutputStreamWriter(outputStream, "UTF-8");
            w.write("This is the Readme File.");
            w.write("Start Reading me!");
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
