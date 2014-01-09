package com.adffaces.chapter7.view.beans;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class EventsBean {
    public EventsBean() {
    }

    public void changeFirstName(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("First Name Changed from: " + valueChangeEvent.getOldValue() + " to: " +
                           valueChangeEvent.getNewValue());
    }

    public void submitChanges(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("All Values Submitted");
        ((RichButton) actionEvent.getSource()).setText("Submitted");

    }
}
