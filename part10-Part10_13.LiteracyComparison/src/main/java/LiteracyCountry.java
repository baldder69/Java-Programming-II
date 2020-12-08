
public class LiteracyCountry {

    private int year;
    private String country;
    private String gender;
    private String litrate;

    public LiteracyCountry(String country, int year, String gender, String rate) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.litrate = rate;
    }

    public String getCountry() {
        return this.country;
    }

    public int getYear() {
        return this.year;
    }

    public String getGender() {
        return this.gender;
    }

    public String getRate() {
        return this.litrate;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + ")," + this.gender + ", " + this.litrate;
    }

}
