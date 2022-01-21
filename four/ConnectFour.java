package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    private final JPanel cellPanel = new JPanel();
    private final JButton resetButton = new JButton("Reset");

    private final Cell[] cells = new Cell[42];
    private static final Cell[] cellsA = new Cell[6];
    private static final Cell[] cellsB = new Cell[6];
    private static final Cell[] cellsC = new Cell[6];
    private static final Cell[] cellsD = new Cell[6];
    private static final Cell[] cellsE = new Cell[6];
    private static final Cell[] cellsF = new Cell[6];
    private static final Cell[] cellsG = new Cell[6];
    public static final Cell[][] cellGroups = {cellsA, cellsB, cellsC, cellsD, cellsE, cellsF, cellsG};

    public ConnectFour() {
        cellPanel.setLayout(new GridLayout(6, 7));
        resetButton.setName("ButtonReset");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect 4");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        createCells();
        setCellGroups();
        placeCells();

        setVisible(true);

        resetButton.addActionListener(e -> {
            Cell.label = "X";
            for (Cell cell: cells) {
                cell.setText(" ");
                cell.setBackground(new Color(200, 200, 200));
                Cell.win = false;
            }
        });
    }

    private void createCells() {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G"};
        int idx = 0;

        for (int i = 6; i > 0; i--) {
            for (String column: columns) {
                String cellName = String.format("Button%s%d", column, i);

                Cell cell = new Cell();
                cell.setText(" ");
                cell.setName(cellName);
                cell.setBackground(new Color(200, 200, 200));

                switch (column) {
                    case "A":
                        cellsA[i - 1] = cell;
                        break;
                    case "B":
                        cellsB[i - 1] = cell;
                        break;
                    case "C":
                        cellsC[i - 1] = cell;
                        break;
                    case "D":
                        cellsD[i - 1] = cell;
                        break;
                    case "E":
                        cellsE[i - 1] = cell;
                        break;
                    case "F":
                        cellsF[i - 1] = cell;
                        break;
                    case "G":
                        cellsG[i - 1] = cell;
                        break;
                    default:
                        break;
                }

                cells[idx] = cell;
                idx += 1;
            }
        }
    }

    private void setCellGroups() {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G"};

        for (String column: columns) {
            for (int i = 0; i < 5; i++) {
                switch (column) {
                    case "A":
                        cellsA[i].next = cellsA[i + 1];
                        break;
                    case "B":
                        cellsB[i].next = cellsB[i + 1];
                        break;
                    case "C":
                        cellsC[i].next = cellsC[i + 1];
                        break;
                    case "D":
                        cellsD[i].next = cellsD[i + 1];
                        break;
                    case "E":
                        cellsE[i].next = cellsE[i + 1];
                        break;
                    case "F":
                        cellsF[i].next = cellsF[i + 1];
                        break;
                    case "G":
                        cellsG[i].next = cellsG[i + 1];
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void placeCells() {
        for (Cell cell: cells) {
            cellPanel.add(cell);
        }
        add(cellPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);
    }
}