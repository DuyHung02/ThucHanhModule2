import Manager.ManagerStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ManagerStudent.showStudent();
                        break;
                    case 2:
                        ManagerStudent.addStudent();
                        break;
                    case 3:
                        ManagerStudent.editStudent();
                        break;
                    case 4:
                        ManagerStudent.deleteStudent();
                        break;
                    case 5:
                        ManagerStudent.sort();
                        break;
                    case 6:
                        ManagerStudent.readFile();
                        System.out.println("Đọc thành công!");
                        break;
                    case 7:
                        ManagerStudent.writeFile();
                        System.out.println("Xóa thành công!");
                        break;
                    case 8:
                        return;
                    default:
                        System.err.println("Không có chức năng này");
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!");
            }
        }
    }
}