package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIVarsModel {
    public Integer userStatusId = null;

    public Integer OrgStatusId = null;
    private Integer newUserId  = null ;
    public Long organizationId = null;
    public Integer applicationId = null;
    public Integer userGroupID = null;
    public String GSessionId = null;
    public String Email = null;

}
