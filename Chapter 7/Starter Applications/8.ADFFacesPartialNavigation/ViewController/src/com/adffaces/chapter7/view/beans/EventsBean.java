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

    public void changeServerEmail(ClientEvent clientEvent) {
        // Add event code here...
        Object oldValue = clientEvent.getParameters().get("oldValue");
        Object newValue = clientEvent.getParameters().get("newValue");
        System.out.println("Email Changed from: " + oldValue + " to: " + newValue);
    }

    public void changePhoneNumber(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = valueChangeEvent.getNewValue().toString();
        if (!newValue.matches("^\\d.*$")) {
            FacesContext context = FacesContext.getCurrentInstance();
            ExtendedRenderKitService erks = Service.getRenderKitService(context, ExtendedRenderKitService.class);
            StringBuilder builder = new StringBuilder();
            builder.append("var component = AdfPage.PAGE.findComponentByAbsoluteId('" +
                           ((RichInputText) valueChangeEvent.getSource()).getClientId() + "');");
            builder.append("var message=new AdfFacesMessage(AdfFacesMessage.TYPE_WARNING, 'Double Check your input', 'Are you sure you want to enter " +
                           newValue + " as a Phone Number');");
            builder.append("AdfPage.PAGE.addMessage(component.getClientId(),message);");
            builder.append("AdfPage.PAGE.showMessages(component.getClientId());");
            builder.append("component.focus();");
            erks.addScript(context, builder.toString());
        }
    }
}
