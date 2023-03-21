import java.time.Year;

public class Worker extends Cadre{
    private int degree;
    public Worker(String fullName, Year yearOfBirth, Gender gender, String address, int degree) {
        this.fullName = fullName;
        Year yearCurrent = Year.now();
        if (yearOfBirth.compareTo(yearCurrent) > -18) yearOfBirth = yearCurrent.plusYears(-18);
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
        if (degree < 0) degree = 0;
        if (degree > 7) degree = 7;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        if (degree < 0) degree = 0;
        if (degree > 7) degree = 7;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "   Họ và tên: " + this.fullName + "\n" +
                "   Chức vụ: Công nhân\n" +
                "   Năm sinh: " + this.yearOfBirth + "\n" +
                "   Giới tính: " + this.gender + "\n" +
                "   Địa chỉ: " + this.address + "\n" +
                "   Bằng cấp: " + this.degree + "/7 \n";
    }

}
