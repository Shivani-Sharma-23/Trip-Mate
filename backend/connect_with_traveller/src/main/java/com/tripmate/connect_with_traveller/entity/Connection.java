package com.tripmate.connect_with_traveller.entity;

@Entity
@Table(
        name = "connection",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"sender_user_id", "receiver_user_id"})
        }
)
@Getter
@Setter
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_user_id", nullable = false)
    private Long senderUserId;

    @Column(name = "receiver_user_id", nullable = false)
    private Long receiverUserId;

    @Enumerated(EnumType.STRING)
    private Status acceptStatus;

    private LocalDateTime createdAt;

    public enum Status {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}
