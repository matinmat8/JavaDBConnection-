//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Main extends JFrame {
    public static void main(String[] args) {
        Employee employee = new Employee();

        Main window = new Main();
        window.setTitle("Your Company!");
        window.setSize(800, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Get an emplyee");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        String[] buttons = {"get", "set"};
//        int returnValue = JOptionPane.showOptionDialog(
//                null,
//                "Choose a button:",
//                "Custom Buttons",
//                JOptionPane.WARNING_MESSAGE,
//                0,
//                null,
//                buttons,
//                buttons[0]
//        );

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var id = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("What is your emplyee's id?"));
                String i = null;
                try {
                    i = employee.Get_info(id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(window, i);

                }

        });
        JButton button1 = new JButton("set info");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                var id = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("What is your emplyee's id?"));
                var age = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("how old is he/she"));
                var salary = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("how much do you pay him/her?"));
                try {
                    employee.Set_info(id, age, salary);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                JOptionPane.showMessageDialog(window, "Employee added with ID: " + id);

        }});


          window.add(button);
          window.setVisible(true);

    }
}


