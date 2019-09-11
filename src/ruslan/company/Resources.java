package ruslan.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

public class Resources {
    private static Map<String, Image> resources = new HashMap<String, Image>();

    private static boolean isImage(String expr) {
        return expr.equals("jpg") ||
       		expr.equals("jpeg") ||
        	expr.equals("png") ||
        	expr.equals("gif") ||
        	expr.equals("bmp");
    }

    public static void load(String folderPath) throws IOException {
        java.net.URL url = Resources.class.getResource(folderPath);
        File folder = new File(url.getFile().substring(1).replace("%20", " "));

        for (final File file : folder.listFiles()) {
            String fileName = file.getName();
            String split[] = fileName.split("[.]");
            String accessName = "";
            for (int i = 0; i < split.length - 1; i++) {
            	accessName += split[i];
            }
            
            String expr = split[split.length - 1];
            if (isImage(expr)) {
            	resources.put(accessName, ImageIO.read(GameWindow.class.getResourceAsStream(folderPath + fileName)));
            }
        }
    }

    public static Image getSprite(String name) {
        return resources.get(name);
    }
}
