package ra.thymeleaf.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProduct {
    private  String name;
    private BigDecimal price;
    private MultipartFile file;
    private String description;
    private Integer categoryId;
}
