package com.verdantsun;
import java.io.*;

public class MapLoader {

    public static void loadMap(Field field, String filePath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            String content = json.toString();

            String mapPart = content.split("\"map\":\\[")[1];
            mapPart = mapPart.substring(0, mapPart.lastIndexOf("]"));

            String[] rows = mapPart.split("\\],\\[");

            for (int i = 0; i < rows.length; i++) {

                String cleanRow = rows[i].replace("[", "").replace("]", "");
                String[] cells = cleanRow.split(",");

                for (int j = 0; j < cells.length; j++) {

                    String symbol = cells[j].replace("\"", "").trim();
                    String soil = "";

                    if (symbol.equals("l")) soil = "loam";
                    if (symbol.equals("s")) soil = "sand";
                    if (symbol.equals("g")) soil = "gravel";

                    field.getTile(i, j).setSoilType(soil);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading map.");
        }
    }
}