package cardenas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController {

    private JFrame frame;
    private Store store;
    private DefaultTableModel tableModel;
    private JMenu iMenu;
    private JMenuItem addTextbookItem;
    private JMenuItem removeTextbookItem;
    private JMenuItem displayTextbookItem;
    private JMenuItem displayAllItem;

    public StoreController() {
        store = new Store();
        initialize();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	StoreController window = new StoreController();
            window.frame.setVisible(true);
        });
    }

    private void initialize() {
        frame = new JFrame("Textbook Inventory Management");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"SKU", "Title", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        iMenu = new JMenu("Inventory");
        menuBar.add(iMenu);

        addTextbookItem = new JMenuItem("Add Textbook");
        addTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTextbook();
            }
        });
        iMenu.add(addTextbookItem);

        removeTextbookItem = new JMenuItem("Remove Textbook");
        removeTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTextbook();
            }
        });
        iMenu.add(removeTextbookItem);

        displayTextbookItem = new JMenuItem("Display Textbook");
        displayTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTextbook();
            }
        });
        iMenu.add(displayTextbookItem);

        displayAllItem = new JMenuItem("Display All Textbooks");
        displayAllItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllTextbooks();
            }
        });
        iMenu.add(displayAllItem);
    }

    private void addTextbook() {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU:"));
            String title = JOptionPane.showInputDialog("Enter Title:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
            String result = store.addTextbook(sku, title, price, quantity);
            JOptionPane.showMessageDialog(frame, result);
    }

    private void removeTextbook() {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU to remove:"));
            String result = store.removeTextbook(sku);
            JOptionPane.showMessageDialog(frame, result);
    }

    private void displayTextbook() {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU to display:"));
            String result = store.infoTextbook(sku);
            JOptionPane.showMessageDialog(frame, result);
    }

    private void displayAllTextbooks() {
        tableModel.setRowCount(0);
        for (Textbook textbook : store.displayAll().values()) {
            tableModel.addRow(new Object[]{textbook.getSku(), textbook.getTitle(), textbook.getPrice(), textbook.getQuantity()});
        }
    }
}