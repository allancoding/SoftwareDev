package Projects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaW {
    public static void run(String file) throws IOException{
        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(System.getProperty("path.separator"));
        String path = "";
        for (String entry : classpathEntries) {
            if (entry.endsWith(".jar")) {
                path = entry;
            }
        }
        if (System.console() != null) {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("javaw -cp " + path + " "+file);
            BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(proc.getErrorStream()));
            while (proc.isAlive()) {
                String s = stdInput.readLine();
                String ss = stdError.readLine();
                if(s != null){
                    System.out.println(s);
                }
                if(ss != null){
                    System.out.println(ss);
                }
            }
            System.exit(0);
        }
    }
}