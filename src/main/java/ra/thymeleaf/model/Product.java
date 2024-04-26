package ra.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private BigDecimal price;
    private String imageUrl;
    private String description;
    private Date createdDate;
    private boolean status;
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
}
