package com.example.socketnoti.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Component
public class SocketHandler extends TextWebSocketHandler {

    ArrayList<WebSocketSession> userSessions = new ArrayList<WebSocketSession>();
    Map<String,WebSocketSession> userSession = new HashMap<>();

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속햇다!");
        userSessions.add(session);
        System.out.println("add session!!");
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("메시지 왓다!");
        System.out.println(message.getPayload());
        TextMessage tm = new TextMessage("서버에서 주는 메시지!");

        for(var sess : userSessions){
            if(sess.getAttributes().get("admin") != null &&
                    sess.getAttributes().get("admin").equals("admin")){
                sess.sendMessage(tm);
            }
        }
    }


    /* Client가 접속 해제 시 호출되는 메서드드 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("접속해제됏다!!");
        userSessions.remove(session);
    }
}
