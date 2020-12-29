package com.practice.ig.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "created_at")
    private Date createdAt;

    public Photos(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Photos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", users=" + users +
                ", createdAt=" + createdAt +
                '}';
    }
}
