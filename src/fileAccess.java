import java.io.*;
public class fileAccess {

    private static final String filepath = "Record.bat";

    public static void writeFile(myList<Employee> employees) {
        fileAccess objectIO = new fileAccess();
        objectIO.WriteObjectToFile(employees);
    }
    public void WriteObjectToFile(myList<Employee> serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("Data saved successfully to Record.bat");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static myList readFile() {
        fileAccess objectIO = new fileAccess();
        //Read object from file
        File myObj = new File("Record.bat");
        try {
            if (myObj.createNewFile()) {
                System.out.println("Save file created: " + myObj.getName());
            } else {
                return (myList) objectIO.ReadObjectFromFile(filepath);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
    public Object ReadObjectFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    }