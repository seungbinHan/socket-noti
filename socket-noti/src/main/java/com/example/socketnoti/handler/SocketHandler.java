package com.example.socketnoti.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Component
public class SocketHandler extends TextWebSocketHandler {

    Map<String,WebSocketSession> userSession = new HashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("메시지 왓다!");
        System.out.println(message.getPayload());

        System.out.println("어드민 들오나");
        TextMessage tm = new TextMessage("서버에서 주는 메시지!");
        session.sendMessage(tm);


//        WebSocketSession adminSession = (WebSocketSession) session.getAttributes().get("admin");
//        if(httpsession.get("admin") != null &&
//                httpsession.get("admin").toString().equals("admin")){
//            System.out.println("어드민 들오나");
//            TextMessage tm = new TextMessage("서버에서 주는 메시지!");
//            session.sendMessage(tm);//todo. admin 세션에다가 어떻게 alert을 보낼것인가?
//
//        }
    }

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속햇다!");
    }

    /* Client가 접속 해제 시 호출되는 메서드드 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("접속해제됏다!!");
    }
}
