package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//表示可以被hibernate管理的实体，SUN公司提供了个GPA标准，所以引入包需要引入javax的包
@Entity()
//映射表，name等于表名
@Table(name = "t_student1")
public class StudentBean {
//    @Transient    定义暂态属性，意思就是不做映射，表示该属性与数据库的表无关

    //所有实体类必须有@Id注解
    @Id
    //映射数据库的列（数据库的列名）
    @Column(name="studentId",length = 32)
    //自定义ID生成策略为uuid
    @GenericGenerator(name = "stuuuid",strategy = "uuid")
    @GeneratedValue(generator = "stuuuid")
    private String id;
    //写上length表示长度，不写默认为255，unique表示该字段是否为唯一表示，默认为false
    @Column(length = 32,name = "userName",unique = true)
    private String userName;
    //nullable表示该字段是否允许为null，默认为true。updatable表示在执行修改语句时，该字段是否可以修改，默认为true
    @Column(length = 32,nullable = false,updatable = false)
    private String password;
    //insertable表示在执行添加语句时，该字段是否要添加进入数据库，默认为true，columnDefinition表示该字段以什么类型存入数据库
    @Column(insertable = true,columnDefinition = "text")
    private String coolOrChou;
    private float scare;

    //持有一个教师对象
    @ManyToOne
    @JoinColumn(name = "teaId")
    private TearcherBean tearcher;

    public TearcherBean getTearcher() {
        return tearcher;
    }

    public void setTearcher(TearcherBean tearcher) {
        this.tearcher = tearcher;
    }

    public String getCoolOrChou() {
        return coolOrChou;
    }

    public void setCoolOrChou(String coolOrChou) {
        this.coolOrChou = coolOrChou;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getScare() {
        return scare;
    }

    public void setScare(float scare) {
        this.scare = scare;
    }
}
