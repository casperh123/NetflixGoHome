package presentation;

import javax.swing.*;
import java.awt.*;

public class StreamAppJFrame {

    private JFrame frame;

    public StreamAppJFrame() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10, 10));
        frame.setTitle("Netflix Go Home");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel for the menu bar
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        menuPanel.setBackground(Color.DARK_GRAY);

        JLabel logoLabel = new JLabel("There will be a logo here");
        menuPanel.add(logoLabel);

        JTextField searchTextField = new JTextField("media title..");
        menuPanel.add(searchTextField);

        JButton searchButton = new JButton("Search");
        menuPanel.add(searchButton);

        String[] sortByArray = {"Favorites", "Rating (Highest first)", "Rating (Lowest first)",
                "Release year (Newest first)", "Release year (Oldest first)"};
        JComboBox<String> sortComboBox = new JComboBox<>(sortByArray);
        menuPanel.add(sortComboBox);

        // TODO Being able to select more than one
        // TODO Get genres from genreList
        String[] genresArray = {"Action", "Adventure", "Biography","Crime", "Comic", "Drama","History","Horror"};
        JComboBox<String> genresComboBox = new JComboBox<>(genresArray);
        menuPanel.add(genresComboBox);

        // TODO Being able to select more than one
        // TODO Get media from mediaTypesList (Or what it is called these days)
        String[] mediasArray = {"Movies", "Series"};
        JComboBox<String> mediasComboBox = new JComboBox<>(mediasArray);
        menuPanel.add(mediasComboBox);


        // Panel for media
        JPanel mediaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        // TODO Add as many components as there are media to show
        /*for () {
            JLabel media = new JLabel("Media");
            mediaPanel.add(media);
        }*/

        // Adding JButtons for testing
        ImageIcon image = new ImageIcon("lib/media/filmplakater/12 Angry Men.jpg");

        JButton jButton1 = new JButton("Media", image);
        mediaPanel.add(jButton1);
        JButton jButton2 = new JButton("Media", image);
        mediaPanel.add(jButton2);
        JButton jButton3 = new JButton("Media", image);
        mediaPanel.add(jButton3);
        JButton jButton4 = new JButton("Media", image);
        mediaPanel.add(jButton4);
        JButton jButton5 = new JButton("Media", image);
        mediaPanel.add(jButton5);
        JButton jButton6 = new JButton("Media", image);
        mediaPanel.add(jButton6);

        // Setting up panels in the frame and making visible
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(mediaPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
