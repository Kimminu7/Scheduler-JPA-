package org.example.schedulerprojectv2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne 연관관계??.. 어떻게하지. 다수의 코드오류 발생
//    @JoinColumn(name = "user_id")
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Schedule(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {

    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
