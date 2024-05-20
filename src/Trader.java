
public class Trader {

    private String companyName;
    private String location;
    private String services;
    private int numEmployees;
    private double dailyRate;
    private String description;

    public Trader(String companyName, String location, String services, int numEmployees, double dailyRate, String description) {
        this.companyName = companyName;
        this.location = location;
        this.services = services;
        this.numEmployees = numEmployees;
        this.dailyRate = dailyRate;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getServices() {
        return services;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("");

        sb.append("------------------------------------------------------------------------------------" + "\n");
        sb.append("Company name:" + "            " + companyName + "\n");
        sb.append("Location:" + "                " + location + "\n");
        sb.append("Services offered:" + "        " + services + "\n");
        sb.append("Number of employees:" + "     " + numEmployees + "\n");
        sb.append("Daily call out rate (£):" + " " + dailyRate + "\n");
        sb.append("Other information:" + "       " + description + "\n");
        sb.append("------------------------------------------------------------------------------------" + "\n");

        return sb.toString();

    }

}
