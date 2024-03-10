package TestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

    @DataProvider(name="inputs")
    public Object[][] getData() {
        return new Object[][] {
                {"bmw", "m3"},
                {"audi", "a6"},
                {"benz", "c300"}
                //The #  of test depends of the # of data set (3)
        };
    }
    @Test(dataProvider="inputs")
    public void testMethod1(String input1, String input2) {
        System.out.println("Input 1: " + input1);
        System.out.println("Input 2: " + input2);
    }
}

//if the data provider is in a different class, call it like this
/*

@Test(dataProvider="inputs", dataProviderClass=TestData.class)
public void testMethod1(String input1, String input2) {
    System.out.println("Input 1: " + input1);
    System.out.println("Input 2: " + input2);

     */