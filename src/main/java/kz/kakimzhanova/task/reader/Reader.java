package kz.kakimzhanova.task.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String readText(String fileName) throws IOException {
        BufferedReader br;
        StringBuilder stringBuilder = new StringBuilder();
        String tmp;
        br = new BufferedReader(new FileReader(new File("src/main/resources/" + fileName).getAbsolutePath()));
        try {
            while ((tmp = br.readLine()) != null ){
                stringBuilder.append(tmp);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }finally {
            br.close();
        }
    }
}
