package Project10.Tests;

import Project10.Solution.Data;
import Project10.Solution.LibraryApp;
import Project10.Solution.Users.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.time.LocalDate;

public class MyTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();



    @Test

    public void test1() {
        systemInMock.provideLines("acbd", "C");
        LibraryApp.main(null);
    }
    @Test
    public void test2() {
        systemInMock.provideLines("", "C");
        LibraryApp.main(null);
    }

    @Test
    public void test3() {
        systemInMock.provideLines("1000", "0");
        LibraryApp.main(null);
        User exp=LibraryApp.getActiveUser();
        User act=Data.getUserMap().get(1000);
        Assert.assertEquals(exp,act);
    }


    @Test
    public void test4() {
        systemInMock.provideLines("2001", "0");
        LibraryApp.main(null);
        User actual=Data.getUserMap().get(2001);
        Assert.assertEquals("Ali",actual.getName());

    }


    @Test
    public void test5() {
        systemInMock.provideLines("3002", "0");
        LibraryApp.main(null);
        User actual=Data.getUserMap().get(3002);
        Assert.assertEquals("Glazkov",actual.getLastName());
    }

    @Test
    public void test6() {
        systemInMock.provideLines("2002","1", "10002","0" );
        LibraryApp.main(null);
        String actual1=Data.getUserMap().get(2002).getName();
        String actual2=Data.getUserMap().get(2002).getLastName();
        Integer actual3=Data.getUserMap().get(2002).getUserId();
        Integer excpected3=2002;
        Assert.assertEquals("Cool",actual1);
        Assert.assertEquals("Teacher",actual2);
        Assert.assertEquals(excpected3,actual3);

    }


    @Test
    public void test7() {
        systemInMock.provideLines("3002","1", "20000","0" );
       LibraryApp.main(null);
        LocalDate excpected= LocalDate.now().plusDays(14);
        LocalDate actualdata= Data.getBookMap().get(20000).getDueDate();
        Assert.assertEquals(excpected,actualdata);

    }

    @Test
    public void test8() {
        systemInMock.provideLines("2000","1", "10000","0" );
        LibraryApp.main(null);
        LocalDate excpected= LocalDate.now().plusDays(21);
        LocalDate actualdata= Data.getBookMap().get(10000).getDueDate();
        Assert.assertEquals(excpected,actualdata);
    }
    @Test
    public void test9() {
        systemInMock.provideLines("1000","1", "10002","0" );
        LibraryApp.main(null);
        LocalDate excpected= LocalDate.now().plusDays(30);
        LocalDate actual= Data.getBookMap().get(10002).getDueDate();
        Assert.assertEquals(excpected,actual);
    }


    @Test
    public void test10(){
        systemInMock.provideLines("1001","1", "90001","0" );
        LibraryApp.main(null);
        Assert.assertNull(Data.getBookMap().get(90001).getBorrower());

    }

    @Test
    public void test11(){
        systemInMock.provideLines("2000","1", "jadgj","0" );
        LibraryApp.main(null);

    }

    @Test
    public void test12(){
        systemInMock.provideLines("2000","1", "10000","2", "10000","0" );
        LibraryApp.main(null);
        boolean actual= LibraryApp.getActiveUser().getBookList().containsKey(10000);
        Assert.assertFalse(actual);

    }

    @Test
    public void test13(){
        systemInMock.provideLines("1001","5", "10000", "2002", "2", "10000","0" );
        LibraryApp.main(null);
        boolean actual= LibraryApp.getActiveUser().getBookList().containsKey(10000);
        Assert.assertFalse(actual);

    }
    @Test
    public void test14(){
        systemInMock.provideLines("1001","5", "20000", "2001","0" );
        LibraryApp.main(null);
        String actual1=Data.getUserMap().get(2001).getName();
        String actual2=Data.getUserMap().get(2001).getLastName();
        Integer actual3=Data.getUserMap().get(2001).getUserId();
        Integer excpected3=2001;
        Assert.assertEquals("Ali",actual1);
        Assert.assertEquals("Veli",actual2);
        Assert.assertEquals(excpected3,actual3);

    }

    @Test
    public void test15(){
        systemInMock.provideLines("1000","5", "90000", "3002","0" );
        LibraryApp.main(null);
        Assert.assertNull(Data.getBookMap().get(90000).getBorrower());

    }

    @Test
    public void test16(){
        systemInMock.provideLines("1000","3","2","Lohn","Smith","2065", "0" );
        LibraryApp.main(null);
        boolean actual= Data.getUserMap().containsKey(2065);
        Assert.assertTrue(actual);

    }

    @Test
    public void test17(){
        systemInMock.provideLines("1000","3","3","Lohn","Smith","3065", "0" );
        LibraryApp.main(null);
        Assert.assertTrue(Data.getUserMap().containsKey(3065));

    }
    @Test
    public void test18(){
        systemInMock.provideLines("1000","3","1","Lohn","Smith","1066", "0" );
        LibraryApp.main(null);
        boolean actual= Data.getUserMap().containsKey(1066);
        Assert.assertTrue(actual);

    }
    @Test
    public void test19(){
        systemInMock.provideLines("1000","3","3","Lohn","Smith","5065","3065", "0" );
       // LibraryApp.main(null);
        Assert.assertFalse(Data.getUserMap().containsKey(5065));

    }

    @Test
    public void test20(){
        systemInMock.provideLines("1000","3","2","Lohn","Smith","2065", "0" );
     //   LibraryApp.main(null);
       int actual=Data.getUserMap().get(2065).getMAX_DAYS();
        Assert.assertEquals(21,actual);

    }
    @Test
    public void test21(){
        systemInMock.provideLines("1000","3","2","Lohn","Smith","2065", "0" );
     //   LibraryApp.main(null);
        int actual=Data.getUserMap().get(2065).getMAX_DAYS();
        Assert.assertEquals(21,actual);

    }
    @Test
    public void test22(){            //Librarian can create a new Book (Fiction)
        systemInMock.provideLines("1000","4","1","10065","Crime and Punishment","Fyodor Dostoyevsky","0" );
        LibraryApp.main(null);
        Assert.assertTrue(Data.getBookMap().containsKey(10065));

    }

    @Test
    public void test23(){            //initial value of the status (isCheckedOut variable) of a book when created is false.
        systemInMock.provideLines("1000","4","1","10065","Crime and Punishment","Fyodor Dostoyevsky","0" );
      //  LibraryApp.main(null);
        Assert.assertFalse(Data.getBookMap().get(10065).isCheckedOut());

    }

    @Test
    public void test24(){
        systemInMock.provideLines("3001","1","10000","1","10001","1","10002","1","20000","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(3001).getBookList().containsKey(20000);
        Assert.assertFalse(actual);

    }
    @Test
    public void test25(){
        systemInMock.provideLines("3002","1","10000","1","10000","1","10000","1","10002","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(3002).getBookList().containsKey(10002);
        Assert.assertFalse(actual);

    }
    @Test
    public void test26(){
        systemInMock.provideLines("2001","1","10000","1","10001","1","10002","1","20000","1","20001","1","20002","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(2001).getBookList().containsKey(20002);
        Assert.assertFalse(actual);

    }
    @Test
    public void test27(){
        systemInMock.provideLines("2000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10001","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(2000).getBookList().containsKey(10001);
        Assert.assertFalse(actual);

    }
    @Test
    public void test28(){
        systemInMock.provideLines("1001","1","10000","1","10001","1","10002","1","20000","1","20001","1","20002","1","20003","1","20004","1","20005","1","20006","1","20007","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(1001).getBookList().containsKey(20007);
        Assert.assertFalse(actual);

    }

    @Test
    public void test29(){
        systemInMock.provideLines("1000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10000","1","10001","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(1000).getBookList().containsKey(10001);
        Assert.assertFalse(actual);

    }

    @Test
    public void test30(){
        systemInMock.provideLines("1000","5","10000","3000","5","10001","3000","5","10002","3000","5","20000","3000","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(3000).getBookList().containsKey(20000);
        Assert.assertFalse(actual);

    }
    @Test
    public void test31(){
        systemInMock.provideLines("1000","5","10000","3000","5","10000","3000","5","10000","3000","5","10001","3000","0" );
        LibraryApp.main(null);
        boolean actual=Data.getUserMap().get(3000).getBookList().containsKey(10001);
        Assert.assertFalse(actual);

    }



}
