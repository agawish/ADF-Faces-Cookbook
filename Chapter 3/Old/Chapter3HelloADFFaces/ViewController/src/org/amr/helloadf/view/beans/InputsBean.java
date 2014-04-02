package org.amr.helloadf.view.beans;

import java.awt.Color;

import java.util.Date;

import oracle.adf.view.rich.model.NumberRange;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class InputsBean{

    private Color color;
    private Date date;
    private String text;
    private UploadedFile file;
    private Integer numberSlider;
    private Integer numberSpinbox;
    private NumberRange range;

    public void setRange(NumberRange range) {
        this.range = range;
    }

    public NumberRange getRange() {
        return range;
    }

    public void setNumberSlider(Integer numberSlider) {
        this.numberSlider = numberSlider;

    }

    public Integer getNumberSlider() {
        return numberSlider;
    }

    public void setNumberSpinbox(Integer numberSpinbox) {
        this.numberSpinbox = numberSpinbox;
    }

    public Integer getNumberSpinbox() {
        return numberSpinbox;
    }


    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public InputsBean() {
    }

    public String submitInputs() {

        System.out.println("The color is: " + this.getColor());

        System.out.println("The date is: " + this.getDate());

        System.out.println("The text is: " + this.getText());

        if(this.getFile()!=null){
            System.out.println("The file information is: " + this.getFile().getFilename() + " of content " +
                           this.getFile().getContentType());
        }
        System.out.println("The number slider value is: " + this.getNumberSlider());

        System.out.println("The number spinbox value is: " + this.getNumberSpinbox());
        if (this.getRange() != null) {
            System.out.println("The range slider value between: " + this.getRange().getMinimum() + " and " +
                               this.getRange().getMaximum());
        }
        return null;
    }
}
