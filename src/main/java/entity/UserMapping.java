package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user_mapping", uniqueConstraints = {
        @UniqueConstraint(columnNames={"chatUserId", "messenger", "account_id"})
})
public class UserMapping {
    final String STATUS_ACTIVE = "active";
    final String STATUS_DISABLED = "disabled";

    final String MESSENGER_TELEGRAM = "telegram";
    final String MESSENGER_SLACK = "slack";
    final String MESSENGER_FACEBOOK = "facebook";
    final String MESSENGER_SKYPE = "skype";

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(name="chat_user_id")
    private String chatUserId;

    @Column(name="messenger")
    private String messenger;

    @Column(name="account_id")
    private int accountId;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIME)
    private LocalDateTime updatedAt;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private String status;

    public Long getId() {
        return id;
    }

    public UserMapping setId(Long id) {
        this.id = id;
        return this;
    }

    public String getChatUserId() {
        return chatUserId;
    }

    public UserMapping setChatUserId(String chatUserId) {
        this.chatUserId = chatUserId;
        return this;
    }

    public String getMessenger() {
        return messenger;
    }

    public UserMapping setMessenger(String messenger) {
        this.messenger = messenger;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public UserMapping setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserMapping setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserMapping setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UserMapping setStatus(String status) {
        this.status = status;
        return this;
    }
}