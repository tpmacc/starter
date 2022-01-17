package tpmacc.starter.api;

import lombok.Data;

@Data
public class Greeting {
    long id;
    String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
