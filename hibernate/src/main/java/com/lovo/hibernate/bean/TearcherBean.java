package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_teacher")
public class TearcherBean {
    @Id
    @GenericGenerator(name = "teauuid",strategy = "uuid")
    @GeneratedValue(generator = "teauuid")
    private String id;
    @Column(length = 28,name = "t_teaName")
    private String teaName;
    @Column(length = 28,name = "t_teaPwd")
    private String teaPassWord;
    @Column(columnDefinition = "text",updatable = false,name = "t_teaPost")
    private String teaPost;
    @Column(unique = true,name = "t_teaPhone")
    private String teaPhone;
    @Column(nullable = false,name = "t_teaAddress")
    private String teaAddress;
    @OneToMany(mappedBy = "tearcher")
    private List<StudentBean> studentList;

    public List<StudentBean> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentBean> studentList) {
        this.studentList = studentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaPassWord() {
        return teaPassWord;
    }

    public void setTeaPassWord(String teaPassWord) {
        this.teaPassWord = teaPassWord;
    }

    public String getTeaPost() {
        return teaPost;
    }

    public void setTeaPost(String teaPost) {
        this.teaPost = teaPost;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public String getTeaAddress() {
        return teaAddress;
    }

    public void setTeaAddress(String teaAddress) {
        this.teaAddress = teaAddress;
    }
}
