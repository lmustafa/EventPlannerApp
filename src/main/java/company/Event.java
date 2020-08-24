package company;

public class Event {
    private String id;
    private String name;
    private String description;
    private String localDate;
    private String localTime;
    private String postalCode;
    private String cityName;
    private String provinceName;
    private String countryName;
    private String address;
    private String venue;
    private String genre;

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Event:" + "\n" +
                "name=" + name + "\n" +
                "description=" + description + "\n"  +
                "localDate=" + localDate + "\n"  +
                "localTime=" + localTime + "\n"  +
                "postalCode=" + postalCode + "\n"  +
                "cityName=" + cityName + "\n" +
                "provinceName=" + provinceName + "\n" +
                "countryName=" + countryName + "\n" +
                "address=" + address + "\n" +
                "venue=" + venue + "\n" +
                "genre=" + genre + "\n";
    }
}
