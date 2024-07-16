import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListApp {

    static class Task {
        private String description;

        public Task(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    static class ToDoList {
        private ArrayList<Task> tasks;

        public ToDoList() {
            tasks = new ArrayList<>();
        }

        public void addTask(String description) {
            tasks.add(new Task(description));
        }

        public void removeTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            } else {
                System.out.println("Invalid task number.");
            }
        }

        public ArrayList<Task> getTasks() {
            return tasks;
        }
    }

    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;
    private ToDoList toDoList;

    public ToDoListApp() {
        toDoList = new ToDoList();
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(taskList);

        taskField = new JTextField(20);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskDescription = taskField.getText();
                if (!taskDescription.isEmpty()) {
                    toDoList.addTask(taskDescription);
                    listModel.addElement(taskDescription);
                    taskField.setText("");
                }
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toDoList.removeTask(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.NORTH);
        panel.add(addButton, BorderLayout.CENTER);
        panel.add(removeButton, BorderLayout.SOUTH);

        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListApp();
            }
        });
    }
}
