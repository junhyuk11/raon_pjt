package com.arch.raon.domain.dictionary.entity;

import com.arch.raon.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "dictionary_score")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SQLDelete(sql = "UPDATE dictionary_score SET deleted_at = now() WHERE dictionary_score_id = ?")
public class DictionaryScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "score", nullable = false)
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    @Builder
    public DictionaryScore(Long id, Integer score, Member member, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.score = score;
        this.member = member;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
