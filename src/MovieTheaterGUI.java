import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieTheaterGUI {
    private JFrame frame;
    private JButton[][] seatButtons;
    private String[][] seatStatus;
    private int rows;
    private int cols;
    private int tickets;
    private int selectedSeatsCount;
    private JLabel messageLabel;

    public MovieTheaterGUI(int rows, int cols, String[][] seatStatus, int tickets) {
        this.rows = rows;
        this.cols = cols;
        this.seatStatus = seatStatus;
        this.tickets = tickets;
        selectedSeatsCount = 0;

        frame = new JFrame("Movie Theater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridLayout(rows, cols));
        seatButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatButtons[i][j] = new JButton();
                seatButtons[i][j].setText(seatStatus[i][j]);
                seatButtons[i][j].addActionListener(new SeatButtonListener(i, j));
                panel.add(seatButtons[i][j]);
            }
        }

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        frame.add(nextButton, BorderLayout.SOUTH);

        messageLabel = new JLabel("", JLabel.CENTER);
        frame.add(messageLabel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void updateSeatStatus(String[][] newStatus) {
        seatStatus = newStatus;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatButtons[i][j].setText(seatStatus[i][j]);
            }
        }
    }

    private class SeatButtonListener implements ActionListener {
        private int row, col;

        public SeatButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (seatStatus[row][col].equals("0") && selectedSeatsCount < tickets) {
                seatStatus[row][col] = "S"; // Mark the seat as selected
                selectedSeatsCount++;
            } else if (seatStatus[row][col].equals("S")) {
                seatStatus[row][col] = "0"; // Unselect the seat
                selectedSeatsCount--;
            }
            updateSeatStatus(seatStatus);
        }
    }




    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[][] updatedSeatStatus = update2DArray();

            // Update the GUI to display the updated theater
            updateSeatStatus(updatedSeatStatus);
            showMessage("Congratulations, you booked your tickets to see the movie!");
        }
    }
    private String[][] update2DArray() {
        String[][] updatedStatus = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seatButtons[i][j].getText().equals("S")) {
                    updatedStatus[i][j] = "!";
                } else {
                    updatedStatus[i][j] = seatButtons[i][j].getText();
                }
            }
        }

        return updatedStatus;
    }
    private void showMessage(String message) {
        messageLabel.setText(message);
    }
}

