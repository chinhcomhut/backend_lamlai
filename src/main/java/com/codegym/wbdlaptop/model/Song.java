package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSong;
    private String nameSinger;
    private String nameBand;
    private String nameCategory;
    private String avatarSong;
    private String createBy;
    private String namePlayList;
    @Lob
    private String mp3Url;
    @Lob
    private String lyrics;
    private int likeSong;
    private int listenSong;
    @ManyToOne
    User user;
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "songList")
//    private Set<Playlist> playlists = new HashSet<>();
//    @JsonIgnore
//    @ManyToMany(mappedBy = "songList",fetch = FetchType.LAZY)
//    private List<Playlist> playlists;
    public Song() {
    }

    public Song(Long id, String nameSong, String nameSinger, String nameBand, String nameCategory, String avatarSong, String createBy, String namePlayList, String mp3Url, String lyrics, int likeSong, int listenSong, User user) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.nameBand = nameBand;
        this.nameCategory = nameCategory;
        this.avatarSong = avatarSong;
        this.createBy = createBy;
        this.namePlayList = namePlayList;
        this.mp3Url = mp3Url;
        this.lyrics = lyrics;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public String getNameBand() {
        return nameBand;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getAvatarSong() {
        return avatarSong;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public String getLyrics() {
        return lyrics;
    }

    public int getLikeSong() {
        return likeSong;
    }

    public int getListenSong() {
        return listenSong;
    }

    public User getUser() {
        return user;
    }
}
