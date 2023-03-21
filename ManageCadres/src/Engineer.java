import java.time.Year;

public class Engineer extends Cadre{
    public String industry;

    public Engineer(String fullName, Year yearOfBirth, Gender gender, String address, String industry) {
        this.fullName = fullName;
        Year yearCurrent = Year.now();
        if (yearOfBirth.compareTo(yearCurrent) > -18) yearOfBirth = yearCurrent.plusYears(-18);
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "   Họ và tên: " + this.fullName + "\n" +
                "   Chức vụ: Kỹ sư\n" +
                "   Năm sinh: " + this.yearOfBirth + "\n" +
                "   Giới tính: " + this.gender + "\n" +
                "   Địa chỉ: " + this.address + "\n" +
                "   Ngành đào tạo: " + this.industry + "\n";
    }
}
