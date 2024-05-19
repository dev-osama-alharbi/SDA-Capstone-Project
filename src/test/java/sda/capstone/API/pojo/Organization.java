package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization {
    private Long id ;
    private String name;
    private Integer founder_id;
    private String email;
    private String created_at;
    private String updated_at;
}
