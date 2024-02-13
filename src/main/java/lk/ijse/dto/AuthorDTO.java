package lk.ijse.dto;

import lk.ijse.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private int id;
    private String name;
    private String country;
    private List<Book> bookList;

    public AuthorDTO(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
