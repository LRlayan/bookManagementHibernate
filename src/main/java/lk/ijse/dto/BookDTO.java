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

    public BookDTO(String title) {
        this.title = title;
    }

}
