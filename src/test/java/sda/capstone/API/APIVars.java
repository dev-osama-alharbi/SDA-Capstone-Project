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

    public static Integer organizationId = null;

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
        return write(APIVarsModel.builder().userStatusId(userStatusId).build());
    }

}
