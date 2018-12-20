package com.mappala.kenneth;

public class Data {

    String personId;
    String personfName;
    String personAge;
    String personGender;

    public Data(String personId){

    }

    public Data(String personId, String personfName, String personAge, String personGender) {
        this.personId = personId;
        this.personfName = personfName;
        this.personAge = personAge;
        this.personGender = personGender;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPersonfName() {
        return personfName;
    }

    public String getPersonAge() {
        return personAge;
    }

    public String getPersonGender() {
        return personGender;
    }
}
