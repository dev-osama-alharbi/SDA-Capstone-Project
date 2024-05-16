package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0034 extends ApiBase {
    private Permissions[] permissions = {Permissions
            .builder().
            id(0).
            resource("book").
            action("read, write etc.").
            app_id(123).
            build()};

    private User_groups[] user_groups = {User_groups
            .builder().
            id(0).
            name("Sales Department").
            short_name("Sales Dept.").
            group_type_id(0).
            pic_id(12345).
            organization_id(12345).
            is_head(false).
            build()};

    private Roles[] roles = {Roles
            .builder().
            id(0).
            name("MANAGER").
            app_id(0).
            description("string").
            permissions(permissions).
            build()};

    private Users[] users = {Users
            .builder().
            id(0).
            name("John").
            lastname("Doe").
            username("john").
            email("john@example.com").
            is_email_verified(true).
            phone("+1 123 123 4567").
            address("string").
            country_id("US").
            pic_id(12345).
            preferences(null).
            status_id(12345).
            user_groups(user_groups).
            created_at("2024-05-15T07:14:42.823Z").
            created_by(0).
            updated_at("2024-05-15T07:14:42.823Z").
            updated_by(0).
            build()};

    private UserGroupService userGroupService = UserGroupService
            .builder().
            id(0).
            name("Sales Department").
            short_name("Sales Dept.").
            description("Department of Acme Corp, responsible from all sales operations in US").
            group_type_id(0).
            pic_id(12345).
            organization_id(12345L).
            users(users).
            roles(roles).
            build();

    @Test
    public void UpdateExistingUserGroup() {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userGroupService)
                .put("/a3m/auth/api/{first}");
        response.prettyPrint();
    }
}
