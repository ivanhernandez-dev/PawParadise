package com.fpmislata.grup4pawparadise.translation;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

public class JsonUtil {
    public JSONObject readJsonData(String language) {

        JSONObject jsonData;
        String filePath;

        if (language.equals("en")) {
            filePath = "static/json/translation_en.json";
        } else {
            filePath = "static/json/translation_es.json";
        }

        try {
            ClassPathResource staticDataResource = new ClassPathResource(filePath);
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
            jsonData = new JSONObject(staticDataString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }
}
