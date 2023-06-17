package dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Admindto {
	private String First_name;
	private String Last_name;
	@Id
	private String Email;
	private long Contact_no;
	private String password1;
	private String conform_password;
	private String Above_18;
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getContact_no() {
		return Contact_no;
	}
	public void setContact_no(long contact_no) {
		Contact_no = contact_no;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getConform_password() {
		return conform_password;
	}
	public void setConform_password(String conform_password) {
		this.conform_password = conform_password;
	}
	public String getAbove_18() {
		return Above_18;
	}
	public void setAbove_18(String above_18) {
		Above_18 = above_18;
	}
}