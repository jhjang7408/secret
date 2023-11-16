package com.secret.dessertmap.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="member")
public class MemberEntity {

    @Id
    private String memberId;

    @Column
    private String memberPassword;

    @Column
    private int memberPhoneNum;

    @Column
    private String memberEmail;








}
