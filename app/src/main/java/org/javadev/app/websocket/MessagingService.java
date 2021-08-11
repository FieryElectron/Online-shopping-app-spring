package org.javadev.app.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessagingService {

    @EventListener(SessionConnectEvent.class)
    public void handleWebsocketConnectListener(SessionConnectEvent event) {
		SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String uuid = headers.getUser().getName();
        String sessionid= headers.getSessionId();
        System.out.println("Connect");
        System.out.println("uuid:"+uuid+"\tsessionid:"+sessionid);
    }

    @EventListener(SessionDisconnectEvent.class)
    public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String uuid = headers.getUser().getName();
        String sessionid= headers.getSessionId();
        System.out.println("Disconnect");
        System.out.println("uuid:"+uuid+"\tsessionid:"+sessionid);
    }

}
