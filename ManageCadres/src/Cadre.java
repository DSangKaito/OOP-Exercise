import java.time.Year;

public abstract class Cadre {
    public String fullName;
    public Year yearOfBirth;
    public Gender gender;
    public String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Year yearOfBirth) {
        Year yearCurrent = Year.now();
        if (yearOfBirth.compareTo(yearCurrent) > -18) yearOfBirth = yearCurrent.plusYears(-18);
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract String toString();
}
