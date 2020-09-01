package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayService {
    Page<Playlist> findAllByUserId(Long userId, Pageable pageable);
    Page<Playlist> findByNameAlbumContaining(String nameAlbum, Pageable pageable);
    Playlist save(Playlist playlist);
    void delete(Long id);
    Optional<Playlist> findById(Long id);
    Page<Playlist> findAll(Pageable pageable);
}
