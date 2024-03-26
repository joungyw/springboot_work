package com.mh.fileex.file;


import jakarta.persistence.*;


@Entity
@Table(name = "FILE")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String name;
}
