package com.tema2.tema2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="nr_chairs", nullable = false)
    private Integer nrOfChairs;

    @OneToMany(mappedBy = "room")
    private Set<Track> tracks;

    public Room(String name, Integer nrOfChairs) {
        this.name = name;
        this.nrOfChairs = nrOfChairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getNrOfChairs() {
        return nrOfChairs;
    }

    public void setNrOfChairs(Integer nrOfChairs) {
        this.nrOfChairs = nrOfChairs;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public void update(Room entity) {
        this.name = entity.getName();
        this.tracks = entity.getTracks();
    }
}
