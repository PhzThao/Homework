package Controller;

import Model.EditorModel;
import View.EditorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class EditorController {
    private EditorView view;
    private EditorModel model;

    public EditorController(EditorView view, EditorModel model) {
        this.view = view;
        this.model = model;

        view.addNewFileListener(e -> newFile());
        view.addOpenFileListener(e -> open());
        view.addSaveFileListener(e -> save());
        view.addExitListener(e -> exit());
    }

    private void newFile() {
        view.textArea.setText("");
        view.window.setTitle("New");
        model.setFileName(null);
        model.setFileAddress(null);
    }

    private void open() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(view.window);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileAddress = selectedFile.getAbsolutePath();
            String fileName = selectedFile.getName();
            view.window.setTitle(fileName);
            try {
                String content = model.openFile(fileAddress, fileName);
                view.textArea.setText(content);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view.window, "Error: " + e.getMessage());
            }
        }
    }

    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(view.window);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileAddress = selectedFile.getAbsolutePath();
            view.window.setTitle(selectedFile.getName());
            try {
                String content = view.textArea.getText();
                model.saveFile(fileAddress, content);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view.window, "Error: " + e.getMessage());
            }
        }
    }


    private void exit() {
        System.exit(0);
    }
}
