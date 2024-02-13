package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;
import lk.ijse.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorTM {
    private int id;
    private String name;
    private JFXButton update;
    private JFXButton delete;
}
