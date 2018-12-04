package com.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })//jpa来做实体类的持久化, handler 和 hibernateLazyInitializer 这两个无须 json 化的属性
public class Category {
    /**
     * JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO. 
     * TABLE：使用一个特定的数据库表格来保存主键。 
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。 
     * IDENTITY：主键由数据库自动生成（主要是自动增长型） 
     * AUTO：主键由程序控制。 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//JPA通用策略生成器 ,通过annotation来映射hibernate实体
    @Column(name = "id")
    int id;

    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
