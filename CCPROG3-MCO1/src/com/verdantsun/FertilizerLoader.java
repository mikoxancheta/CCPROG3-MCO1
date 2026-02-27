package com.verdantsun;
import java.io.*;
import java.util.HashMap;

public class FertilizerLoader {

    public static HashMap<String, Fertilizer> loadFertilizers(String filePath) {

        HashMap<String, Fertilizer> fertilizers = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            String content = json.toString();
            content = content.substring(1, content.length() - 1);

            String[] entries = content.split("},");

            for (String entry : entries) {

                String[] keySplit = entry.split(":\\{");
                String key = keySplit[0].replace("\"", "").trim();
                String values = keySplit[1].replace("}", "");

                String[] attributes = values.split(",");

                String name = "";
                int price = 0;
                int days = 0;

                for (String attr : attributes) {

                    String[] pair = attr.split(":");
                    String attrKey = pair[0].replace("\"", "").trim();
                    String attrValue = pair[1].replace("\"", "").trim();

                    switch (attrKey) {
                        case "name": name = attrValue; break;
                        case "price": price = Integer.parseInt(attrValue); break;
                        case "days": days = Integer.parseInt(attrValue); break;
                    }
                }

                fertilizers.put(key, new Fertilizer(name, price, days));
            }

        } catch (IOException e) {
            System.out.println("Error loading fertilizers file.");
        }

        return fertilizers;
    }
}
