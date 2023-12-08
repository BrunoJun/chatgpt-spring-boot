package org.me.chatgptspringboot.vo.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatGptRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String model;
    private List<Message> messages;

    public ChatGptRequest() {}

    public ChatGptRequest(String model, String prompt) {

        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatGptRequest that = (ChatGptRequest) o;

        if (!Objects.equals(model, that.model)) return false;
        return Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }
}
