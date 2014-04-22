package com.adffaces.chapter9.view.handlers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.ViewPortContext;

@ManagedBean
@SessionScoped
public class ExceptionHandler {
    public ExceptionHandler() {
        super();
    }

    public void handleException() {
        ControllerContext context = ControllerContext.getInstance();

        ViewPortContext viewPortContext = context.getCurrentRootViewPort();


        if (viewPortContext.isExceptionPresent()) {
            viewPortContext.clearException();
            FacesContext ctx = FacesContext.getCurrentInstance();

            FacesMessage message =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "UnExpected Exception occured",
                                 "I've recovered from unhandled Exception");
            ctx.addMessage(null, message);
        }
    }
}
