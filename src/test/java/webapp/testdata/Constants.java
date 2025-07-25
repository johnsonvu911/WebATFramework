package webapp.testdata;

import java.util.Map;

public interface Constants {
    int defaultTimeout = 10000;
    int shortTimeout = 5000;
    int longTimeout = 30000;
    String testSite = "https://johnsonvu911.odoo.com/";
    String loginEmail = "johnsonvu911@gmail.com";
    String loginPassword = "P@ssw0rd";
    String loginButton = "Log in";
    String createButton = "Create";
    String saveButton = "Save";
    String productLocation = "WH/Stock";
    String productQuantity = "2000";
    Map<String, String> Assignees =  Map.of(
            "johnsonvu", "Johnson Vu",
            "tester01", "Tester 01",
            "tester02", "Tester 02"
    );

}
