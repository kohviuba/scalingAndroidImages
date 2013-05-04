package ee.ut.webandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DalvikCompiler {

    public static String runFile(File javaFile) {
        StringBuilder out = new StringBuilder();

        String filenameWithoutExtension = javaFile.getName().substring(0, javaFile.getName().length() - 5);
        out.append("filenameWithoutExtension: " + filenameWithoutExtension);
        String javaFileDirectoryPath = javaFile.getParent(); //without last /


        // javac GreatestCommonDivisor.java
        // dx --dex --output=GreatestCommonDivisor.jar GreatestCommonDivisor.class
        // ./rund.sh -cp GreatestCommonDivisor.jar GreatestCommonDivisor

        String javaToClassOutput = javaToClass(javaFile, javaFileDirectoryPath);
        out.append(javaToClassOutput);

        String classToJarOutput = classToJar(filenameWithoutExtension, javaFileDirectoryPath);
        out.append(classToJarOutput);

        String runJarOutput = runJar(filenameWithoutExtension, javaFileDirectoryPath);
        out.append(runJarOutput);

        return out.toString();
    }

    public static String javaToClass(File javaFile, String javaFileDirectoryPath) {
        String javaFilePath = javaFile.getAbsolutePath();

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

    private static String classToJar(String filenameWithoutExtension, String javaFileDirectoryPath) {
        //Build command
        List<String> commands = new ArrayList<String>();
        String dxPath = "/home/ubuntu/android-sdk-linux/platform-tools/dx";
        if (isLocal()) {
            dxPath = "/home/kristiina/Apps/adt-bundle-linux-x86_64/sdk/platform-tools/dx";
        }
        commands.add(dxPath);
        commands.add("--dex");
        commands.add("--output=" + filenameWithoutExtension + ".jar");
        commands.add(filenameWithoutExtension + ".class");
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

    private static String runJar(String filenameWithoutExtension, String javaFileDirectoryPath) {
        //Build command
        List<String> commands = new ArrayList<String>();
//      commands.add("/usr/bin/javac");
        //Add arguments
        String scriptPath = "/home/ubuntu/android-x86/";
//        if (isLocal()) {
//            dxPath = "/home/kristiina/Apps/adt-bundle-linux-x86_64/sdk/platform-tools/dx";
//        }
        commands.add("./rund.sh");
        commands.add("-cp");
        commands.add(javaFileDirectoryPath + "/" + filenameWithoutExtension + ".jar");
        commands.add(filenameWithoutExtension);
        System.out.println(commands);

        //Run macro on target
        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.directory(new File(scriptPath));
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

    // my laptop or aws
    private static boolean isLocal() {
        return "kristiina".equals(System.getProperty("user.name"));
    }
}
