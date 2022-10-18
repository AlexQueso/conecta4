package conecta4.views.graphics;

import conecta4.types.Error;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CoordinatePutView extends CoordinateView {

    private Integer column;

    CoordinatePutView() {
        super();
        this.resetCoordinate();
        this.titleLabel = new JLabel(ENTER_COORDINATE_TO_PUT);
        this.add(titleLabel, new Constraints(0, 0, 1, 1));
        this.button = new JButton(CoordinateView.ACCEPT);
        this.add(button, new Constraints(0, 5, 1, 1));
        this.button.addActionListener(this);
        this.button.addKeyListener(this);
    }

    void resetCoordinate() {
        this.column = -1;
    }

    int getColumn() {
        return this.column;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Error error = Error.NULL;
        Integer column = null;
        try {
            column = Integer.parseInt(this.textFieldColumn.getText()) - 1;
        } catch(NumberFormatException exception) {
            System.out.println("The input is not a number.");
        }
        if (column == null) {
            error = Error.NOT_NUMERIC_COLUMN;
        } else if (column < 0 || column > 7) {
            error = Error.WRONG_COLUMN;
        }
        if (error.isNull()) {
            this.column = column;
        } else {
            JOptionPane.showMessageDialog(null, error.toString(), "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        this.textFieldColumn.setText("");
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
