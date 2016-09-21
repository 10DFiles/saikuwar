package com.SaikuSecurityIBMTest.domain.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p>
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC </br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
@Entity
@Table(name="gpuser")
@JsonIgnoreProperties(ignoreUnknown=true)
public class GpUser implements UserDetails {


	@Override
	public String toString() {
		return "GpUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", username=" + username + ", password=" + password + ", languagepreference=" + languagepreference
				+ ", primaryemail=" + primaryemail + ", phonenumber=" + phonenumber + ", screenname=" + screenname
				+ ", startdate=" + startdate + ", licenseid=" + licenseid + ", lastaccess=" + lastaccess
				+ ", mustresetpassword=" + mustresetpassword + ", accestype=" + accestype + ", roles=" + roles
				+ ", newuser=" + newuser + "]";
	}


	/**
	*
	* For now this class is only used to make the compile succeed
	* and therefore it is not meant to be used
	*
	* When you are ready this class should follow the same rules as any other
	* Noun to start it should contain the following fields:
	*
	* firstName, lastName. password, userid, email, and a list of Roles
	*
	* You should then allow the person using Geppetto to add more fields
	* to in the Noun editor -  Dan Castillo 01/28/2015
	*
	*
	*/

	public GpUser() {
		// TODO Auto-generated constructor stub
	}


	public GpUser(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Id
	@GeneratedValue
	private Long id = 0L;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String middleName;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String languagepreference;
	@Column
	private String primaryemail;
	@Column
	private String phonenumber;
	@Column
	private String screenname;  //used for display only
	@Column
	private Date startdate;
	@Column
	private String licenseid;
	@Column
	private Date lastaccess;
	@Column
	private String mustresetpassword;
	@Column
	private String accestype;		//used to disable access

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<GpAuthority>  roles = new HashSet<GpAuthority>();;
    @Column
    private boolean newuser;  //typically used for registration

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Set<GpAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Set<GpAuthority> roles) {
		this.roles = roles;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getLanguagepreference() {
		return languagepreference;
	}

	public void setLanguagepreference(String languagepreference) {
		this.languagepreference = languagepreference;
	}

	public String getPrimaryemail() {
		return primaryemail;
	}

	public void setPrimaryemail(String primaryemail) {
		this.primaryemail = primaryemail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getLicenseid() {
		return licenseid;
	}

	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}

	public Date getLastaccess() {
		return lastaccess;
	}

	public void setLastaccess(Date lastaccess) {
		this.lastaccess = lastaccess;
	}

	public String getMustresetpassword() {
		return mustresetpassword;
	}

	public void setMustresetpassword(String mustresetpassword) {
		this.mustresetpassword = mustresetpassword;
	}

	public String getAccestype() {
		return accestype;
	}

	public void setAccestype(String accestype) {
		this.accestype = accestype;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
	      List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
          for (GpAuthority role : roles) {
              System.out.println("The roles is: " + role.getAuthority());
        	  list.add(new SimpleGrantedAuthority(role.getAuthority()));
          }


          return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isNewuser() {
		return newuser;
	}

	public void setNewuser(boolean newuser) {
		this.newuser = newuser;
	}


}