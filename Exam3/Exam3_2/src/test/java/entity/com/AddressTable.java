package entity.com;
//这个类对应着数据库中的address-table，作用是对address-table表的信息的读取和设置
public class AddressTable extends Id {
	private String city;
	private String country;
	private String user_id;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "AddressTable [city=" + city + ", country=" + country + ", user_id=" + user_id + ", id=" + id + "]";
	}
    
}
