package model;

public class Bank {
    private String short_name;
    private String name;
    private String logo;

    public Bank(String short_name, String name, String logo) {
        this.short_name = short_name;
        this.name = name;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
