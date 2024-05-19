package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationService {
    private Long id;
    private String name;
    private Integer founder_id;
    private String short_name;
    private String address;
    private String country_id;
    private String phone;
    private String email;
    private String website;
    private String fax;
    private Integer status_id;
    private String currency;
    private Object created_at;
    private Integer created_by;
    private Object updated_at;
    private Integer updated_by;
}
