package com.adffaces.chapter7.view.ws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import weblogic.websocket.WebSocketAdapter;
import weblogic.websocket.WebSocketConnection;
import weblogic.websocket.WebSocketListener;
import weblogic.websocket.annotation.WebSocket;

@WebSocket(pathPatterns = { "/chat/*" }, timeout = -1)
public class WebsocketChatMessages extends WebSocketAdapter implements WebSocketListener {
    private static WebsocketChatMessages ws;
    private List<String> messages = Collections.synchronizedList(new ArrayList<String>());

    public WebsocketChatMessages() {
        super();
        ws = this;
    }

    public static WebsocketChatMessages getWs() {
        return ws;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void broadcastChatMessage(String message) {
        messages.add(message);
        for (WebSocketConnection conn : getWebSocketContext().getWebSocketConnections()) {
            try {
                System.out.println("Sending the message: " + message);
                if (conn.isOpen()) {
                    conn.send(message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
