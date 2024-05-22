package sda.capstone.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import sda.capstone.API.pojo.APIVarsModel;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIVars {
//    public static int organizationStatusId = 0;
//    public static Integer organizationId = null;
//    public static int userStatusId = 0;
//    public  static  int UserGroupID = 0;


    public static Integer newUserId = null;

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static APIVarsModel read(){
        try {
            return ObjectMapperUtils
                    .convertJsonToJava(
                            new String(Files.readAllBytes(Paths.get("VARs.txt")))
                            ,APIVarsModel.class
                    );
        } catch (IOException e) {
            return new APIVarsModel();
        }
    }
    private static boolean write(APIVarsModel apiVarsModel){
        try {
            objectMapper.writeValue(new File("VARs.txt"), apiVarsModel);
        } catch (IOException e) {
        }
        return false;
    }
    public static boolean writeUserStatusId(Integer userStatusId){
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setUserStatusId(userStatusId);
        return write(apiVarsModel);
    }
  
    public static boolean writeOrgStatusId(Integer organizationStatusId){
//        return write(APIVarsModel.builder().OrgStatusId(organizationStatusId).build());
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setOrgStatusId(organizationStatusId);
        return write(apiVarsModel);
    }
      
    public static boolean writeOrganizationId(Long organizationId){
//          return write(APIVarsModel.builder().organizationId(organizationId).build());
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setOrganizationId(organizationId);
        return write(apiVarsModel);
    }
  
    public static boolean writeApplicationId(Integer applicationId){
//          return write(APIVarsModel.builder().applicationId(applicationId).build());
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setApplicationId(applicationId);
        return write(apiVarsModel);
    }

    public static boolean writeNewUserId(Integer newUserId){
//        return write(APIVarsModel.builder().newUserId(newUserId).build());
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setNewUserId(newUserId);
        return write(apiVarsModel);
    }

    public static boolean writeGSessionId(String GSessionId){
//        return write(APIVarsModel.builder().GSessionId(GSessionId).build());
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setGSessionId(GSessionId);
        return write(apiVarsModel);
    }

    public static boolean writeEmail(String email) {
        APIVarsModel apiVarsModel = read();
        apiVarsModel.setEmail(email);
        return write(apiVarsModel);
    }
}
