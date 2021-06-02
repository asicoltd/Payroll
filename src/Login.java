public interface Login {
    String adminName = "Admin";
    String passWord = "1234";
     static boolean checkPassword(String name, String pass){
         return adminName.equals(name) && passWord.equals(pass);
     }
     static boolean employeeDetail(String name, int id){
         Record r = new Record();
         for (int i = 0 ; i < r.employees.size() ; i++) {
             if (r.employees.get(i).getName().equals(name) && r.employees.get(i).getId() == id) {
                 System.out.println("Name and id matched");
                 System.out.println(r.find(id));
                 return true;
             }
         }
         return false;
     }
}