package sda.capstone.API.pojo;

import io.restassured.response.ValidatableResponseLogSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembershipType {
    private int id;
    private String name;
    private String short_name;
    private boolean is_enabled;
    private boolean is_individual_plan;
    private int default_role_id;
    private int subscription_type_id;
    private int app_id;
    private Object created_at;
    private Object updated_at;


}
