import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LibraryManagement extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<>();

    public LibraryManagement() {
        setTitle("Library Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Book ID");
        label2 = new JLabel("Book Title");
        label3 = new JLabel("Author");
        label4 = new JLabel("Publisher");
        label5 = new JLabel("Year of Publication");
        label6 = new JLabel("ISBN");
        label7 = new JLabel("Number of Copies");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String[] book = new String[7];
            book[0] = textField1.getText();
            book[1] = textField2.getText();
            book[2] = textField3.getText();
            book[3] = textField4.getText();
            book[4] = textField5.getText();
            book[5] = textField6.getText();
            book[6] = textField7.getText();
            books.add(book);
            JOptionPane.showMessageDialog(this, "Book added successfully");
            clearFields();
        } else if (e.getSource() == viewButton) {
            String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "ISBN", "Number of Copies"};
            Object[][] data = new Object[books.size()][7];
            for (int i = 0; i < books.size(); i++) {
                data[i] = books.get(i);
            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Books");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
            if (bookID != null) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookID)) {
                        textField1.setText(books.get(i)[0]);
                        textField2.setText(books.get(i)[1]);
                        textField3.setText(books.get(i)[2]);
                        textField4.setText(books.get(i)[3]);
                        textField5.setText(books.get(i)[4]);
                        textField6.setText(books.get(i)[5]);
                        textField7.setText(books.get(i)[6]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found");
            }
        } else if (e.getSource() == deleteButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
            if (bookID != null) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookID)) {
                        books.remove(i);
                        JOptionPane.showMessageDialog(this, "Book deleted successfully");
                        clearFields();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found");
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagement());
    }
}
