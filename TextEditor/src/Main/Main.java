package Main;

import Controller.EditorController;
import Model.EditorModel;
import View.EditorView;

public class Main {
    public static void main(String[] args) {
        EditorModel model = new EditorModel();
        EditorView view = new EditorView();
        EditorController controller = new EditorController(view, model);
    }
}
