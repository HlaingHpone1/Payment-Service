package org.talent.talentpay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tnx {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime tnxTime;
    private long amount;
    private String note;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserAccount receiver;
}
