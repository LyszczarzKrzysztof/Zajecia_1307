package files.pliki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilesMain {


    public static void main(String[] args) throws IOException {

//        filesPrintingNames();

//        System.out.println("Podaj nazwe pliku do odczytania: ");
        Scanner entry = new Scanner(System.in);
//        String fileName = entry.nextLine();
//        filePrintingContentLineByLine(fileName);


//        filesPrintingNames();

        System.out.println("Podaj slowo do odszukania: ");
        String textToFind = entry.nextLine();


     filesList().forEach(f -> {
         try {
             findTextInFiles(textToFind,String.valueOf(f.getFileName()));
         } catch (IOException e) {
             e.printStackTrace();
         }
     });



    }

    private static void findTextInFiles(String textToFind, String fileName) throws IOException {
        String fileNameConc=fileName;
        Path path = Paths.get("files\\"+fileNameConc);
        String text = new String(Files.readAllBytes(path));

        if(text.contains(textToFind)){
            System.out.println("Znaleziono tekst: "+textToFind+" w pliku: "+fileName);
        }
    }


    public static void filesPrintingNames() throws IOException {
        Path path = Paths.get("files");
        Files.list(path).forEach(f -> System.out.println(f.getFileName()));
    }

    public static Stream<Path> filesList() throws IOException{
        Path path = Paths.get("files");
        Stream<Path> list = Files.list(path);
        return list;
    }

    public static void filePrintingContentLineByLine(String fileName) throws IOException {
        String fileNameConc=fileName+".txt";
        Path path = Paths.get("files\\"+fileNameConc);
        Files.lines(path).forEach(line -> System.out.println(line));
    }
    

}
