package rmcreation.com.custommerdetails;

/**
 * Created by robin1 on 28/12/2017.
 */

class Custom {

    String name;
    String place;
    String phone;
    String desc;

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {

        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getPhone() {
        return phone;
    }

    public String getDesc() {
        return desc;
    }

    public Custom(String name, String place, String phone, String desc) {

        this.name = name;
        this.place = place;
        this.phone = phone;
        this.desc = desc;
    }
}
