import java.time.Year;

public class Staff extends Cadre{
    public String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Staff(String fullName, Year yearOfBirth, Gender gender, String address, String job) {
        this.fullName = fullName;
        Year yearCurrent = Year.now();
        if (yearOfBirth.compareTo(yearCurrent) > -18) yearOfBirth = yearCurrent.plusYears(-18);
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
        this.job = job;
    }
    @Override
    public String toString() {
        return "   Họ và tên: " + this.fullName + "\n" +
                "   Chức vụ: Công nhân\n" +
                "   Năm sinh: " + this.yearOfBirth + "\n" +
                "   Giới tính: " + this.gender + "\n" +
                "   Địa chỉ: " + this.address + "\n" +
                "   Công việc: " + this.job + "\n";
    }
}
