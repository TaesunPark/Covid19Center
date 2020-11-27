package org.androidtown.covid19center.Server;

public class QuestionnaireVO {

    int sequence;

    String user_id;
    int visited;
    //boolean visited;
    String visited_detail;
    int contact;
    //boolean contact;
    String contact_relationship, contact_period;
    int fever, muscle_ache, sputum, runny_nose, dyspnea, sore_throat;
    //boolean fever, muscle_ache, sputum, runny_nose, dyspnea, sore_throat;
    String symptom_start_date, entrance_date;

    public QuestionnaireVO
            (int sequence,

             String user_id,
             //boolean visited,
             int visited,
             String visited_detail,
             //boolean contact,
             int contact,
             String contact_relationship,
             String contact_period,
             //boolean fever,
             //boolean muscle_ache,
             //boolean sputum,
             //boolean runny_nose,
             //boolean dyspnea,
             //boolean sore_throat,
             int fever, int muscle_ache, int sputum, int runny_nose, int dyspnea, int sore_throat,
             String symptom_start_date,
             String entrance_date) {

        this.sequence = sequence;

        this.user_id = user_id;
        this.visited = visited;
        this.visited_detail = visited_detail;
        this.contact = contact;
        this.contact_relationship = contact_relationship;
        this.contact_period = contact_period;
        this.fever = fever;
        this.muscle_ache = muscle_ache;
        this.sputum = sputum;
        this.runny_nose = runny_nose;
        this.dyspnea = dyspnea;
        this.sore_throat = sore_throat;
        this.symptom_start_date = symptom_start_date;
        this.entrance_date = entrance_date;
    }


    public int getSequence() { return sequence;}
    public void setSequence(int sequence) {this.sequence = sequence; }



    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String id) {
        this.user_id = user_id;
    }

    /*
    public boolean getVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getVisited_detail() {
        return visited_detail;
    }
    public void setVisited_detail(String visited_detail) {
        this.visited_detail = visited_detail;
    }

    public boolean getContact() {
        return contact;
    }
    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public String getContact_relationship() {
        return contact_relationship;
    }
    public void setContact_relationship(String contact_relationship) {
        this.contact_relationship = contact_relationship;
    }

    public String getContact_period() {
        return contact_period;
    }
    public void setContact_period(String contact_period) {
        this.contact_period = contact_period;
    }

    public boolean getFever() {
        return fever;
    }
    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean getMuscle_ache() {
        return muscle_ache;
    }
    public void setMuscle_ache(boolean muscle_ache) {
        this.muscle_ache = muscle_ache;
    }

    public boolean getSputum() {
        return sputum;
    }
    public void setSputum(boolean sputum) {
        this.sputum = sputum;
    }

    public boolean getRunny_nose() {
        return runny_nose;
    }
    public void setRunny_nose(boolean runny_nose) {
        this.runny_nose = runny_nose;
    }

    public boolean getDyspnea() {
        return dyspnea;
    }
    public void setDyspnea(boolean dyspnea) {
        this.dyspnea = dyspnea;
    }

    public boolean getSore_throat() {
        return sore_throat;
    }
    public void setSore_throat(boolean sore_throat) {
        this.sore_throat = sore_throat;
    }


     */
    public String getSymptom_start_date() {
        return symptom_start_date;
    }
    public void setSymptom_start_date(String symptom_start_date) {
        this.symptom_start_date = symptom_start_date;
    }

    public String getEntrance_date() {return entrance_date;}
    public void setEntrance_date(String entrance_date) {
        this.entrance_date = entrance_date;
    }

}