package com.acciojob.library_system.Models;

import com.acciojob.library_system.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Integer bookId;

    private String bookName;

    private Integer noOfPages;

    private String authorName;

@Enumerated(value = EnumType.STRING)
    private Genre genre;

}
