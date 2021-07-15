package com.pthon.naumen.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Notes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Lob
    private String content;

    private Date time;

    public Notes(String title, String content, Date time) {
        this.title = title;
        this.content = content;
        this.time = time;
    }



    public Notes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
