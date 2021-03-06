package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.Playlist;

import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.Impl.PlayListServiceImpl;
import com.codegym.wbdlaptop.service.Impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class PlayListAPI {
    @Autowired
    private PlayListServiceImpl playListService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private SongServiceImpl songService;
    @PostMapping("/playlist")
    public ResponseEntity<?> createPlayList(@Valid @RequestBody Playlist playlist){
        if(playlist.getNamePlayList()==null||playlist.getNamePlayList()==""){
            return new ResponseEntity<>(new ResponseMessage("noname"), HttpStatus.OK);
        }
        if(playlist.getAvatarPlayList()==null||playlist.getAvatarPlayList()==""){
            return new ResponseEntity<>(new ResponseMessage("noavatar"), HttpStatus.OK);
        }
        playListService.save(playlist);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @GetMapping("/play-list-by-user")
    public ResponseEntity<?> playListByUser(@PageableDefault(sort = "namePlayList", direction = Sort.Direction.ASC)Pageable pageable){
        User user = userDetailsService.getCurrentUser();
        Page<Playlist> playlistPage = playListService.findAllByUserId(user.getId(),pageable);
        if(playlistPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playlistPage, HttpStatus.OK);
    }
    @GetMapping("/playlist/{id}")
    public ResponseEntity<?> playListById(@PathVariable Long id){
        Optional<Playlist> playlist = playListService.findById(id);
        if(!playlist.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
    @PutMapping("/playlist/{id}")
    public ResponseEntity<?> updatePlayListById(@PathVariable Long id, @Valid @RequestBody Playlist playlist){
        Optional<Playlist> playlist1 = playListService.findById(id);
        if(!playlist1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(playlist.getNamePlayList()==null||playlist.getNamePlayList()==""){
            return new ResponseEntity<>(new ResponseMessage("noname"), HttpStatus.OK);
        }
        playlist1.get().setNamePlayList(playlist.getNamePlayList());
        playlist1.get().setAvatarPlayList(playlist.getAvatarPlayList());
        playListService.save(playlist1.get());
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
//    @PutMapping("/playlist/{id}")
//    public ResponseEntity<?> updatePlayList(@PathVariable Long id,@Valid @RequestBody Playlist playlist){
//        Optional<Playlist> playlist = playListService.findById(id);
//        Optional<Song> song1 = songService.findById(song.getId());
//        playlist.get().setSongList((Set<Song>) song1.get());
////        playlist.setSongList(playlist.getSongList());
//        playListService.save(playlist.get());
//        return new ResponseEntity<>(playlist,HttpStatus.CREATED);
//    }

}
