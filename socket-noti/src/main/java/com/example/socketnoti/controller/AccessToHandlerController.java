package com.example.socketnoti.controller;
import com.example.socketnoti.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
@Controller
public class AccessToHandlerController extends TextWebSocketHandler {

   @Autowired
    WebSocketService webSocketService;

    @ResponseBody
    @GetMapping(value = "/access")
    public void access() throws IOException {

        webSocketService.test();

    }

}
