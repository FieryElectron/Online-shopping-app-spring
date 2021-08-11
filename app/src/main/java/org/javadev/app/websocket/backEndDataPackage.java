package org.javadev.app.websocket;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class backEndDataPackage {
  @NonNull private String text;

  backEndDataPackage(){
    
  }
}