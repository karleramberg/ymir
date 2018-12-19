package com.karl.ymir;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Sidebar extends JPanel {

    private static final long serialVersionUID = 1L;

    public JLabel worldName;

    private Handler h;

    // buttons
    private JButton elevationButton;
    private JButton politicalButton;
    private JButton climateButton;
    private JButton biomeButton;
    private JButton newMapButton;
    private JButton saveButton;
    private JButton settingsButton;

    // icons
    private Image elevationIcon;
    private Image politicalIcon;
    private Image climateIcon;
    private Image biomeIcon;
    private Image newMapIcon;
    private Image saveIcon;
    private Image settingsIcon;

    public Sidebar(Map map) {

        h = new Handler(this);

        // panel fill the world's height and the last 200 pixels on the width.
        System.out.println(map.getHeight());
        setPreferredSize(new Dimension(200, map.getHeight()));

        // CONFIGURE GUI

        // set world name
        worldName = new JLabel("No Map Loaded");
        worldName.setFont(new Font("Roboto", Font.BOLD, 16));

        elevationButton = new JButton("Elevation");
        politicalButton = new JButton("Poltical");
        climateButton = new JButton("Climate");
        biomeButton = new JButton("Biome");
        newMapButton = new JButton("");
        settingsButton = new JButton("");
        saveButton = new JButton("");

        // get resources for icons
        try {
            elevationIcon = ImageIO.read(new FileInputStream("res/icons/elevation.png"));
            politicalIcon = ImageIO.read(new FileInputStream("res/icons/political.png"));
            climateIcon = ImageIO.read(new FileInputStream("res/icons/climate.png"));
            biomeIcon = ImageIO.read(new FileInputStream("res/icons/biome.png"));
            newMapIcon = ImageIO.read(new FileInputStream("res/icons/newMap.png"));
            settingsIcon = ImageIO.read(new FileInputStream("res/icons/settings.png"));
            saveIcon = ImageIO.read(new FileInputStream("res/icons/save.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set icons
        elevationButton.setIcon(new ImageIcon(elevationIcon));
        politicalButton.setIcon(new ImageIcon(politicalIcon));
        climateButton.setIcon(new ImageIcon(climateIcon));
        biomeButton.setIcon(new ImageIcon(biomeIcon));
        newMapButton.setIcon(new ImageIcon(newMapIcon));
        saveButton.setIcon(new ImageIcon(saveIcon));
        settingsButton.setIcon(new ImageIcon(settingsIcon));

        // nifty tooltips
        elevationButton.setToolTipText("Switch to Elevation View");
        politicalButton.setToolTipText("Switch to Political View");
        climateButton.setToolTipText("Switch to Climate View");
        biomeButton.setToolTipText("Switch to Biome View");
        newMapButton.setToolTipText("Generate New Map");
        saveButton.setToolTipText("Save World");
        settingsButton.setToolTipText("Change Settings");

        // consistent fonts, roboto masterrace
        elevationButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        politicalButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        climateButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        biomeButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        newMapButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        saveButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        settingsButton.setFont(new Font("Roboto", Font.PLAIN, 12));

        // add listeners
        elevationButton.addActionListener(h);
        politicalButton.addActionListener(h);
        climateButton.addActionListener(h);
        biomeButton.addActionListener(h);
        newMapButton.addActionListener(h);
        saveButton.addActionListener(h);
        settingsButton.addActionListener(h);

        /* LAYOUT */

        // set layout type
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // buttons snap to the center
        gc.anchor = GridBagConstraints.CENTER;

        // padding between components
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        // cell size is 3 for wider buttons
        gc.gridwidth = 3;

        // world name
        gc.gridx = 0;
        gc.gridy = 0;
        add(worldName, gc);

        // elevation
        gc.ipadx = 10;
        gc.ipady = 5;
        gc.gridx = 0;
        gc.gridy = 1;
        add(elevationButton, gc);

        // political
        gc.ipadx = 19;
        gc.ipady = 5;
        gc.gridx = 0;
        gc.gridy = 2;
        add(politicalButton, gc);

        // climate
        gc.ipadx = 20;
        gc.ipady = 5;
        gc.gridx = 0;
        gc.gridy = 3;
        add(climateButton, gc);

        // biome
        gc.ipadx = 27;
        gc.ipady = 5;
        gc.gridx = 0;
        gc.gridy = 4;
        add(biomeButton, gc);

        // cell size is now 1 to accommodate 3 components in the last row
        gc.gridwidth = 1;

        // new map
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.gridx = 0;
        gc.gridy = 5;
        add(newMapButton, gc);

        // save
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.gridx = 1;
        gc.gridy = 5;
        add(saveButton, gc);

        // settings
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.gridx = 2;
        gc.gridy = 5;
        add(settingsButton, gc);

    }

    public JButton getElevationButton() {
        return elevationButton;
    }

    public void setElevationButton(JButton elevationButton) {
        this.elevationButton = elevationButton;
    }

    public JButton getPoliticalButton() {
        return politicalButton;
    }

    public void setPoliticalButton(JButton politicalButton) {
        this.politicalButton = politicalButton;
    }

    public JButton getClimateButton() {
        return climateButton;
    }

    public void setClimateButton(JButton climateButton) {
        this.climateButton = climateButton;
    }

    public JButton getBiomeButton() {
        return biomeButton;
    }

    public void setBiomeButton(JButton biomeButton) {
        this.biomeButton = biomeButton;
    }

    public JButton getNewMapButton() {
        return newMapButton;
    }

    public void setNewMapButton(JButton newMapButton) {
        this.newMapButton = newMapButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(JButton settingsButton) {
        this.settingsButton = settingsButton;
    }
}