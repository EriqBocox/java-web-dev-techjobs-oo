package org.launchcode.techjobs_oo.tests;

import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Job;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class JobTest {
    Job test_job;
    Job test_job_2;
    Job empty_field_1;
    Job empty_field_2;
    Job empty_field_3;
    Job empty_field_4;
    Job empty_field_5;
    Job empty_field_all;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

//    @Before
//    public void createJobOjbect (){
//        Job test_job = new Job("Web Dev", employer, location, positionType, coreCompetency);
//        Job test_job_2 = new Job("Web Dev 2", employer,location, positionType, coreCompetency);
//    }
//    @Test
//    public void testSettingJobId(){
//        assertFalse("This is false", test_job.getId()==test_job_2.getId());
//    }
//    @Before
//    public void testJobConstructorSetsAllFields() {
//        test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//    }
//    @Test
//    public void testID() {
//        assertEquals(1, test_job.getId());
//    }
//    @Test
//    public void testName(){
//        assertEquals("Product tester", test_job.getName());
//    }
//    @Test
//    public void testEmployer(){
//        assertEquals("ACME", test_job.getEmployer().toString());
//    }
//    @Test
//    public void testLocation(){
//        assertEquals("Desert", test_job.getLocation().toString());
//    }

    @Before
    public void createJobObject(){
        test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job_2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        empty_field_1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        empty_field_2 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        empty_field_3 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        empty_field_4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        empty_field_5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        empty_field_all = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(1, test_job.getId());
        assertEquals("Product tester", test_job.getName());
        assertEquals("ACME", test_job.getEmployer().toString());
        assertEquals("Desert", test_job.getLocation().toString());
        assertEquals("Quality control", test_job.getPositionType().toString());
        assertEquals("Persistence", test_job.getCoreCompetency().toString());
        assertEquals(2, test_job_2.getId());
        assertTrue(test_job instanceof Job);
    }
    @Test
    public void testJobsForEquality(){
        int firstID = test_job.getId();
        int secondID = test_job_2.getId();
        assertFalse (test_job.equals(test_job_2));
        assertFalse (firstID == secondID);
    }
    @Test
    public void testBlankLine(){
        String testString = test_job.toString();
        assertTrue(testString.startsWith("\n"));
        assertTrue(testString.endsWith("\n"));
    }
    @Test
    public void testLabels(){
        String testString = test_job.toString();
        int firstID = test_job.getId();
        String jobID = String.valueOf(firstID);

        assertTrue(testString.contains("ID: "));
        assertTrue(testString.contains(jobID));
        assertTrue(testString.contains("Name: "));
        assertTrue(testString.contains("Product tester"));
        assertTrue(testString.contains("Employer: "));
        assertTrue(testString.contains("ACME"));
        assertTrue(testString.contains("Location: "));
        assertTrue(testString.contains("Desert"));
        assertTrue(testString.contains("Position Type: "));
        assertTrue(testString.contains("Quality control"));
        assertTrue(testString.contains("Core Competency: "));
        assertTrue(testString.contains("Persistence"));
    }
    @Test
    public void testEmptyFieldName(){
        String emptyString = empty_field_1.toString();
        assertTrue(emptyString.contains("Data not available"));
    }
    @Test
    public void testEmptyFieldEmployer(){
        String emptyString = empty_field_2.toString();
        assertTrue(emptyString.contains("Data not available"));
    }
    @Test
    public void testEmptyFieldLocation(){
        String emptyString = empty_field_3.toString();
        assertTrue(emptyString.contains("Data not available"));
    }
    @Test
    public void testEmptyFieldPositionType(){
        String emptyString = empty_field_4.toString();
        assertTrue(emptyString.contains("Data not available"));
    }
    @Test
    public void testEmptyFieldCoreCompetency(){
        String emptyString = empty_field_5.toString();
        assertTrue(emptyString.contains("Data not available"));
    }
    @Test
    public void testAllEmptyFields(){
        String emptyString = empty_field_all.toString();
        assertTrue(emptyString.contains(("OOPS! This job does not seem to exist.")));
    }


}
