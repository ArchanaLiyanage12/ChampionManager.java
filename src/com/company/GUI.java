package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {

    final ArrayList<Formula1Driver> F1Driver = Formula1ChampionshipManager.driver; //create object from formula1Driver

    final JButton DescendingPoints = new JButton("points(descending)"); // create buttons
    final JButton AscendingPoints = new JButton("points(Ascending)");
    final JButton SortFirstPosition = new JButton("Positions(Descending)");

    DefaultTableModel FirstTable;

    public GUI() {

        // Layout

        getContentPane().add(panel1());

        DescendingPoints.addActionListener(this);
        AscendingPoints.addActionListener(this);
        SortFirstPosition.addActionListener(this);

        DescendingPoints.setFocusable(false);
        AscendingPoints.setFocusable(false);
        SortFirstPosition.setFocusable(false);
        DescendingPoints.setBackground(Color.lightGray);
        AscendingPoints.setBackground(Color.lightGray);
        SortFirstPosition.setBackground(Color.lightGray);



        setTitle("Formula 1 Championship Manager");
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
//combining the button panel and table panel
    public JPanel panel1() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);


        panel.add(buttonPanel());
        panel.add(driversTableRenderer());
        panel.setBackground(new Color(0x189AB4));


        return panel;
    }
// creating a panel to put buttons
    public JPanel buttonPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);

        panel.add(AscendingPoints);
        panel.add(DescendingPoints);
        panel.add(SortFirstPosition);
        panel.setBackground(new Color(0x189AB4));
        return panel;
    }
// table
    public JScrollPane driversTableRenderer() {
        String[] colNames = {"Position", "Driver Name", "Location", "Driver Team", "1st  Positions", " 2nd Positions", "3rd Positions", "Race Count", "Points"};
        FirstTable = new DefaultTableModel(colNames, 0);
        JTable driverDataTable = new JTable(FirstTable);
        driverDataTable.setBackground(Color.lightGray);


        driverDataTableBody();

        driverDataTable.setPreferredScrollableViewportSize(new Dimension(900, 600));
        return new JScrollPane(driverDataTable);
    }
// refresh table
    public void driverDataTableBody() {
        for (Formula1Driver driver : F1Driver) {
            int pos = F1Driver.indexOf(driver) + 1;
            String dName = driver.getDrivername();
            String dLocation = driver.getLocation();
            String team = driver.getTeam();
            int firstPositions = driver.getNumoffirstposition();
            int secondPositions = driver.getNumofsecondpositions();
            int thirdPositions = driver.getNumofthirdpositions();
            int raceCount = driver.getRaces();
            int score = driver.getPoints();

            Object[] data = {pos, dName, dLocation, team, firstPositions, secondPositions, thirdPositions, raceCount, score};
            FirstTable.addRow(data);
        }
    }
// actions of the buttons

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == DescendingPoints) {
            FirstTable.setRowCount(0);
            F1Driver.sort(new sortpoint());
            driverDataTableBody();
        } else if (e.getSource() == AscendingPoints) {
            FirstTable.setRowCount(0);
            F1Driver.sort(new sortpoint().reversed());
            driverDataTableBody();
        } else if (e.getSource() == SortFirstPosition) {
            FirstTable.setRowCount(0);
            F1Driver.sort(new sortfirstposition());
            driverDataTableBody();
        }
    }
}

