package peaksoft;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        UserServiceImpl userService=new UserServiceImpl();
            int sss=0;
            System.out.println("1-> Creat Users" +
                    "2-> Drop Users" +
                    "3-> Save Users" +
                    "4-> Remove Users" +
                    "5-> Get all Users" +
                    "6-> Clean Users");
            sss=scanner.nextInt();
            switch (sss) {
                case 1:
                    userService.createUsersTable();
                    break;
                case 2:
                    userService.dropUsersTable();
                    break;
                case 3:
                    userService.saveUser("Maksat", "Mashanov", (byte) 43);
                    break;
                case 4:
                    userService.removeUserById(2l)
                    break;
                case 5:
                    userService.GetAllUsers();
                    break;
                case 6:
                    userService.cleanUsers();
            }
    }
}
