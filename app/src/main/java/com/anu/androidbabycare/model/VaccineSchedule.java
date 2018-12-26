package com.anu.androidbabycare.model;

/**
 * Created by hp on 12/25/2018.
 */

public class VaccineSchedule {

    private Integer id;
    private Integer scheduleId;
    private String vaccineName;
    private String name;
    private String scheduleGroup;
    private String prescribedAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduleGroup() {
        return scheduleGroup;
    }

    public void setScheduleGroup(String scheduleGroup) {
        this.scheduleGroup = scheduleGroup;
    }

    public String getPrescribedAge() {
        return prescribedAge;
    }

    public void setPrescribedAge(String prescribedAge) {
        this.prescribedAge = prescribedAge;
    }


}
