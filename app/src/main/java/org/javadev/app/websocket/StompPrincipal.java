package org.javadev.app.websocket;

import java.security.Principal;

public class StompPrincipal implements Principal {
    private String uuid;

    public StompPrincipal(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getName() {
        return uuid;
    }
}