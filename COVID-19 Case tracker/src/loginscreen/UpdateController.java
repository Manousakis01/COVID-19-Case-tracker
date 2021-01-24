package com.CovidTracker.maven.CovidTracker;


import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateController {

    @FXML
    private TextField ssn;

    @FXML
    private Button searchButton;

    @FXML
    private Label notFound;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField birthday;

    @FXML
    private TextField phone;

    @FXML
    private TextField birthMonth;

    @FXML
    private TextField birthYear;

    @FXML
    private TextField email;

    @FXML
    private TextField dateDay;

    @FXML
    private TextField dateMonth;

    @FXML
    private TextField dateYear;

    @FXML
    public ChoiceBox<String> status;

    @FXML
    private Button updateButton;
    
    ObservableList<String> options = FXCollections.observableArrayList("Negative", "Positive", "ICU Hospitalized", "Dead");
    
    @FXML
    private TextField locationtf;
    
    @FXML
    private Label updatedLabel;
    
    private ResultSet searchRS;
    private String ssntracer;

    //initializes the choicebox    
    @FXML
    private void initialize() {
    status.setItems(options);
    updateButton.setDisable(true);
    ssn.setAlignment(Pos.CENTER);
    }

    //searches for case's info
    @FXML
    private void searchButtonOnAction() {
	    	if(ssn.getText().isBlank()) {
	    		notFound.setAlignment(Pos.CENTER);
	    		notFound.setText("Please insert SSN");
	    	} else {
	    		try {
	    				updatedLabel.setText(null);
	    	    		updateButton.setDisable(false);
						notFound.setText(null);
	    				SearchCase sc = new SearchCase();
						searchRS = sc.executeSearch(ssn.getText());
						ssntracer = ssn.getText();
						//sets prompt text to textfields
						while (searchRS.next()) {
						try {
							fname.setPromptText(searchRS.getString("firstName"));
							lname.setPromptText(searchRS.getString("lastName"));
							birthday.setPromptText(searchRS.getString("dateOfBirth").substring(8));
							birthMonth.setPromptText(searchRS.getString("dateOfBirth").substring(5, 7));
							birthYear.setPromptText(searchRS.getString("dateOfBirth").substring(0, 4));
							phone.setPromptText(searchRS.getString("number"));
							email.setPromptText(searchRS.getString("email"));
							locationtf.setPromptText(searchRS.getString("location"));
							//status.setValue(searchRS.getString("status"));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    		
					}
	    		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	    	}
    }
    //updates case's info
    @FXML
    private void updateButtonOnAction() {
    	String firstName = null, lastName = null, dob = null, number = null, emailaddress = null, location = null;
    	SearchCase sc = new SearchCase();
    	searchRS = sc.executeSearch(ssntracer);
    	try {
        	searchRS.next();
	    	if(!fname.getText().isBlank()) {
	    		firstName = fname.getText();
	    	} else {
	    		firstName = searchRS.getString("firstName");
	    	}
	
	    	if(!lname.getText().isBlank()) {
	    		lastName = lname.getText();
	    	} else {
	    		lastName = searchRS.getString("lastName");
	    	}
	    	// na ta kano ksexorista
	    	if(!birthday.getText().isBlank() && !birthMonth.getText().isBlank() && !birthYear.getText().isBlank()) {
	    		dob = birthYear.getText() + "-" + birthMonth.getText() + "-" + birthday.getText();
	    	} else if (birthday.getText().isBlank() && birthMonth.getText().isBlank() && birthYear.getText().isBlank()) {
	    		dob = searchRS.getString("dateOfBirth").substring(0, 4) + "-" + searchRS.getString("dateOfBirth").substring(5, 7) + "-" + searchRS.getString("dateOfBirth").substring(8);
	    	}
	
	    	if(!phone.getText().isBlank()) {
	    		number = phone.getText();
	    	} else {
	    		number = searchRS.getString("number");
	    	}
	
	    	if(!email.getText().isBlank()) {
	    		emailaddress = email.getText();
	    	} else {
	    		emailaddress = searchRS.getString("email");
	    	}
	
	    	if(!locationtf.getText().isBlank()) {
	    		location = locationtf.getText();
	    	} else {
	    		location = searchRS.getString("location");
	    	}
    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
    	UpdateCase uc = new UpdateCase();
    	uc.updateButtonPerformed(firstName, lastName, dob, number, emailaddress, location, ssntracer);
    	String onDate = dateYear.getText() + "-" + dateMonth.getText() + "-" + dateDay.getText();
    	addToTable(status.getValue(), ssntracer, onDate);
    	fname.clear();
    	lname.clear();
    	birthday.clear();
    	birthMonth.clear();
    	birthYear.clear();
    	phone.clear();
    	email.clear();
    	locationtf.clear();
    	updatedLabel.setAlignment(Pos.CENTER);
    	updatedLabel.setText("Updated successfully!");
    }
    //adds case to the right table
    private void addToTable(String statuschange, String SSN, String Date) {
    	InsertIntoTables iit = new InsertIntoTables();
    	if(statuschange.equals("Positive")) {
    		iit.addPositive(SSN);
    	} else if(statuschange.equals("ICU Hospitalized")) {
    		iit.addMeth(SSN, Date);
    	} else if(statuschange.equals("Dead")) {
    		iit.addDeath(SSN, Date);
    	}
    }
}
