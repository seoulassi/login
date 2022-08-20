package com.webapp.webhome.common.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

}
