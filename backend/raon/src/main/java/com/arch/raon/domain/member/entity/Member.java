package com.arch.raon.domain.member.entity;

import com.arch.raon.global.util.enums.Gender;
import com.arch.raon.global.util.enums.School;
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
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SQLDelete(sql = "UPDATE member SET deleted_at = now() WHERE member_id = ?")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "nickname", length = 10, nullable = false)
    private String nickname;

    @Column(name = "profile_url", length = 255, nullable = false)
    private String profileUrl;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "school")
    @Enumerated(EnumType.STRING)
    private School school;

    @Column(name = "year_of_birth", nullable = false)
    private Integer yearOfBirth;

    @ColumnDefault("0")
    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    @ColumnDefault("false")
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public Member(Long id, String email, String nickname, String profileUrl, Gender gender, School school, Integer yearOfBirth, Integer mileage, Boolean isDeleted) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.gender = gender;
        this.school = school;
        this.yearOfBirth = yearOfBirth;
        this.mileage = mileage;
        this.isDeleted = isDeleted;
    }
}
