package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataV2 {
//    String strJson = """
//                {
//                    "app_id": 2,
//                    "organization_id": 1716287440101561,
//                    "email": "",
//                    "subscription_id": "12e01972-a928-43f9-a20c-d8df7ff926e7",
//                    "default_role_id": 5
//                }""";
    private Integer app_id;
    private Long organization_id;
    private String email;
    private String subscription_id;
    private Integer default_role_id;
}
