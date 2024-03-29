package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String publicationYear;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(int id, String title, String publicationYear, double price) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }
}
