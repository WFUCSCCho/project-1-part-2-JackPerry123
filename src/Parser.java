import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Parser {

    //Create a BST tree of Integer type
    private BST<SPY> mybst = new BST<>();
    private BST<SPY> dataSet = new BST<>();

    public Parser(String filename, String csv) throws FileNotFoundException {
        process(new File(filename), new File(csv));
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input, File csv) throws FileNotFoundException {

        FileInputStream csvStream = new FileInputStream(csv);
        Scanner csvScan = new Scanner(csvStream);

        String line = csvScan.nextLine();

        while(csvScan.hasNext()){

            line = csvScan.nextLine();
            line = line.trim();

            if(line.isEmpty()) continue;

            String [] p = csvSplit(line);

            if (p.length != 16 || oneElementIsEmpty(p))
                continue;

            SPY s = new SPY(p[0],
                    p[1],
                    p[2],
                    p[3],
                    p[4],
                    p[5],
                    Double.parseDouble(p[6]),
                    Double.parseDouble(p[7]),
                    Double.parseDouble(p[8]),
                    Double.parseDouble(p[9]),
                    p[10],
                    p[11],
                    p[12],
                    p[13],
                    p[14],
                    Double.parseDouble(p[15]));

            dataSet.insert(s);


        }

        csvScan.close();

        FileInputStream Stream = new FileInputStream(input);
        Scanner sc = new Scanner(Stream);



        while(sc.hasNext()){

            line = sc.nextLine();
            line = line.trim();

            if(line.isEmpty()) continue;

            int firstSpaceIndex = line.indexOf(" ");

            if(firstSpaceIndex == -1){
                operate_BST(line.split("\\s+"));
            } else {

                String command = line.substring(0, firstSpaceIndex);
                String vals = line.substring(firstSpaceIndex + 1);

                vals = vals.trim();

                String[] p = csvSplit(vals);


                String[] combined = new String[p.length + 1];

                combined[0] = command;
                int counter = 1;
                for (String e : p) {
                    combined[counter] = e;
                    counter++;
                }

                //call operate_BST method;
                operate_BST(combined);
            }

        }

        sc.close();

    }

    public boolean oneElementIsEmpty(String[] p){
        for (String e: p) {
            if (e.isEmpty())
                return true;
        }
        return false;
    }

    public String[] csvSplit(String line){
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }

    public SPY createObj(String[] p){
        if (p.length != 17 || oneElementIsEmpty(p)) {
            System.out.println(Arrays.toString(p));
            writeToFile("invalid input", "./result.txt");
            return null;
        }
        //create an object
        SPY obj = new SPY(p[1],
                p[2],
                p[3],
                p[4],
                p[5],
                p[6],
                Double.parseDouble(p[7]),
                Double.parseDouble(p[8]),
                Double.parseDouble(p[9]),
                Double.parseDouble(p[10]),
                p[11],
                p[12],
                p[13],
                p[14],
                p[15],
                Double.parseDouble(p[16])
        );
        return obj;
    }

    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST
    public void operate_BST(String[] p) {
        SPY obj;
        switch (p[0]) {
            case "insert":
                obj = new SPY("a",
                        p[1],
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        "a",
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0);

                Node<SPY> n1 = dataSet.searchRecursive(dataSet.getRoot(), obj);
                mybst.insert(n1.getData());
                writeToFile("insert " + n1.getData().toString(),"./result.txt" );
                break;



            case "insertNewElement":
                obj = createObj(p);
                mybst.insert(obj);
                writeToFile("insert " + obj.toString(),"./result.txt" );
                break;
            // add your cases here
            // call writeToFile
            case "remove":
                obj = new SPY("a",
                        p[1],
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        "a",
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0);
                Node<SPY> n2 = mybst.searchRecursive(mybst.getRoot(), obj);
                if(n2.getData() == null)
                    writeToFile("remove failed" ,"./result.txt" );
                else
                    writeToFile("removed " + n2.getData().toString(),"./result.txt" );

                mybst.remove(obj);
                break;

            case "search":
                obj = new SPY("a",
                        p[1],
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        "a",
                        "a",
                        "a",
                        "a",
                        "a",
                        0.0);
                Node<SPY> node = mybst.searchRecursive(mybst.getRoot(), obj);
                if(node == null)
                    writeToFile("Search failed","./result.txt" );
                else
                    writeToFile("found " + node.getData().toString(),"./result.txt" );
                break;

            case "print":
                String s = "";
                for(SPY v : mybst)
                    s = s + v.toString() + " ";

                writeToFile(s, "./result.txt");
                break;

            case "isEmpty":
                if(mybst.isEmpty())
                    writeToFile("Empty","./result.txt" );
                else
                    writeToFile("Not Empty","./result.txt" );
                break;
            // default case for Invalid Command
            default:
                writeToFile("Invalid Command", "./result.txt");
                break;
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            writer.newLine();
        } catch(IOException e){
            System.out.println("error " + e);
        }

    }

}
