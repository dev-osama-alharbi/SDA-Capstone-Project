package sda.capstone.API.pojo;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCountries {
    private Integer id;
    private String name;
    private String description;
}
