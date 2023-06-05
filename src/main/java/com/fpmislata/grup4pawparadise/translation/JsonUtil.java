package com.fpmislata.grup4pawparadise.translation;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

public class JsonUtil {
    public JSONObject readJsonData(String language) {

        JSONObject jsonData = null;
        String filePath = null;

        if (language.equals("es")) {
            filePath = "static/json/translate_es.json";
        } else if (language.equals("en")) {
            filePath = "static/json/translate_en.json";
        }

        try {
            ClassPathResource staticDataResource = new ClassPathResource(filePath);
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
            jsonData = new JSONObject(staticDataString);

        } catch (Exception e) {

        }
        return jsonData;
    }
}
