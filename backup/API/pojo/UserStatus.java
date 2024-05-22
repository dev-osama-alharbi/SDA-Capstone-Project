package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserStatus {
    private Integer id;
    private String name;
    private String description;
}
