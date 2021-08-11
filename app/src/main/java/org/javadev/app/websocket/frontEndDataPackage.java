package org.javadev.app.websocket;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class frontEndDataPackage {
  @NonNull private String text;

  frontEndDataPackage(){
    
  }
}