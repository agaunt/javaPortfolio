package com.example.csc3assignment1;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class QuickInkingController {

    //Create Array List
    static ArrayList<Printer> printerList = new ArrayList<>();

    //Method to parse file, store data elements and add listener 
    public void parseFileData() throws Exception {

        File printerData = new File("/Users/abigailgaunt/IdeaProjects/CSC3Assignment1/src/main/resources/com/example/csc3assignment1/Mini Project Toner Report - Sheet1.csv");
        Scanner scanner = new Scanner(printerData);

        //Skip first line of file
        scanner.nextLine();

        //Loop through file
        while (scanner.hasNext()) {

            //Create printer object and add to ArrayList
            Printer printer = new Printer();
            printerList.add(printer);

            //Read the file data with scanner
            String readPrinterData = scanner.nextLine();

            //Separate into String array at ,
            String[] splitList = readPrinterData.split(",");

            //Set printer data elements
            printer.setDeviceName(splitList[0]);
            printer.setIPAddress(splitList[1]);
            printer.setLastCommunicationTime(splitList[2]);
            printer.setSerialNumber(splitList[3]);
            printer.setPageCount(Integer.parseInt(splitList[4]));
            printer.setBlackCartridge(Integer.parseInt(splitList[5]));
            printer.setColorCartridge(Integer.parseInt(splitList[6]));
            printer.setLowInkBlack(printer.getBlackCartridge());
            printer.setLowInkColor(printer.getColorCartridge());
        }
        //Set Listview to display text when object is clicked 
        printerView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            {
                for (Integer i : printerView.getSelectionModel().getSelectedIndices()) {

                    Printer printer = printerList.get(i);
                    displayDeviceInfo.setText(printer.toString());
                }
            }
        });
    }

    //Display Data on user interface
    @FXML
    private ListView<String> printerView;
    @FXML
    private Text displayDeviceInfo;
    @FXML
    private ListView<String> lowInkWarning;
    @FXML
    public void initialize() throws Exception {
        //Call method to parse file
        parseFileData();

        //Display device names on listview
        for (Printer printer : printerList) {
            printerView.getItems().add(printer.getDeviceName());

            //Display low ink warnings on ListView
            if (printer.getLowInkBlack()) {
                lowInkWarning.getItems().add(printer.getDeviceName() + " (black)");
            } else if (printer.getLowInkColor()) {
                lowInkWarning.getItems().add(printer.getDeviceName() + " (color)");
            }
        }
    }

    //Exit the program from screen
    @FXML
    private Button quit;

    @FXML
    public void onQuitButtonClick(){
        System.exit(0);
    }
}