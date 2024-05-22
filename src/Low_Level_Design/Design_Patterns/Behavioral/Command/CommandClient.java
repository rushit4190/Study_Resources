package Low_Level_Design.Design_Patterns.Behavioral.Command;

// Text editing application
// Insert / Delete with Undo/Redo



import java.util.Stack;

// Command Interface

interface TextCommand {
    void execute();
    void undo();
}


//Concrete Commands

//InsertCommand: Takes a position and a string to insert at that position in the document.
//Also has a reference of receiver

class InsertCommand implements TextCommand {
    private TextEditor editor;
    private int position;
    private String text;

    public InsertCommand(TextEditor editor, int position, String text) {
        this.editor = editor;
        this.position = position;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.insert(position, text);
    }

    @Override
    public void undo() {
        editor.delete(position, text.length());
    }
}


//DeleteCommand: Takes a starting and ending position to delete text from the document.
// Has a field to store the deleted text


class DeleteCommand implements TextCommand {
    private TextEditor editor;
    private int position;
    private int length;
    private String deletedText;

    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor = editor;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        deletedText = editor.getText().substring(position, position + length);
        editor.delete(position, length);
    }

    @Override
    public void undo() {
        editor.insert(position, deletedText);
    }
}


// Receiver

// Receiver
class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        text = new StringBuilder();
    }

    public void insert(int position, String newText) {
        text.insert(position, newText);
    }

    public void delete(int position, int length) {
        text.delete(position, position + length);
    }

    public String getText() {
        return text.toString();
    }
}


// Invoker
class CommandManager {
    private Stack<TextCommand> history = new Stack<>();
    private Stack<TextCommand> redoStack = new Stack<>();

    public void executeCommand(TextCommand command) {
        command.execute();
        history.push(command);
        redoStack.clear(); // Clear redo stack after a new command is executed
    }

    public void undo() {
        if (!history.isEmpty()) {
            TextCommand command = history.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            TextCommand command = redoStack.pop();
            command.execute();
            history.push(command);
        }
    }
}




//Client class
// Create receiver class, commands and invokers/sender and associate them with specific commands

public class CommandClient {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();

        System.out.println("Initial text: '" + editor.getText() + "'");

        // Insert 'The quick brown fox'
        TextCommand insertPart1 = new InsertCommand(editor, 0, "The quick brown fox");
        manager.executeCommand(insertPart1);
        System.out.println("After insert 'The quick brown fox': '" + editor.getText() + "'");

        // Insert ' jumps over the lazy dog'
        TextCommand insertPart2 = new InsertCommand(editor, 19, " jumps over the lazy dog");
        manager.executeCommand(insertPart2);
        System.out.println("After insert ' jumps over the lazy dog': '" + editor.getText() + "'");

        // Delete ' quick'
        TextCommand deleteQuick = new DeleteCommand(editor, 3, 6);
        manager.executeCommand(deleteQuick);
        System.out.println("After delete ' quick': '" + editor.getText() + "'");

        // Undo delete ' quick'
        manager.undo();
        System.out.println("After undo delete ' quick': '" + editor.getText() + "'");

        // Redo delete ' quick'
        manager.redo();
        System.out.println("After redo delete ' quick': '" + editor.getText() + "'");

        // Delete 'lazy '
        TextCommand deleteLazy = new DeleteCommand(editor, 29, 5);
        manager.executeCommand(deleteLazy);
        System.out.println("After delete 'lazy ': '" + editor.getText() + "'");

        // Undo delete 'lazy '
        manager.undo();
        System.out.println("After undo delete 'lazy ': '" + editor.getText() + "'");

        // Undo delete ' quick'
        manager.undo();
        System.out.println("After undo delete ' quick': '" + editor.getText() + "'");

        // Undo insert ' jumps over the lazy dog'
        manager.undo();
        System.out.println("After undo insert ' jumps over the lazy dog': '" + editor.getText() + "'");

        // Redo insert ' jumps over the lazy dog'
        manager.redo();
        System.out.println("After redo insert ' jumps over the lazy dog': '" + editor.getText() + "'");

        // Redo delete ' quick'
        manager.redo();
        System.out.println("After redo delete ' quick': '" + editor.getText() + "'");

        // Redo delete 'lazy '
        manager.redo();
        System.out.println("After redo delete 'lazy ': '" + editor.getText() + "'");



    }

}
