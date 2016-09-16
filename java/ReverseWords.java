import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class ReverseWords {

   public static void main(String[] args) {
        //System.out.println("here i am");

        if (args.length != 1) {
            System.out.println("Usage java ReverseWords <file-name>");
        } 
        
	String[] lines = readLines(args[0]);

        //Arrays.stream(lines).forEach(line -> System.out.println(line)); 

        //System.out.println("===========================");
        
        int count=0;
        //Arrays.stream(lines).forEach(line -> 
        //                              {
        //                                 System.out.print(String.format("Case #%s: ", ++count));
        //                                 reverseLine(line);
        //                              });

        for (int i = 0; i < lines.length; i++) {
           System.out.print(String.format("Case #%s: ", ++count));
           reverseLine(lines[i]);
        }      
   }

   private static void reverseLine(String line) {
        //find word count
        int wordCount = 1;
        for (int i = 0; i < line.length();  i++) { 
           char c = line.charAt(i);
           if (c == ' ')
              wordCount++;
        }
   
        //build word array
        String[] words = new String[wordCount];
        int index = 0;
        int prev = 0;
        for (int i = 0; i < line.length(); i++) {
           char c = line.charAt(i);
           if (c == ' ') {
              words[index++] = line.substring(prev, i);
              prev = i+1;
           }
        } 
        words[wordCount-1] = line.substring(prev, line.length());

        for (int i = 0, j = wordCount-1; i < j; i++, j--) {
           String tem = words[i];
           words[i] = words[j];
           words[j] = tem;
        }
 
        for(int i = 0; i<wordCount; i++) {
           System.out.print(words[i] + " ");
        }
        System.out.println("");       
   }

   private static String[] readLines(String fileName) {
        int numLine = 0;
        String[] lines = null;

        try (Scanner scanner = new Scanner(new File(fileName))) {
                if (scanner.hasNext()) {
                    numLine = Integer.parseInt(scanner.nextLine());
                    lines = new String[numLine];
                }

                int i=0;
                while (scanner.hasNext()) {
                     lines[i++] = scanner.nextLine();
                }
                return lines;       
        } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
        }
        return null;     
   }
}
