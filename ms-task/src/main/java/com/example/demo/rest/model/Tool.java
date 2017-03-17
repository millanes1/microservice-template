package com.example.demo.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Arun Gupta
 */

@XmlRootElement
public class Tool implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;


    private String name;

    private Integer taskId;

    public Tool() {
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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskId=" + taskId +
                '}';
    }
}