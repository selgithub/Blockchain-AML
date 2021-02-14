package com.springjwt.Authentication.model;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
public class Account {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    @Column(name="ACCOUNT_NAME")
    private String AccountName;

    @Basic(optional = false)
    @Column(name="PUBLIC_KEY")
    private String publickey;

    @Basic(optional = false)
    @Column(name="PRIVATE_KEY")
    private String pivatekey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID" ,referencedColumnName = "ID")
    private User user;
//    private String address;

    public Account() {
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getPivatekey() {
        return pivatekey;
    }

    public void setPivatekey(String pivatekey) {
        this.pivatekey = pivatekey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", AccountName='" + AccountName + '\'' +
                ", publickey='" + publickey + '\'' +
                ", pivatekey='" + pivatekey + '\'' +
                ", user=" + user +
                '}';
    }
}
