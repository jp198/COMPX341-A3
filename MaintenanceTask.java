import java.io.*;
import java.util.*;

public class MaintenanceTask {

    public static void listFiles(String path, List<String> filesList)

    {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files)
        {   
            if (file.isFile() && file.getName().endsWith("config.ts"))
            {
                //System.out.println(file.getName());
                filesList.add(file.getName());
            }
            else if (file.isDirectory())
            {
                listFiles(file.getAbsolutePath(), filesList);
            }   
        }
        //return listOfFiles;
    }

public static void main(String [] args) throws IOException {
    List<String> filesList = new ArrayList<>();
    listFiles("/Users/jaschapenaredondo/Desktop/341-22A/COMPX341-A3/assets/src", filesList);
    System.out.println(filesList);

    for (String f : filesList) {
        //open each file and add comment
        FileWriter fw = null; 
        BufferedWriter bw = null; 
        PrintWriter pw = null; 
        try { 
            fw = new FileWriter(f, true); 
            bw = new BufferedWriter(fw); 
            pw = new PrintWriter(bw); 
            
            pw.print("//Jascha Penaredondo 1538077");
            
            System.out.println("Data Successfully appended into file"); 
            pw.flush(); 
        } finally { 
            try { 
                pw.close(); bw.close(); fw.close(); 
            } catch (IOException io) {// can't do anything 
            } 
        }    
    }
}

    // public void findFile(String name,File dir)
    // {
    //     File[] list = dir.listFiles();
    //     if(list!=null)
    //     for (File fil : list)
    //     {
    //         if (fil.isDirectory())
    //         {
    //             findFile(name,fil);
    //         }
    //         else if (name.equalsIgnoreCase(fil.getName()))
    //         {
    //             System.out.println("Filename: " + name);
    //             System.out.println(fil.getParentFile());
    //         }
    //     }
    // }
    // public static void main(String[] args) 
    // {
    //     FilenameFilter textFilter = new FilenameFilter() {
    //         @Override
    //         public boolean accept(File dir, String name) {
    //             return name.toLowerCase().endsWith(".ts");
    //         }
    //     };

    //     MaintenanceTask ff = new MaintenanceTask();
    //     // Scanner scan = new Scanner(System.in);
    //     // System.out.println("Enter the file to be searched.. " );
    //     // String name = scan.next();
    //     // System.out.println("Enter the directory where to search ");
    //     // String directory = scan.next();

    //     String directory = "assets";
    //     ff.findFile(name,new File(directory));
    //     //scan.close();

    // }
        // public static void main(String[] args) {
        //     // Creates an array in which we will store the names of files and directories
        //     String[] pathnames;

        //     // Creates a new File instance by converting the given pathname string
        //     // into an abstract pathname
        //     File f = new File("/Users/jaschapenaredondo/Desktop/341-22A/COMPX341-A3/assets/");

        //     // This filter will only include files ending with .py
        //     FilenameFilter filter = new FilenameFilter() {
        //         @Override
        //         public boolean accept(File f, String name) {
        //             return name.endsWith(".ts");
        //         }
        //     };
        //     // Populates the array with names of files and directories
        //     pathnames = f.list(filter);

        //     // For each pathname in the pathnames array
        //     for (String pathname : pathnames) {
        //         // Print the names of files and directories
        //         System.out.println(pathname);
        //     }
        // }
}


// import java.io.*;
// import java.util.*;
// class FindFile 
// {
//     public void findFile(String name,File file)
//     {
//         FilenameFilter textFilter = new FilenameFilter() {
//             public boolean accept(File dir, String name) {
//                 return name.toLowerCase().endsWith(".ts");
//             }
//         };

//         File[] list = file.listFiles(textFilter);
//         if(list!=null)
//         for (File fil : list)
//         {
//             if (fil.isDirectory())
//             {
//                 findFile(name,fil);
//             }
//             else if (name.equalsIgnoreCase(fil.getName()))
//             {
//                 System.out.println("Filename: " + name);
//                 System.out.println(fil.getParentFile());
//             }
//         }
//     }
//     public static void main(String[] args) 
//     {
//         FindFile ff = new FindFile();
//         // Scanner scan = new Scanner(System.in);
//         // System.out.println("Enter the file to be searched.. " );
//         // String name = scan.next();
//         // System.out.println("Enter the directory where to search ");
//         // String directory = scan.next();

//         String name = "config.ts";
//         String directory = "assets";
//         ff.findFile(name,new File(directory));
//         //scan.close();

//     }
// }