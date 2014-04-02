package com.adffacescookbook.chapter4.view.beans;

import java.util.Date;

public class OutputComponents {
    Date sampleDate = new Date();
    String textWithoutFormat = "Welcome to the Output Components";
    String bigTextWithFormat = "<b>Hi there </b>" + 
                               "Welcome to the Output components, Enjoy your stay";

    public OutputComponents() {
        super();
    }

    public void setTextWithoutFormat(String textWithoutFormat) {
        this.textWithoutFormat = textWithoutFormat;
    }

    public String getTextWithoutFormat() {
        return textWithoutFormat;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setBigTextWithFormat(String bigTextWithFormat) {
        this.bigTextWithFormat = bigTextWithFormat;
    }

    public String getBigTextWithFormat() {
        return bigTextWithFormat;
    }
}
