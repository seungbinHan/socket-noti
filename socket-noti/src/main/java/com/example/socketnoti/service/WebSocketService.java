package com.example.socketnoti.service;

import com.example.socketnoti.handler.SocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class WebSocketService extends TextWebSocketHandler {

    @Autowired
    SocketHandler handler;
    private final ArrayList<WebSocketSession> userSessions = new ArrayList<WebSocketSession>();
    private WebSocketSession ws;

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("연결 2");
        this.ws = session;
        userSessions.add(ws);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("accessController 받은메시지=>"+message.getPayload());
        for(var sess : userSessions){
            sess.sendMessage(message);
        }
    }

    public void test() throws IOException {
        this.handleTextMessage(ws, new TextMessage("hihi"));
    }
}
