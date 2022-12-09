package Manager;

import Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void readFile() {
        io.ReadWriteFile.readFile();
    }

    public static void writeFile() {
        io.ReadWriteFile.writeFile(students);
    }

    public static void showStudent() {
        System.out.println("     -----Tổng số sinh viên là: " + students.size() + " SV-----");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        while (true) {
            try {
                System.out.println("1. Sửa sinh viên");
                System.out.println("2. Thoát");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        editStudent();
                        break;
                    case 2:
                        return;
                    default:
                        System.err.println("Chọn (1) hoặc (2)");
                }
            } catch (NumberFormatException e) {
                System.err.println("Chọn (1) hoặc (2)");
            }
        }
    }

    public static void addStudent() {
        String maStudent;
        while (true) {
            System.out.println("Nhập mã sinh viên");
            maStudent = scanner.nextLine();
            if (checkMaSv(maStudent)) {
                System.out.println("Mã sinh viên đã tồn tại");
                System.out.println("Nhập lại");
            } else {
                System.out.println("ok!!");
                break;
            }
        }
        System.out.println("[Nhập tên sinh viên]:");
        String nameStudent = scanner.nextLine();
        int ageStudent;
        while (true) {
            try {
                System.out.println("[Nhập tuổi sinh viên]:");
                ageStudent = Integer.parseInt(scanner.nextLine());
                if (ageStudent < 10 || ageStudent > 60) {
                    System.err.println("Tuổi không hợp lệ");
                    System.out.println("Nhập lại");
                } else {
                    System.out.println("ok!!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!");
            }
        }
        System.out.println("[Nhập giới tính sinh viên]:");
        String genderStudent = scanner.nextLine();
        System.out.println("[Nhập địa chỉ]:");
        String addressStudent = scanner.nextLine();
        double averageStudent;
        while (true) {
            try {
                System.out.println("Nhập điểm trung bình");
                averageStudent = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!");
            }
        }
        Student student = new Student(maStudent, nameStudent, ageStudent, genderStudent, addressStudent, averageStudent);
        students.add(student);
    }

    public static void editStudent() {
        System.out.println("Nhập mã sinh viên: ");
        String maStudent = scanner.nextLine();
        if (checkMaSv(maStudent)) {
            System.out.println("Chọn mục muốn sửa: ");
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa tuổi");
            System.out.println("3. Sửa giới tính");
            System.out.println("4. Sửa địa chỉ");
            System.out.println("5. Sửa điểm");
            System.out.println("0. Thoát");
            while (true) {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("[Nhập tên mới]: ");
                            String newName = scanner.nextLine();
                            students.get(findIndexByMaSv(maStudent)).setName(newName);
                            break;
                        case 2:
                            System.out.println("[Nhập tuổi mới]: ");
                            int newAge = Integer.parseInt(scanner.nextLine());
                            students.get(findIndexByMaSv(maStudent)).setAge(newAge);
                            break;
                        case 3:
                            System.out.println("[sửa giới tính]: ");
                            String newGender = scanner.nextLine();
                            students.get(findIndexByMaSv(maStudent)).setGender(newGender);
                            break;
                        case 4:
                            System.out.println("[Nhập địa chỉ mới]: ");
                            String newAddress = scanner.nextLine();
                            students.get(findIndexByMaSv(maStudent)).setAddress(newAddress);
                            break;
                        case 5:
                            break;
                        case 0:
                            return;
                        default:
                            System.err.println("Không có chức năng này!!" + '\n');
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Nhập số!!" + '\n');
                }
            }
        } else {
            System.err.println("Không tìm thấy sinh viên");
        }
    }

    public static void deleteStudent() {
        System.out.println("Nhập mã sinh viên cần xóa: ");
        String maSV = scanner.nextLine();
        if (checkMaSv(maSV)) {
            System.out.println("Xóa sinh viên " + maSV + " ?");
            while (true) {
                System.out.println("1. Đồng ý");
                System.out.println("2. Hủy");
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            students.remove(findIndexByMaSv(maSV));
                            System.out.println("Xóa thành công");
                            showStudent();
                            return;
                        case 2:
                            return;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Chọn (1) hoặc (2)");
                }
            }
        } else {
            System.err.println("Không thấy sinh viên!!");
        }
    }

    public static void sort() {
        int choose = 3;
        while (true) {
            System.out.println("----Sắp xếp sinh viên theo điểm trung bình---");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Sắp xếp điểm trung bình tăng dần");
            System.out.println("2. Sắp xếp điểm trung bình giảm dần---");
            System.out.println("3. Thoát");
            System.out.println("Chọn chức năng: ");
            do {
                if (choose > 3) System.out.println("Vui lòng nhập lại");
                choose = Integer.parseInt(scanner.nextLine());
            } while (choose > 3);
            switch (choose) {
                case 1 -> sortAvgUp();
                case 2 -> sortAvgDown();
                case 3 -> {
                    return;
                }
            }
        }
    }

    public static void sortAvgUp() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getAverage() > students.get(j).getAverage()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        showStudent();
    }

    public static void sortAvgDown() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getAverage() < students.get(j).getAverage()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        showStudent();
    }

    public static boolean checkMaSv(String maSV) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMaSV().equals(maSV)) {
                return true;
            }
        }
        return false;
    }

    public static int findIndexByMaSv(String maStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMaSV().equals(maStudent))
                return i;
        }
        return -1;
    }
}
