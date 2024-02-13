package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookTM {
    private int bookId;
    private String title;
    private String publishedYear;
    private double price;
    private int authorId;
    private JFXButton update;
    private JFXButton delete;
}
