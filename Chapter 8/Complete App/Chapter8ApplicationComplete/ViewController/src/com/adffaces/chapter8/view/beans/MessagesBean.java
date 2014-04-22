package com.adffaces.chapter8.view.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesBean {
    public MessagesBean() {
    }

    public String showMessages() {
        FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "An Information Message");
        FacesMessage warnMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "A Warning Message");
        FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An Error Message");
        FacesContext ctx = FacesContext.getCurrentInstance();

        ctx.addMessage(null, infoMsg);
        ctx.addMessage(null, warnMsg);
        ctx.addMessage(null, errorMsg);
        return null;
    }
}
