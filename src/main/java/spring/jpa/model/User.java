package spring.jpa.model;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="users",uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email") 
})
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(max = 20)
	private String username;
	@NotBlank
	@Email
	private String email;
	private String password;
	private boolean isActive;
	//@ManyToMany
	//@JoinTable(name="USERS_ROLES")
	//private Collection <Role> roles;
	private String role;
	
	public User(String username, String email, String password,boolean actived, String role) {
		super();
		this.username = username;
		this.email = email;
		this.isActive = actived;
		this.password = password;
		this.role = role;
	}
	public User(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActived() {
		return isActive;
	}
	
	public void setActived(boolean actived) {
		this.isActive = actived;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "isActive=" + isActive + ", role=" + role
		+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}