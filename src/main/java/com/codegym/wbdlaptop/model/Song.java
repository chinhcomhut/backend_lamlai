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

    @ManyToOne
    @JoinTable(name = "song_player",
    joinColumns = @JoinColumn(name = "song_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    Playlist playlist;
    public Song() {
    }

    public Song(Long id, String nameSong, String nameSinger, String nameBand, String nameCategory, String avatarSong, String createBy, String namePlayList, String mp3Url, String lyrics, int likeSong, int listenSong, User user, Playlist playlist) {
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
        this.playlist = playlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getAvatarSong() {
        return avatarSong;
    }

    public void setAvatarSong(String avatarSong) {
        this.avatarSong = avatarSong;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public void setNamePlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(int likeSong) {
        this.likeSong = likeSong;
    }

    public int getListenSong() {
        return listenSong;
    }

    public void setListenSong(int listenSong) {
        this.listenSong = listenSong;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
