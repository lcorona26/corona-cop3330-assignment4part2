/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Luis Corona
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ListControllerTest {

    ObservableList<Object> check = FXCollections.observableArrayList();

    @Test
    void addItemTest() {

        //initial list items
        check.add("old1");
        check.add("old2");

        //simulating the add item button, size is initially 2
        check.add("new1");
        check.add("new2");

        //assert that item is listed in table, size should increase to 4
        assertEquals(4, check.size());

    }

    @Test
    void addListTest() {

        ObservableList<Object> expected = FXCollections.observableArrayList();


        //creating an initial List
        check.add("old1");
        check.add("old2");

        //simulating the add list button
        expected.add("new1");
        expected.add("new2");

        //assert that a new list has been created in a "new window"
        assertNotEquals(check, expected);
    }

    @Test
    void removeItemTest() {
        //initial list items
        check.add("old1");
        check.add("old2");

        //simulating the remove item button, size is initially 2
        check.remove("old1");


        //assert that item is listed in table, size should decrease to 1
        assertEquals(1, check.size());
    }

    @Test
    void updateItemTest() {

        ObservableList<Object> actual = FXCollections.observableArrayList();
        ObservableList<Object> expected = FXCollections.observableArrayList();

        //initial actual values
        actual.add("old1");
        actual.add("old2");

        //expected list
        expected.add("old2");
        expected.add("old1Edit");

        //simulate the update item button
        actual.remove("old1");
        actual.add("old1Edit");

        //check item has been updated by
            //asserting old item is no longer in list
            assertEquals(actual, expected);

    }

    @Test
    void clearListTest() {

        ObservableList<Object> expected = FXCollections.observableArrayList();

        //initial list
        check.add("initial1");
        check.add("initial2");

        //simulate the clear list button
        check.remove("initial1");
        check.remove("initial2");

        //assert that list contains no items
        assertEquals(check, expected);

    }

}