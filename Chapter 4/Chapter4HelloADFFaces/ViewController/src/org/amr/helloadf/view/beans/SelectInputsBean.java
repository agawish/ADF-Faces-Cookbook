package org.amr.helloadf.view.beans;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

public class SelectInputsBean {
    
    private Boolean booleanCheckbox;
    private Boolean booleanRadio;
    
    private String oneChoice;
    private String oneListbox;
    private String oneRadio;
    
    private List<String> manyCheckbox;
    private List<String> manyChoice;
    private List<String> manyListbox;
    private List<String> manyShuttle;
    private List<String> orderShuttle;

    public void setOrderShuttle(List<String> orderShuttle) {
        this.orderShuttle = orderShuttle;
    }

    public List<String> getOrderShuttle() {
        return orderShuttle;
    }

    public void setManyCheckbox(List<String> manyCheckbox) {
        this.manyCheckbox = manyCheckbox;
    }

    public List<String> getManyCheckbox() {
        return manyCheckbox;
    }

    public void setManyChoice(List<String> manyChoice) {
        this.manyChoice = manyChoice;
    }

    public List<String> getManyChoice() {
        return manyChoice;
    }

    public void setManyListbox(List<String> manyListbox) {
        this.manyListbox = manyListbox;
    }

    public List<String> getManyListbox() {
        return manyListbox;
    }

    public void setManyShuttle(List<String> manyShuttle) {
        this.manyShuttle = manyShuttle;
    }

    public List<String> getManyShuttle() {
        return manyShuttle;
    }


    public void setOneChoice(String oneChoice) {
        this.oneChoice = oneChoice;
    }

    public String getOneChoice() {
        return oneChoice;
    }

    public void setOneListbox(String oneListbox) {
        this.oneListbox = oneListbox;
    }

    public String getOneListbox() {
        return oneListbox;
    }

    public void setOneRadio(String oneRadio) {
        this.oneRadio = oneRadio;
    }

    public String getOneRadio() {
        return oneRadio;
    }

    public void setBooleanCheckbox(Boolean booleanCheckbox) {
        this.booleanCheckbox = booleanCheckbox;
    }

    public Boolean getBooleanCheckbox() {
        return booleanCheckbox;
    }

    public void setBooleanRadio(Boolean booleanRadio) {
        this.booleanRadio = booleanRadio;
    }

    public Boolean getBooleanRadio() {
        return booleanRadio;
    }

    
    public SelectInputsBean() {
    }

    public String submitSelectInputs() {
        System.out.println("The Boolean Checkbox value is: "+this.getBooleanCheckbox());
        System.out.println("The Boolean Radio value is: "+this.getBooleanRadio());
        
        System.out.println("The One Choice value is: "+this.getOneChoice());
        System.out.println("The One Listbox value is: "+this.getOneListbox());
        System.out.println("The One Radio value is: "+this.getOneRadio());
        
        
        System.out.println("The Many Checkbox value is: "+this.getManyCheckbox());
        System.out.println("The Many Choice value is: "+this.getManyChoice());
        System.out.println("The Many Listbox value is: "+this.getManyListbox());
        System.out.println("The Many Shuttle value is: "+this.getManyShuttle());
        System.out.println("The Order Shuttle value is: "+this.getOrderShuttle());
        return null;
    }
}
