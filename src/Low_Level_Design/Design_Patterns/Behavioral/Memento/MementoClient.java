package Low_Level_Design.Design_Patterns.Behavioral.Memento;

import java.util.Stack;

//Text Editor with undo/redo functionality

//Memento class

class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//Originator class

class TextEditor {
    private StringBuilder content;

    public TextEditor() {
        this.content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
    }

    public void delete(int length) {
        int start = content.length() - length;
        if (start >= 0) {
            content.delete(start, content.length());
        }
    }

    public String getContent() {
        return content.toString();
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(content.toString());
    }

    public void restore(TextEditorMemento memento) {
        this.content = new StringBuilder(memento.getState());
    }
}


//Caretaker class

class Caretaker {
    private final Stack<TextEditorMemento> undoHistory = new Stack<>();
    private final Stack<TextEditorMemento> redoHistory = new Stack<>();
    private final TextEditor textEditor;

    public Caretaker(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void save() {
        undoHistory.push(textEditor.save());
        redoHistory.clear();
    }

    public void undo() {

        if (!undoHistory.isEmpty()) {

            redoHistory.push(textEditor.save());
            undoHistory.pop();

            if(!undoHistory.isEmpty()){
                textEditor.restore(undoHistory.peek());
            }
            else{
                textEditor.restore(new TextEditorMemento(""));
            }

        } else {
            System.out.println("No states to undo.");
        }

    }

    public void redo() {

        if (!redoHistory.isEmpty()) {

            undoHistory.push(textEditor.save());
            textEditor.restore(redoHistory.pop());

        } else {
            System.out.println("No states to redo.");
        }
    }
}


public class MementoClient {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker(textEditor);

        textEditor.write("Hello, ");
        caretaker.save();

        textEditor.write("world!");
        caretaker.save();

        System.out.println("Current content: " + textEditor.getContent());

        textEditor.delete(6);
        caretaker.save();

        System.out.println("After delete: " + textEditor.getContent());

        caretaker.undo();
        System.out.println("After undo: " + textEditor.getContent());

        caretaker.redo();
        System.out.println("After redo: " + textEditor.getContent());

        caretaker.undo();
        caretaker.undo();
        System.out.println("After two undos: " + textEditor.getContent());

        caretaker.redo();
        System.out.println("After one redo: " + textEditor.getContent());
    }
}
