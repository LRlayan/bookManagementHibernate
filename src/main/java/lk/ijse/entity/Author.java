package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL )
    private List<Book> bookList;

    public Author(int id , String name , String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
