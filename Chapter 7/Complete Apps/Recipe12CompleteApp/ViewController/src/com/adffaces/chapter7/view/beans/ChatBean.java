package com.adffaces.chapter7.view.beans;

import com.adffaces.chapter7.view.ws.WebsocketChatMessages;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.render.ClientEvent;

@ManagedBean(name="chatBean")
@SessionScoped
public class ChatBean {
    public ChatBean() {
        super();
    }
    public List<String> getChatMessages(){
        if(WebsocketChatMessages.getWs()== null || WebsocketChatMessages.getWs().getMessages()==null){
            return new ArrayList<String>();
        }
        return WebsocketChatMessages.getWs().getMessages();
    }
    
    public void newChatMessage(ValueChangeEvent valueChangeEvent) {
        String newValue=valueChangeEvent.getNewValue().toString();
        WebsocketChatMessages.getWs().broadcastChatMessage(newValue);
    }


    public void refreshTable(ClientEvent clientEvent) {
        String clientId=clientEvent.getParameters().get("clientId").toString();
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        AdfFacesContext.getCurrentInstance().addPartialTarget(root.findComponent(clientId));
    }
}
