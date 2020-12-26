package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidatorX implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        try {
            double parsedValue = Double.parseDouble(value.toString());
            if (!(parsedValue > -3 && parsedValue < 3)) {
                FacesMessage message = new FacesMessage(
                        "Введено некорректное значение X",
                        "Диапазон X:(-3 ... 3)");
                throw new ValidatorException(message);
            }
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage("Введено некорректное значение X", "X должен быть числом");
            throw new ValidatorException(message);
        }
    }
}
