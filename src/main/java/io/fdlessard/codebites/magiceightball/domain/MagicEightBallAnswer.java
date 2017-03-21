package io.fdlessard.codebites.magiceightball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by fdlessard on 16-11-25.
 */
//@Entity(name = "MAGIC_EIGHT_BALL_ANSWER")
@Entity()
@Table(name="MAGIC_EIGHT_BALL_ANSWER")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID")
public class MagicEightBallAnswer implements Serializable {

    @Id
    @GeneratedValue(generator = "Seq")
    @SequenceGenerator(name = "Seq", sequenceName = "SEQ_ID", allocationSize = 1)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @NotNull(message = "{magiceightball.tenantId}")
    @JsonIgnore
    @Column(name = "TENANT_ID", insertable = false, updatable = false)
    private String tenantId;

    @NotNull(message = "{magiceightball.message}")
    private String message;

    @NotNull(message ="{magiceightball.color}")
    private String color;

    public MagicEightBallAnswer() {
        // Needed for marshalling
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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
                .append("version", version)
                .append("tenantId", tenantId)
                .append("message", message)
                .append("color", color)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MagicEightBallAnswer)) return false;

        MagicEightBallAnswer that = (MagicEightBallAnswer) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(version, that.version)
                .append(tenantId, that.tenantId)
                .append(message, that.message)
                .append(color, that.color)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(version)
                .append(tenantId)
                .append(message)
                .append(color)
                .toHashCode();
    }
}
