package ChatBotApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ChatBotApp extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;

    private Map<String, String> responses;

    public ChatBotApp() {
        setTitle("ChatBot App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        responses = new HashMap<>();
        initializeResponses();

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(20, 20, 340, 150);
        panel.add(scrollPane);

        inputField = new JTextField();
        inputField.setBounds(20, 180, 250, 25);
        panel.add(inputField);

        JButton sendButton = new JButton("Send");
        sendButton.setBounds(280, 180, 80, 25);
        panel.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processUserInput();
            }
        });
    }

    private void initializeResponses() {
        responses.put("hello", "Hi there! How can I help you?");
        responses.put("how are you", "I'm just a chatbot, but thanks for asking!");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("books", "1.Biography 2.Mystery 3.Nonfiction");
        responses.put("1", "A.The Diary of a Young Girl B.Becoming C.Autobiography of a Yogi");
        responses.put("a","Thanks for the Order");
        responses.put("b","Thanks for the Order");
        responses.put("c","Thanks for the Order");
        // Add more responses as needed
    }

    private void processUserInput() {
        String userInput = inputField.getText().toLowerCase();
        chatArea.append("You: " + userInput + "\n");

        String response = responses.getOrDefault(userInput, "I'm not sure how to respond to that.");
        chatArea.append("Bot: " + response + "\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatBotApp();
            }
        });
    }
}