package com.example.demo.rest.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "REST_DB_TASKS")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.findByWorpackageId", query = "SELECT t FROM Task t WHERE t.workpackageId=:id")

})

@XmlRootElement
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    private Integer id;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "WRPK_ID")
    private Integer workpackageId;

    @Transient
    private WorkPackage workpackage;

    @Transient
    private List<Tool> toolList;

    public Task() {
        toolList = new ArrayList<Tool>();
        workpackage = new WorkPackage();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    public Integer getWorkpackageId() {
        return workpackageId;
    }

    public void setWorkpackageId(int workpackageId) {
        this.workpackageId = workpackageId;
    }

    public WorkPackage getWorkpackage() {
        return workpackage;
    }

    public void setWorkpackage(WorkPackage workpackage) {
        this.workpackage = workpackage;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workpackageId=" + workpackageId +
                ", workpackage=" + workpackage +
                ", toolList=" + toolList +
                '}';
    }
}