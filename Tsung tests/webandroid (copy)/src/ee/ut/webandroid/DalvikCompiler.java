package ee.ut.webandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DalvikCompiler {

    public static String runFile(File javaFile) {
        String javaFilePath = javaFile.getAbsolutePath();
        String javaFileDirectoryPath = javaFile.getParent(); //without last /

        //Build command
        List<String> commands = new ArrayList<String>();
        commands.add("/usr/bin/javac");
        //Add arguments
        commands.add(javaFilePath);
        System.out.println(commands);

        //Run macro on target
        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.directory(new File(javaFileDirectoryPath));
        pb.redirectErrorStream(true);
        Process process = null;
        try {
            process = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Read output
        StringBuilder out = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null, previous = null;
        try {
            while ((line = br.readLine()) != null)
                if (!line.equals(previous)) {
                    previous = line;
                    out.append(line).append('\n');
                    System.out.println(line);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }
}
