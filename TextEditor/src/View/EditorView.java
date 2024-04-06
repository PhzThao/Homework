package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditorView {
    public JFrame window;
    public JTextArea textArea;
    public JMenuBar menuBar;
    public JMenu menuFile;
    public JMenuItem iNew;
    public JMenuItem iOpen;
    public JMenuItem iSave;
    public JMenuItem iExit;

    public EditorView() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Text Editor");
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        window.add(scrollPane, BorderLayout.CENTER);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        menuFile.add(iSave);

        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);
    }

    public void addNewFileListener(ActionListener listener) {
        iNew.addActionListener(listener);
    }

    public void addOpenFileListener(ActionListener listener) {
        iOpen.addActionListener(listener);
    }

    public void addSaveFileListener(ActionListener listener) {
        iSave.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        iExit.addActionListener(listener);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
