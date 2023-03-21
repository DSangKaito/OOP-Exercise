import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create first list of cadres
        List<Cadre> cadreList = new ArrayList<Cadre>();
        cadreList.add(new Worker("Nguyen Van A", Year.of(2001), Gender.MALE, "đường abc quận 10 TP.HCM", 3));
        cadreList.add(new Worker("Nguyen Thi B", Year.of(2002), Gender.FEMALE, "đường bcd quận 03 TP.HCM", 3));
        int checkRequests = 0;
        // end when user choose 4
        while (checkRequests != 4){
            // set up UI
            System.out.println("----------------------------------------------------------------");
            System.out.println("Nhập yểu cầu:");
            System.out.println(" 1. Thêm cán bộ\n" +
                    " 2. Tìm kiếm theo tên cán bộ\n" +
                    " 3. Hiển thị thông tin về danh sách cán bộ\n" +
                    " 4. Thoát");
            System.out.println("----------------------------------------------------------------");
            checkRequests = scanner.nextInt();
            scanner.nextLine();
            // check requests
            switch (checkRequests) {
                case 1:
                    addCadre(cadreList, scanner);
                    break;
                case 2:
                    System.out.println("Nhập tên cán bộ muốn tìm: ");
                    String fullname = scanner.nextLine();
                    Cadre cadreCheck = getCadreThroughFullName(cadreList, fullname);
                    if (cadreCheck == null){
                        System.out.println("Không tồn tại cán bộ với tên đã nhập");
                        break;
                    }
                    System.out.println(cadreCheck);
                    break;
                case 3:
                    System.out.println("Danh sách cán bộ");
                    int count = 1;
                    for (Cadre cadre : cadreList){
                        System.out.println("  " + count++ + ".");
                        System.out.println(cadre);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("---Vui lòng nhập đúng yêu cầu!!!---");
            }
        }
    }

    // add cadre and return list of cadre after adding
    public static void addCadre(List<Cadre> cadreList, Scanner scanner){
        int tempGender;
        Gender gender;
        int tempRole;
        // input information about cadre
        System.out.println("Nhập thông tin cán bộ: ");
        System.out.print(" Chức vụ (1. kỹ sư, 2. Công nhân, 3. Nhân viên): ");
        tempRole = scanner.nextInt();
        // check and just out when input rights
        while (tempRole != 1 && tempRole != 2 && tempRole != 3){
            System.out.println(" Vui lòng nhập đúng thông tin: ");
            System.out.print(" Chức vụ (1. kỹ sư, 2. Công nhân, 3. Nhân viên): ");
            tempRole = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print(" Họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.print(" Năm sinh: ");
        int yearOfBirth = scanner.nextInt();
        System.out.print(" Gới tính (1. nam, 2. nữ, 3. khác): ");
        tempGender = scanner.nextInt();
        // check and just out when input rights
        while (tempGender != 1 && tempGender != 2 && tempGender != 3){
            System.out.println(" Vui lòng nhập đúng thông tin: ");
            System.out.print(" Gới tính (1. nam, 2. nữ, 3. khác): ");
            tempGender = scanner.nextInt();
        }
        if (tempGender == 1)    gender = Gender.MALE;
        else if (tempGender == 2) gender = Gender.FEMALE;
        else  gender = Gender.OTHER;
        scanner.nextLine();
        System.out.print(" Địa chỉ: ");
        String address = scanner.nextLine();
        // check role and thread through role
        if (tempRole == 1){
            System.out.print(" Ngành đào tạo: ");
            String industry = scanner.nextLine();
            cadreList.add(new Engineer(fullName, Year.of(yearOfBirth),gender,address,industry));
        }
        else if (tempRole == 2) {
            System.out.print(" Bậc (1-7): ");
            int degree = scanner.nextInt();
            // check and just out when input rights
            while (7 < degree || degree < 1){
                System.out.println(" Vui lòng nhập đúng thông tin: ");
                System.out.print(" Bậc (1-7): ");
                degree = scanner.nextInt();
            }
            cadreList.add(new Worker(fullName, Year.of(yearOfBirth),gender,address,degree));
        } else {
            System.out.print(" Công việc: ");
            String job = scanner.nextLine();
            cadreList.add(new Engineer(fullName, Year.of(yearOfBirth),gender,address,job));
        }
        System.out.println(" Thêm cán bộ thành công");
    }

    // get and return cadre have full name like requested
    public static Cadre getCadreThroughFullName(List<Cadre> cadreList, String fullName) {
        Cadre cadre = null;
        for (Cadre cadreCheck : cadreList) {
            if (cadreCheck.getFullName().equals(fullName)) {
                cadre = cadreCheck;
            }
        }
        return cadre;
    }
}