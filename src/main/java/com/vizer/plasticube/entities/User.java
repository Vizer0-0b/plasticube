package com.vizer.plasticube.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vizer.library.entities.Book;

@Entity
@Table(name="user")
public class User implements UserDetails {

	private static final long serialVersionUID = -8169204616909475776L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	@Column(unique=true)
    private String cnname;
    private String username;

    private String password;
    private String rePassword;
    private String historyPassword;
    private String email;

    private String telephone;
    private String mobilePhone;
    
    @Transient
    private List<? extends GrantedAuthority> authorities;
    
    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    private Role role;
   
    @OneToMany(mappedBy="currentUser", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> book = new ArrayList<Book>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getHistoryPassword() {
        return historyPassword;
    }

    public void setHistoryPassword(String historyPassword) {
        this.historyPassword = historyPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cnname=" + cnname +
                ", username=" + username +
                ", password=" + password +
                ", email=" + email +
                ", telephone=" + telephone +
                ", mobilePhone=" + mobilePhone +
                '}';
    }

}