package util;

import helpers.Wait;
import pageobjects.LoginPage;
import step_definitions.BaseClass;


public class Credentials extends BaseClass {
    private LoginPage loginPage = new LoginPage();

    private Wait wait = new Wait();

    public void getCredentials(String credentials) {
//        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
//        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        String cred = System.getProperty("CRED");
        if (credentials.equals("")) {
            if (cred == null) {
                cred = System.getenv("CRED");
                if (cred == null) {
                    cred = "cmsclient";
                }
            }
        }
        else{
            cred = credentials/*.replace(" ","")*/;
        }
        System.out.println("The test is running on " + cred.toUpperCase() + " Credentials");
        switch (cred.toLowerCase()) {
            case "omsclient":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattaparent@exiger.com");
                loginPage.password.sendKeys("Exiger123");
//                loginPage.userName.sendKeys("tdattaparent@exiger.com");
//                loginPage.password.sendKeys("Exiger1!!");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;
            case "cmsclient":
                loginPage.userName.sendKeys("tdattacm@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin12345");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;
            case "cmsclient2":
                loginPage.userName.sendKeys("tdattacm2@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Exiger123");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

/*            case "researcher":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattaresearcher@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin123!12");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;*/

                case "researcher":
                case "titu datta [researcher]":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattaresearcher@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin123!12");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

                case "tim harper":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("timharper@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin123!12");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

                case "test researcherpool":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("testresearcherpool@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin123!12");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "researcher2":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattaresearcher2@exiger.com");
//                loginPage.password.sendKeys("Exiger1!!!");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Admin123!1");
                    } else {
                        loginPage.password.sendKeys("Exiger123");
                    }
                }
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "supervisor":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattasupervisor@exiger.com");
                loginPage.password.sendKeys("Exiger1234");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "reviewer":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("reviewer@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "editor":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("editor@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "auditor":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattaauditor@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "billing":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattabilling@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "controller":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("controller@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "skill":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("automation@exiger.com");
                if(System.getProperty("ENV")==null){
                    loginPage.password.sendKeys("Exiger123");
                }
                else {
                    if (System.getProperty("ENV").contains("stag")) {
                        loginPage.password.sendKeys("Exiger1!!!!");
                    } else {
                        loginPage.password.sendKeys("Exiger1!!!");
                    }
                }

                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "clientAccountManager":
                loginPage.userName.sendKeys("tdattacm@exiger.com");
                loginPage.password.sendKeys("Admin12345");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "clientchild1":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattachild1@exiger.com");
                loginPage.password.sendKeys("Exiger1!!!!");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "clientchild2":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattachild2@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "omsclient2":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattac2@exiger.com");
                loginPage.password.sendKeys("Exiger1!!!");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;


            case "staffing":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("tdattastaffing@exiger.com");
                loginPage.password.sendKeys("Admin12345");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "admin":
                BaseClass.cook = null;
                loginPage.userName.sendKeys("automation@exiger.com");
                loginPage.password.sendKeys("Exiger123");
                loginPage.loginButton.click();
                wait.waitUntilGridSpinnersNotPresent();
                break;

            case "brightlineqa":
                String username = "manager@brightlineqa.com";
//                startingSteps.loginWithCredentials(username, "Admin1234$");
//                wait.waitAndClick(loginPage.threepmloginButton);
                break;
        }
        cook = driver.manage().getCookieNamed(".AspNet.ApplicationCookie");
//        System.out.println("2. cookies - " + cook);
    }
}

