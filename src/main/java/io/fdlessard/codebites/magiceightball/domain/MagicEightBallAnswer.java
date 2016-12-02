package io.fdlessard.codebites.magiceightball.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by fdlessard on 16-11-25.
 */
public class MagicEightBallAnswer implements Serializable{

    private String id;

    private String message;

    private String color;

    public MagicEightBallAnswer() {
        // Needed for mashalling
    }

    public MagicEightBallAnswer(String id, String message, String color) {
        this.id = id;
        this.message = message;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("message", message)
                .append("color", color)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MagicEightBallAnswer)) {
            return false;
        }

        MagicEightBallAnswer that = (MagicEightBallAnswer) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(message, that.message)
                .append(color, that.color)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(message)
                .append(color)
                .toHashCode();
    }
}
