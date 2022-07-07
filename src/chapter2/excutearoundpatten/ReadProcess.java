package chapter2.excutearoundpatten;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadProcess {

    public String processFile()  throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }
}
