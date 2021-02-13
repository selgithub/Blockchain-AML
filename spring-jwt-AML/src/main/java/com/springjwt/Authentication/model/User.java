package com.springjwt.Authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "USERS")
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @JsonProperty(value = "first_name")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JsonProperty(value = "phone_number")
    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "enabled")
    private boolean enabled;

    @JsonProperty(value = "created_by")
    @Column(name = "created_by")
    private String createdBy;

    @JsonProperty(value = "updated_by")
    @Column(name = "updated_by")
    private String updatedBy;

//
//    @Basic(optional = false)
//    @Column(name = "BIRTH_DATE")
//    private LocalDate birthdate;

    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private Long studentid;

    @Basic(optional = false)
    @Column(name = "INST_EMAIL", unique = true)
    private String instemail;


    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;

    @Basic(optional = false)
    @Column(name = "STREET_NUMBER")
    private String streetno;

    @Basic(optional = false)
    @Column(name = "STREET_NAME", unique = true)
    private String streetname;


//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "streetname", column = @Column(name = "STREETNAME")),
//            @AttributeOverride(name = "streetno", column = @Column(name = "STREETNO")),
//            @AttributeOverride(name = "city", column = @Column(name = "CITY"))
//    })
//    private Address address;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "user_id", referencedColumnName = "ID")
//    private User user;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
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

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public LocalDate getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(LocalDate birthdate) {
//        this.birthdate = birthdate;
//    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getInstemail() {
        return instemail;
    }

    public void setInstemail(String instemail) {
        this.instemail = instemail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetno() {
        return streetno;
    }

    public void setStreetno(String streetno) {
        this.streetno = streetno;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
