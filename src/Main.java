import java.io.Serializable;
import java.util.Scanner;
public class Main implements Serializable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Login Section
        while (true) {
            System.out.println("Login as \n1.Admin\n2.Employee\n3.Exit");
            int log = sc.nextInt();
            sc.nextLine();
            if (log == 1) {
                while (true) {
                    System.out.print("User Name:");
                    String user = sc.nextLine();
                    System.out.print("Password:");
                    String pass = sc.nextLine();
                    if (Login.checkPassword(user, pass)) {
                        System.out.println("Login Successful");
                        break;
                    } else {
                        System.out.println("User Name/Password wrong\nTry Again!!!!");
                    }
                }
                // Main menu section
                Record r = new Record();
                System.out.println("Saved file successfully loaded from Record.bat");
                while (true) {
                    System.out.println("1.View Employee List\n2.Add Employee\n3.Pay Employee\n4.Change Data\n5.Remove Employee\n6.Log Out");
                    int option = sc.nextInt();
                    if (option == 1) {
                        while (true) {
                            System.out.println("1.View All Employee Name (with ID & payment status)\n2.Search by ID\n3.Exit");
                            int option1 = sc.nextInt();
                            if (option1 == 1)
                                r.viewAll();
                            else if (option1 == 2) {
                                System.out.println("Enter ID:");
                                System.out.println(r.find(sc.nextInt()));
                            } else if (option1 == 3) {
                                break;
                            }

                        }

                    } else if (option == 2) {
                        System.out.println("Adding new Employee:");
                        r.add();
                    } else if (option == 3) {
                        System.out.println("Enter Employee ID:");
                        int id = sc.nextInt();
                        r.find(id);
                        if (r.find(id).isPaidStatus()) {
                            System.out.println("Employee already paid\nWant to give bonus???\n1.Yes\n2.No");
                            int bonus = sc.nextInt();
                            if (bonus == 1) {
                                System.out.println("How much bonus want to give:");
                                r.find(id).setBonus(sc.nextDouble());
                            }
                        } else {
                            System.out.println("Employee id " + id + " is " + r.find(id).getRank() + " ranked");
                            if (r.find(id).getRank() == 1){
                                System.out.println("Want to pay :" + 400000 + "\n1.Yes\n2.No");
                            if (sc.nextInt() == 1) {
                                r.find(id).setSalary(400000);
                                r.find(id).setPaidStatus(true);
                            }
                            } else if (r.find(id).getRank() == 2){
                                System.out.println("Want to pay :" + 250000 + "\n1.Yes\n2.No");
                            if (sc.nextInt() == 1) {
                                r.find(id).setSalary(250000);
                                r.find(id).setPaidStatus(true);
                            }
                            } else if (r.find(id).getRank() == 3){
                                System.out.println("Want to pay :" + 100000 + "\n1.Yes\n2.No");
                            if (sc.nextInt() == 1) {
                                r.find(id).setSalary(100000);
                                r.find(id).setPaidStatus(true);
                            }
                            }

                        }
                    } else if (option == 4) {
                        System.out.println("Enter employee ID: ");
                        int id = sc.nextInt();
                        System.out.println("Recorded data for id: " + id + " is:\n" + r.find(id));
                        r.edit(id);
                    } else if (option == 5) {
                        System.out.println("Enter employee ID: ");
                        int id = sc.nextInt();
                        System.out.println("Recorded data for id: " + id + " is:\n" + r.find(id));
                        System.out.println("Want to remove this Employee data\n1.Yes\n2.No");
                        if (sc.nextInt() == 1) {
                            System.out.println("The account will be permanently deleted\nContinue ????\n1.Yes\n2.No");
                            if (sc.nextInt() == 1)
                                r.employees.remove(r.find(id));
                        }
                    } else if (option == 6) break;
                }
                fileAccess.writeFile(r.employees);
            } else if (log == 2) {
                while (true) {
                    System.out.print("Name:");
                    String user = sc.nextLine();
                    System.out.print("ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (Login.employeeDetail(user, id)) {
                        break;
                    } else {
                        System.out.println("User Name/Password wrong\nTry Again!!!!");
                    }
                }
            }
            else if(log == 3)break;
        }
    }
}