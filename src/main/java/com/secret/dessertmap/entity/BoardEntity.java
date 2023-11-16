package com.secret.dessertmap.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @Column
    private int shopId;

    @Column
    private String boardTitle;

    @Column
    private String boardContent;

}
