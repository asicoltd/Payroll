
import java.io.Serializable;
import java.util.Scanner;

public class Record implements Serializable {
    myList<Employee> employees = new myList<>();
    Record() {
            if (fileAccess.readFile() != null) {
                employees = fileAccess.readFile();
            }
    }
    Scanner sc = new Scanner(System.in);
    public void add(){
        Scanner eS = new Scanner(System.in);
        Employee e = new Employee();
        System.out.println("Name:");
        e.setName(eS.nextLine());
        System.out.println("Phone No:");
        e.setPhoneNumber(eS.nextInt());
        eS.nextLine();
        System.out.println("Email:");
        e.setEmail(eS.nextLine());
        System.out.println("Rank:\n1.First Class\n2.Second Class\n3.Third Class");
        e.setRank(eS.nextInt());
        System.out.println("ID for "+e.getName()+" generated as "+ Functionality.idGenerator(employees,e.getRank()));
        e.setId(Functionality.idGenerator(employees,e.getRank()));
        for ( int i = 0 ; i < employees.size() ; i++ ){
            if( e.getId() == employees.get(i).getId() ){
                e.setId(e.getId()+1);
            }
        }

        System.out.println("Is paid:\n1.Yes\n2.No");
        while(true) {
            int status = eS.nextInt();
            if (status == 1) {
                e.setPaidStatus(true);
                break;
            } else if (status == 2) {
                e.setPaidStatus(false);
                e.setSalary(0.0);
                break;
            }
            else{
                System.out.println("Select between Yes and No");
        }
    }
        System.out.println("Bonus:");
        e.setBonus(eS.nextDouble());
        employees.add(e);
    }

    public void viewAll(){
        for( int i = 0 ; i < employees.size() ; i++ ){
            System.out.print((i+1)+".Name :"+employees.get(i).getName()+" ( ID:"+employees.get(i).getId()+") >>");
            System.out.println((employees.get(i).isPaidStatus()) ? "Paid":"Unpaid");
        }
    }
    public Employee find(int id){
        while (true) {
            int i;
            for (i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    break;
                }
            }
            if (employees.get(i) != null)
                return employees.get(i);
            else{
                System.out.println("Id not valid\nTry again");
                id = sc.nextInt();
            }
        }

    }
    public void edit(int id){
        while (true) {
                System.out.println("Change:\n1.Name\n2.Phone No\n3.Email\n4.Rank\n5.Exit");
                int option1 = sc.nextInt();
                if (option1 == 1) {
                    System.out.println("Name:");
                    sc.nextLine();
                    find(id).setName(sc.nextLine());
                } else if (option1 == 2) {
                    System.out.println("Phone No:");
                    find(id).setPhoneNumber(sc.nextInt());
                } else if (option1 == 3) {
                    System.out.println("Email:");
                    sc.nextLine();
                    find(id).setEmail(sc.nextLine());
                } else if (option1 == 4) {
                    System.out.println("Rank:\n1.First Class\n2.Second Class\n3.Third Class");
                    find(id).setRank(sc.nextInt());
                    if(find(id).getRank() == 1 ){
                        find(id).setSalary(400000);
                    }
                    else if(find(id).getRank() == 2 ){
                        find(id).setSalary(250000);
                    }
                    else if(find(id).getRank() == 3 ){
                        find(id).setSalary(100000);
                    }
                } else if (option1 == 5) break;
            }
    }
}