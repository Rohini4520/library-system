package com.acciojob.library_system.Models;

import com.acciojob.library_system.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private Integer noOfBooksIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

//this has to be written in child class
    @JoinColumn(referencedColumnName = "emailId") //  by default it adds the PK, incase you add any other column
    @OneToOne  //Mapping between entries

    private Student student; //which entity you have connected
}
