package sda.capstone.API.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {
//    private static final ObjectMapper objectMapper = new ObjectMapper()
//            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//    public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
//        try {
//            return objectMapper.readValue(jsonString, cls);
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Log the exception and rethrow it or return null
//            throw new RuntimeException("Error converting JSON to Java object", e);
//        }
//    }
//}

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            if (jsonNode.isArray()) {
                // Handle array deserialization
                return objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructArrayType(cls));
            } else {
                // Handle single object deserialization
                return objectMapper.readValue(jsonString, cls);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Log the exception and rethrow it or return null
            throw new RuntimeException("Error converting JSON to Java object", e);
        }
    }
}