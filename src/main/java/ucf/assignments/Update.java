/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Corona
 */

package ucf.assignments;


public class Update extends LocalItem {

    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Update(String description){

        this.setDescription(description);

    }

    @Override
    public String toString(){
        return  this.getDescription();
    }

}
