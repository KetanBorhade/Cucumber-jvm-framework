Feature: todo scenarios

Scenario: Verify elements gets added to list
Given user is on todo Home Page
When user enters text "Abcd" in todo list
Then value "Abcd" is added in todo list
When user enters text "Xyz" in todo list
When user enters text "Pqr" in todo list
Then list values are as followed "Abcd,Xyz,Pqr" in todo list
When select "Abcd" from todo list
Then list values are as followed "Abcd,Xyz,Pqr" in todo list
When user click on link "Active" in todo list
Then list values are as followed "Xyz,Pqr" in todo list
When user click on link "Completed" in todo list
Then value "Abcd" is added in todo list
When click button "Clear completed" from todo list
Then value "Abcd" is not displayed in todo list

Scenario: Verify items gets listed in active list
Given user is on todo Home Page
When user enters text "Xyz" in todo list
When user enters text "Pqr" in todo list
When user click on link "Active" in todo list
Then list values are as followed "Xyz,Pqr" in todo list


Scenario: Verify remove element functionality
Given user is on todo Home Page
When user enters text "Abcd" in todo list
When user enters text "Xyz" in todo list
When user enters text "Pqr" in todo list
Then value "Abcd" is added in todo list
When remove value "Abcd" from todo list
Then list values are as followed "Xyz,Pqr" in todo list


