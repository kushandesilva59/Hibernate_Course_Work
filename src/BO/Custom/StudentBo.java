package BO.Custom;

import Dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBo {
    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(StudentDto dto) throws SQLException, ClassNotFoundException;

    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException;

    public StudentDto search(String studentId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String studentId) throws SQLException, ClassNotFoundException ;

    public boolean delete(String studentId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException ;
}
