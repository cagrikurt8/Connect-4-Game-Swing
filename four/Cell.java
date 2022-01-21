package four;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    public static String label = "X";
    private static final Cell[][] cellGroups = ConnectFour.cellGroups;
    public Cell next;
    public Cell cell;
    public static boolean win = false;

    public Cell() {
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 24));

        addActionListener(e -> {
            if (!win) {
                if (getName().contains("ButtonA")) {
                    fillColumnA();
                } else if (getName().contains("ButtonB")) {
                    fillColumnB();
                } else if (getName().contains("ButtonC")) {
                    fillColumnC();
                } else if (getName().contains("ButtonD")) {
                    fillColumnD();
                } else if (getName().contains("ButtonE")) {
                    fillColumnE();
                } else if (getName().contains("ButtonF")) {
                    fillColumnF();
                } else if (getName().contains("ButtonG")){
                    fillColumnG();
                }

                if (label.equals("X")) {
                    label = "O";
                } else {
                    label = "X";
                }

                checkWin();
            }
        });
    }

    private void fillColumnA() {
        cell = cellGroups[0][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnB() {
        cell = cellGroups[1][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnC() {
        cell = cellGroups[2][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnD() {
        cell = cellGroups[3][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnE() {
        cell = cellGroups[4][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnF() {
        cell = cellGroups[5][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void fillColumnG() {
        cell = cellGroups[6][0];

        while (!cell.isEmpty() && cell.next != null) {
            cell = cell.next;
        }

        if (cell.isEmpty()) {
            cell.setText(label);
        }
    }

    private void checkWin() {
        checkVertical();
        checkHorizontal();
        checkDiagonal();
    }

    private void checkVertical() {
        for (int i = 0; i < 7; i++) {
            Cell[] cells = cellGroups[i];

            for (int j = 0; j < 3; j++) {
                boolean condition = (cells[j].getText().equals("X") && cells[j + 1].getText().equals("X") && cells[j + 2].getText().equals("X") && cells[j + 3].getText().equals("X")) ||
                                    (cells[j].getText().equals("O") && cells[j + 1].getText().equals("O") && cells[j + 2].getText().equals("O") && cells[j + 3].getText().equals("O"));

                Cell[] winningCells = new Cell[] {cells[j], cells[j + 1], cells[j + 2], cells[j + 3]};

                if (condition) {
                    for (Cell cell: winningCells) {
                        cell.setBackground(new Color(0, 225, 250));
                        win = true;
                    }
                }
            }

        }
    }

    private void checkHorizontal() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell1 = cellGroups[i][j];
                Cell cell2 = cellGroups[i + 1][j];
                Cell cell3 = cellGroups[i + 2][j];
                Cell cell4 = cellGroups[i + 3][j];

                boolean condition = (cell1.getText().equals("X") && cell2.getText().equals("X") && cell3.getText().equals("X") && cell4.getText().equals("X")) ||
                                    (cell1.getText().equals("O") && cell2.getText().equals("O") && cell3.getText().equals("O") && cell4.getText().equals("O"));

                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                if (condition) {
                    for (Cell cell: winningCells) {
                        cell.setBackground(new Color(0, 225, 250));
                        win = true;
                    }
                }
            }
        }
    }

    private void checkDiagonal() {
        // From the left bottom to right top

        for (int i = 0; i < 1; i++) {
            Cell cell1 = cellGroups[i][i + 2];
            Cell cell2 = cellGroups[i + 1][i + 3];
            Cell cell3 = cellGroups[i + 2][i + 4];
            Cell cell4 = cellGroups[i + 3][i + 5];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            Cell cell1 = cellGroups[i][i + 1];
            Cell cell2 = cellGroups[i + 1][i + 2];
            Cell cell3 = cellGroups[i + 2][i + 3];
            Cell cell4 = cellGroups[i + 3][i + 4];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            Cell cell1 = cellGroups[i][i];
            Cell cell2 = cellGroups[i + 1][i + 1];
            Cell cell3 = cellGroups[i + 2][i + 2];
            Cell cell4 = cellGroups[i + 3][i + 3];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 1; i < 4; i++) {
            Cell cell1 = cellGroups[i][i - 1];
            Cell cell2 = cellGroups[i + 1][i];
            Cell cell3 = cellGroups[i + 2][i + 1];
            Cell cell4 = cellGroups[i + 3][i + 2];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 2; i < 4; i++) {
            Cell cell1 = cellGroups[i][i - 2];
            Cell cell2 = cellGroups[i + 1][i - 1];
            Cell cell3 = cellGroups[i + 2][i];
            Cell cell4 = cellGroups[i + 3][i + 1];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 3; i < 4; i++) {
            Cell cell1 = cellGroups[i][i - 3];
            Cell cell2 = cellGroups[i + 1][i - 2];
            Cell cell3 = cellGroups[i + 2][i - 1];
            Cell cell4 = cellGroups[i + 3][i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        // From the right bottom to left top

        for (int i = 6; i > 5; i--) {
            Cell cell1 = cellGroups[i][8 - i];
            Cell cell2 = cellGroups[i - 1][9 - i];
            Cell cell3 = cellGroups[i - 2][10 - i];
            Cell cell4 = cellGroups[i - 3][11 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 6; i > 4; i--) {
            Cell cell1 = cellGroups[i][7 - i];
            Cell cell2 = cellGroups[i - 1][8 - i];
            Cell cell3 = cellGroups[i - 2][9 - i];
            Cell cell4 = cellGroups[i - 3][10 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 6; i > 3; i--) {
            Cell cell1 = cellGroups[i][6 - i];
            Cell cell2 = cellGroups[i - 1][7 - i];
            Cell cell3 = cellGroups[i - 2][8 - i];
            Cell cell4 = cellGroups[i - 3][9 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 5; i > 2; i--) {
            Cell cell1 = cellGroups[i][5 - i];
            Cell cell2 = cellGroups[i - 1][6 - i];
            Cell cell3 = cellGroups[i - 2][7 - i];
            Cell cell4 = cellGroups[i - 3][8 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 4; i > 2; i--) {
            Cell cell1 = cellGroups[i][4 - i];
            Cell cell2 = cellGroups[i - 1][5 - i];
            Cell cell3 = cellGroups[i - 2][6 - i];
            Cell cell4 = cellGroups[i - 3][7 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }

        for (int i = 3; i > 2; i--) {
            Cell cell1 = cellGroups[i][3 - i];
            Cell cell2 = cellGroups[i - 1][4 - i];
            Cell cell3 = cellGroups[i - 2][5 - i];
            Cell cell4 = cellGroups[i - 3][6 - i];

            boolean condition = isWin(cell1, cell2, cell3, cell4);

            if (condition) {
                Cell[] winningCells = new Cell[] {cell1, cell2, cell3, cell4};

                for (Cell cell : winningCells) {
                    cell.setBackground(new Color(0, 225, 250));
                    win = true;
                }
            }
        }
    }

    private boolean isEmpty() { return getText().equals(" "); }

    private boolean isWin(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        return (cell1.getText().equals("X") && cell2.getText().equals("X") && cell3.getText().equals("X") && cell4.getText().equals("X")) ||
                (cell1.getText().equals("O") && cell2.getText().equals("O") && cell3.getText().equals("O") && cell4.getText().equals("O"));
    }
}