public class Functionality {
    public static int idGenerator(myList employees, int Rank){
        String id = "21"+""+ Rank +""+ employees.size();
        return Integer.parseInt(id);
    }

}