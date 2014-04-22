package com.adffaces.chapter5.view.beans;

import java.io.Serializable;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class UserSkinBean implements Serializable {
    String defaultSkin = "hrBlue";

    public UserSkinBean() {
    }

    public void setDefaultSkin(String defaultSkin) {
        this.defaultSkin = defaultSkin;
    }

    public String getDefaultSkin() {
        return defaultSkin;
    }

    private void refreshPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);
    }

    public String makeBlueDefaultSkin() {
        defaultSkin = "hrBlue";
        refreshPage();
        return null;
    }

    public String makeRedDefaultSkin() {
        defaultSkin = "hrRed";
        refreshPage();
        return null;
    }
}
