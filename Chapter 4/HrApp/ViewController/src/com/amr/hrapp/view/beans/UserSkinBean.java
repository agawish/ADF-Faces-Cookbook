package com.amr.hrapp.view.beans;

import java.io.Serializable;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class UserSkinBean implements Serializable {
    String defaultSkin = "hrBlue";

    public void setDefaultSkin(String defaultSkin) {
        this.defaultSkin = defaultSkin;
    }

    public String getDefaultSkin() {
        return defaultSkin;
    }

    public UserSkinBean() {
    }

    public String makeBlueDefaultSkin() {
        // Add event code here...
        defaultSkin = "hrBlue";
        refreshPage();
        return null;
    }

    public String makeRedDefaultSkin() {
        // Add event code here...
        defaultSkin = "hrRed";
        refreshPage();
        return null;
    }

    private void refreshPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);
    }
}
