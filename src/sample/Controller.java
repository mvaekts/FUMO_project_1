package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    public TextField FieldA;
    public TextField FieldX;
    public TextField FieldB;
    public TextField FieldResult;
    public Button closeButton;
    public AnchorPane MainPane;

    public void OnExitClick(MouseEvent mouseEvent)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void SolveClick(MouseEvent mouseEvent)
    {
        double a, b, x;
        try
        {
            a = Double.parseDouble(FieldA.getText());
            b = Double.parseDouble(FieldB.getText());
            x = Double.parseDouble(FieldX.getText());
        }
        catch (Exception e)
        {
            FieldResult.setText("Неверный формат введенных данных!");
            return;
        }

        double sumOfSqr = a * a + b * b;
        double result = 0;
        if (x <= 7)
        {
            if (sumOfSqr != 0)
                result = (x + 4) / sumOfSqr;
            else
            {
                FieldResult.setText("Деление на 0!");
                return;
            }
        }
        else
            result = x * sumOfSqr;

        FieldResult.setText(Double.toString(result));
    }

    public void ClearClick(MouseEvent mouseEvent)
    {
        MainPane.getChildren()
                .filtered(ch -> ch instanceof TextField)
                .forEach(ch -> ((TextField)ch).clear());
    }
}
