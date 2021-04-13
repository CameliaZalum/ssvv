package com.mycompany.app;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import UI.ui;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class GradeTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addStudentTestCase1()
    {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        String[] params={"22","nume1","1","email@mail.com","prof"};
        try {
            stsrv.add(params);
            assertTrue(true);
        } catch (ValidatorException e){
            assertTrue(false);
        }
    }
   
    @Test
    public void addAssignmentTestCase1 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentValid={"1", "descriere", "6", "4"};
        try {
            homeworkService.add(parametersAddAssignmentValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addGradeTestCase1 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddGradeValid={"1","22","6","4", "feedback", "9"};
        try {
            addStudentTestCase1();
            addAssignmentTestCase1();
            gradeService.add(parametersAddGradeValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
  
}
