package springtutorial.northwind.entities.dtos;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;
}
