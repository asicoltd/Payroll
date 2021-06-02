import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable {
    private String Name;
    private int Id;
    private int phoneNumber;
    private String email;
    private int rank;
    private double salary;
    private double bonus;
    private boolean paidStatus;
    private final Calendar joiningDate = Calendar.getInstance();

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public int getRank() {
        return rank;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setSalary(double v) {
        if( v == 0.0)
            this.salary = v;
        else if( this.rank == 1)
            this.salary = 400000;
        else if( this.rank == 2)
            this.salary = 250000;
        else
            this.salary = 100000;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    @Override
    public String toString() {
        return "Name : " + Name +
                "\nId : " + Id +
                "\nphoneNumber : +880" + phoneNumber +
                "\nemail : " + email  +
                "\nrank : " + rank +" class"+
                "\nsalary : " + salary +
                "\nbonus : " + bonus +
                "\njoining Year : " + joiningDate.getWeekYear();
    }
}