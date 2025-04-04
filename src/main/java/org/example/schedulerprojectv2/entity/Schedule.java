package org.example.schedulerprojectv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne // 연관관계
    @JoinColumn(name = "user_id")
    private Member member;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Schedule(String title, String contents, Member member) {
        this.title = title;
        this.contents = contents;
        this.member = member;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
