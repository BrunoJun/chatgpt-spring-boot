package org.me.chatgptspringboot.vo.response;

import org.me.chatgptspringboot.vo.request.Message;

import java.io.Serializable;
import java.util.Objects;

public class Choice implements Serializable {

    private static final long serialVersionUID = 1L;
    private int index;
    private Message message;

    public Choice() {}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choice choice = (Choice) o;

        if (index != choice.index) return false;
        return Objects.equals(message, choice.message);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
