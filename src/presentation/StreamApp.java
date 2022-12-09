package presentation;

import domain.MediaCollection;
import domain.ProfileCollection;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;

public class StreamApp {

    private JFrame frame;
    private ProfileCollection profileList;
    private MediaCollection fullMediaList;
    private MediaCollection currentMediaList;

    public StreamApp() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10, 10));
        frame.setTitle("Netflix Go Home");
        frame.setSize(1130, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel for the menu bar
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        menuPanel.setBackground(Color.DARK_GRAY);

        JLabel logoLabel = new JLabel("There will be a logo here");
        menuPanel.add(logoLabel);

        JTextField searchTextField = new JTextField("media title..", 10);
        menuPanel.add(searchTextField);

        JButton searchButton = new JButton("Search");
        menuPanel.add(searchButton);

        String[] sortByArray = {"Sort by","Favorites", "Rating (Highest first)", "Rating (Lowest first)",
                "Release year (Newest first)", "Release year (Oldest first)"};
        JComboBox<String> sortComboBox = new JComboBox<>(sortByArray);
        menuPanel.add(sortComboBox);

        // TODO Being able to select more than one
        // TODO Get genres from genreList
        String[] genresArray = {"Genres","Action", "Adventure", "Biography","Crime", "Comic", "Drama","History","Horror"};
        JComboBox<String> genresComboBox = new JComboBox<>(genresArray);
        menuPanel.add(genresComboBox);

        // TODO Being able to select more than one
        // TODO Get media from mediaTypesList (Or what it is called these days)
        String[] mediasArray = {"Movies", "Series"};
        JComboBox<String> mediasComboBox = new JComboBox<>(mediasArray);
        menuPanel.add(mediasComboBox);

        // TODO Find right component for the job
        String[] profileOptionsArray = {"Profile options", "Change profile", "Sign out", "Save"};
        JComboBox<String> profileComboBox = new JComboBox<>(profileOptionsArray);
        menuPanel.add(profileComboBox);


        // Scroll panel for media


        JPanel mediaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        mediaPanel.setBackground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(mediaPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // TODO Add as many components as there are media to show
        /*for (Media media : currentMediaList) {
            JButton media = new JButton(media.getImage());
            mediaPanel.add(media);
        }*/

        // Adding JButtons for testing
        ImageIcon image = new ImageIcon("lib/media/serieforsider/The Simpsons.jpg");

        JButton jButton1 = new JButton(image);
        jButton1.setSize(image.getIconWidth(), image.getIconHeight());
        jButton1.setBackground(Color.LIGHT_GRAY);
        mediaPanel.add(jButton1);
        JButton jButton2 = new JButton(image);
        mediaPanel.add(jButton2);
        JButton jButton3 = new JButton(image);
        mediaPanel.add(jButton3);
        JButton jButton4 = new JButton(image);
        mediaPanel.add(jButton4);
        JButton jButton5 = new JButton(image);
        mediaPanel.add(jButton5);
        JButton jButton6 = new JButton(image);
        mediaPanel.add(jButton6);
        JButton jButton7 = new JButton(image);
        mediaPanel.add(jButton7);
        JButton jButton8 = new JButton(image);
        mediaPanel.add(jButton8);
        JButton jButton9 = new JButton(image);
        mediaPanel.add(jButton9);
        JButton jButton10 = new JButton(image);
        mediaPanel.add(jButton10);
        JButton jButton11 = new JButton(image);
        mediaPanel.add(jButton11);
        JButton jButton12 = new JButton(image);
        mediaPanel.add(jButton12);
        JButton jButton13 = new JButton(image);
        mediaPanel.add(jButton13);
        JButton jButton14 = new JButton(image);
        mediaPanel.add(jButton14);
        JButton jButton15 = new JButton(image);
        mediaPanel.add(jButton15);


        // Setting up panels in the frame and making visible
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StreamApp streamingApp = new StreamApp();
    }
}
