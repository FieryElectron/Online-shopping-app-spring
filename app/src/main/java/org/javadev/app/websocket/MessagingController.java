package org.javadev.app.websocket;

import java.security.Principal;

import org.javadev.app.mongo.MongoUserRepository;
import org.javadev.app.mongo.mongoUser;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MessagingController {

  private static final String WS_CHANNEL_DESTINATION = "/message";
  private final SimpMessagingTemplate simpMessagingTemplate;
  // private final Authentication authentication;

  private final MongoUserRepository mongoUserRepository;


  public void signUp(){

  }

  public void signIn(){
    
  }

  @MessageMapping("/channel")
  public void channel(backEndDataPackage message, @Header("simpSessionId") String sessionId, Principal principal)
      throws Exception {

        // mongoUserRepository.save(new mongoUser("0", "user1"));



    // String existingPassword = "password";

    // ArrayList<String> hashedPasswd = new ArrayList<String>();

    // for (int i = 0; i < 10; ++i) {
    //   hashedPasswd.add(authentication.generateEncodedPassword(existingPassword));
    // }

    // for (String pw : hashedPasswd) {
    //   if (authentication.passwordsAreMatch(existingPassword, pw)) {
    //     System.out.println("Yes--:" + pw);
    //   } else {
    //     System.out.println("No---:" + pw);
    //   }
    // }

    simpMessagingTemplate.convertAndSendToUser(principal.getName(), WS_CHANNEL_DESTINATION,
        new frontEndDataPackage("U sent " + message.getText()));
  }

  @MessageMapping("/broadcast")
  @SendTo("/message")
  public frontEndDataPackage broadcast(backEndDataPackage message, @Header("simpSessionId") String sessionId,
      Principal principal) throws Exception {
    return new frontEndDataPackage(principal.getName() + " sent something");
  }

}