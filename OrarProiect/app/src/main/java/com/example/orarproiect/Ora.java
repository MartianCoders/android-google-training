package com.example.orarproiect;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ora {
    private String name;
    private Integer startHour;
    private Integer finishHour;
    private Integer weekNo;
    private String group;
    private Integer semiGroup;
    private String classroom;
    private String typeOf;
    private String teacherName;

    private final String patternDate = "hh:mm";

    public Ora() { }

    public Ora(String name, Integer startHour, Integer finishHour, String group, String classroom, String typeOf, String teacherName) throws ParseException {
        this.name = name;
        this.group = group;
        this.classroom = classroom;
        this.typeOf = typeOf;
        this.teacherName = teacherName;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Integer getFinishHour() {
        return finishHour;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getPatternDate() {
        return patternDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setFinishHour(Integer finishHour) {
        this.finishHour = finishHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public List<Ora> populate(int counter) throws ParseException {
        List<Ora> list = new ArrayList<Ora>();

        for(int i = 0; i < counter; i++) {
            Ora ora = new Ora("name" + i, 10, 12, "32" + i, "class" + i, "Seminar", "name" + i);
            list.add(ora);
        }

        return list;
    }
}
