/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Corona
 */

package ucf.assignments;


import java.time.LocalDate;

public class LocalItem {

    private String description;
    private LocalDate date;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalItem(LocalDate date, String description){

        this.setDate(date);
        this.setDescription(description);
    }

    @Override
    public String toString(){
        return  this.getDescription() + ", " +this.getDate();
    }

}
