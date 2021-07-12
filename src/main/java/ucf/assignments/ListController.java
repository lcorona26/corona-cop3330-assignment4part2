/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Corona
 */
package ucf.assignments;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;


public class ListController implements Initializable {


    public void initialize(URL url, ResourceBundle rb){

        //initializing date
        datePicker.setValue(LocalDate.now());
    }


    @FXML
    private ListView<LocalItem> itemList;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private final FileChooser fileChooser = new FileChooser();

    ObservableList<LocalItem> list = FXCollections.observableArrayList();

    @FXML
    public void loadClicked(ActionEvent actionEvent) { loadList(); }

    @FXML
    public void saveClicked(ActionEvent actionEvent) {
        saveList();
    }

    @FXML
    public void addItemClicked(ActionEvent actionEvent) {
        addItem();
    }

    @FXML
    public void addListClicked(ActionEvent actionEvent) {
        addList();
    }

    @FXML
    public void removeClicked(ActionEvent actionEvent) {
        removeItem();
    }

    @FXML
    public void clearClicked(ActionEvent actionEvent) {
        clearList();
    }

    @FXML
    public void updateClicked(ActionEvent actionEvent) {
        updateItem();
    }

    @FXML
    public void incompletedClicked(ActionEvent actionEvent) {
        displayIncompleteItems();
    }

    @FXML
    public void completedClicked(ActionEvent actionEvent) {
        displayCompleteItems();
    }


    public void loadList() {

        //open file explorer for user to choose file
        File opensFile = fileChooser.showOpenDialog(new Stage());

        //reads file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(opensFile));
            String line;
            int i =0;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null){
                String[] label = line.split(",");
                sb.append(Arrays.toString(label));
                System.out.println(sb);

                //attaches values from file to list
                for(int j = 0; j< label.length/2; j++){
                    LocalDate dueDate = LocalDate.parse(label[i+1]);
                    list.add(new LocalItem(dueDate, label[i]));
                    i= i+2;
                }
            }

            //values from file are shown in To Do List
            itemList.setItems(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveList() {

        //open up file explorer to choose directory of choosing
        File savesFile = fileChooser.showSaveDialog(new Stage());

        //saves file into chosen directory with chosen filename
        try {
            PrintWriter printWriter = new PrintWriter(savesFile);
            printWriter.write(String.valueOf(list).replace("[", "").replace("]", ""));
            printWriter.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void addItem(){

        //get values from description text field and calendar
        list.add(new LocalItem(datePicker.getValue(), descriptionTextField.getText()));

        //add values to list
        itemList.setItems(list);


        //adding checkbox next to items
        itemList.setCellFactory(CheckBoxListCell.forListView(new Callback<LocalItem, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(LocalItem param) {
                return null;
            }
        }));

    }
    public void updateItem(){

        //when user clicks on list item, text will be sent into description field for editing


        //update edited item

    }

    public void addList(){

        //open a new list in a new window



    }


    public void removeItem(){

        //assign an id to each row of text within table for accessing

        //using id, access and remove row of item from table

    }

    public void clearList(){

        //clear all items from list
    }

    public void displayCompleteItems(){

        //display only checked boxes

    }

    public void displayIncompleteItems(){

        //display incomplete items

    }


}
