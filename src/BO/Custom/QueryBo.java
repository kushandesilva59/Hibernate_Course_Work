package BO.Custom;

import BO.SuperBo;
import TM.StudentPaymentTM;
import javafx.collections.ObservableList;

public interface QueryBo extends SuperBo {
    public ObservableList<StudentPaymentTM> getToBePayStudents();
}
