package ra.thymeleaf.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateEmployeeRequest {
    // @NotNull // ko được gia tri null
    @NotBlank(message = "khong the de trong") // vừa không trống vừa khác null
    @Size(min = 4,max = 100, message = "Tên có độ dài từ 4 -> 100 kí tự")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date birthDay;
    @NotNull
    private Boolean sex;
    @NotBlank
    private String address;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Email khong dung dinh dang")
    private String email;
}
