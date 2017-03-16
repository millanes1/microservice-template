package com.example.demo.rest;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "REST_DB_WORKPACKAGE")
@NamedQueries({
        @NamedQuery(name = "WorkPackage.findAll", query = "SELECT w FROM WorkPackage w"),
        @NamedQuery(name = "WorkPackage.getById", query="SELECT w FROM WorkPackage w WHERE w.id=:id")
})
@XmlRootElement
public class WorkPackage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String barcode;

    public WorkPackage() {
    }


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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    @Override
    public String toString() {
        return "WorkPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}