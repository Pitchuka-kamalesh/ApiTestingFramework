package Google.libray;

import utills.BaseClass;


public class Search extends BaseClass {


    public static void main(String[] args) throws InterruptedException {
        launchApp("edge","https://www.google.com");
        Thread.sleep(5000);
        try {
            if(driver.getCurrentUrl().equalsIgnoreCase("https://www.google.com")){
                closeApp();
            }
        }catch (Exception e){
            System.out.println("Some thing went wrong");
            System.out.println(e.getMessage());
        }



    }

}
