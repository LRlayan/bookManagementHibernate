package lk.ijse.dto;

import lk.ijse.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private int id;
    private String title;
    private String publicationYear;
    private double price;
    private int authorId;
    private int percentage;

    public BookDTO(String title) {
        this.title = title;
    }

    public BookDTO(int id, int authorId, String title, String publicationYear, double price, int percentage) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.percentage = percentage;
    }

    public BookDTO(int id, String title, String publicationYear, double price, int authorId) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.authorId = authorId;
    }
}
