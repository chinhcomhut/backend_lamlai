package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePlayList;
    private String avatarPlayList;
    private String createBy;
    private String nameAlbum;
    private String nameSinger;
    private String nameCategory;
    private String nameBand;

    @ManyToOne
    User user;
//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "player_song",
//    joinColumns = @JoinColumn(name = "playlist_id"),
//    inverseJoinColumns = @JoinColumn(name = "song_id"))
//    private List<Song> songList;
//    @JsonIgnore
////    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//De the nay thi hien duoc page play list//
//    @ManyToMany (fetch = FetchType.LAZY)
//    @JoinTable(name = "player_song",
//    joinColumns = @JoinColumn(name = "playlist_id"),
//    inverseJoinColumns = @JoinColumn(name = "song_id"))
//    private Set<Song> songList = new HashSet<>();
//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "player_song",
//    joinColumns = @JoinColumn(name = "playlist_id"),
//    inverseJoinColumns = @JoinColumn(name = "song_id"))
//    private List<Song> songList = new ArrayList<>();
//    public Playlist() {
//    }

    public Playlist() {
    }

    public Playlist(Long id, String namePlayList, String avatarPlayList, String createBy, String nameAlbum, String nameSinger, String nameCategory, String nameBand, User user) {
        this.id = id;
        this.namePlayList = namePlayList;
        this.avatarPlayList = avatarPlayList;
        this.createBy = createBy;
        this.nameAlbum = nameAlbum;
        this.nameSinger = nameSinger;
        this.nameCategory = nameCategory;
        this.nameBand = nameBand;
        this.user = user;
//        this.songList = songList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public void setNamePlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public String getAvatarPlayList() {
        return avatarPlayList;
    }

    public void setAvatarPlayList(String avatarPlayList) {
        this.avatarPlayList = avatarPlayList;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Song> getSongList() {
//        return songList;
//    }
//
//    public void setSongList(List<Song> songList) {
//        this.songList = songList;
//    }
}
