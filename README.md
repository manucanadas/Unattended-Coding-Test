# Unattended Coding Test

## This project consists of three automated tests - this test relies on an API to validate specific data according to three predetermined acceptance criteria.

## The API is:  https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false

## The acceptance criteria used is:

### Name = "Carbon credits"
### CanRelist = true
### The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

## Project Details:

### This is a Maven project, run on Intelli-J

### This project also uses the following:

### REST Assured - used to perform request and response operations
### J-Unit - framework used to run the tests
### Java - Coding language
### Hamcrest - framework to write the matcher objects and match rules used in these tests

## How this code runs:

### There are three class files - BaseTest, TestPathUtil, and CategoriesDetailsTest.

### BaseTest is a class created to have a base URI, separate from the main test area.
### I created this class so that if there are any changes to the base URI, those updates only need to be made in this class and they will be updated for the whole test. 

### TestPathUtil - this class was created to improve the design and performance of the test overall. By creating this class I have generated an editable path in case the categories ID changes. 
### There is also an additional private method contained within the CategoriesDetailsTest class, called getCategoryDetails. This is a method that allows me to keep the class TestBaseUtil separate from the rest of the test code.

### CategoriesDetailsTest is the class where all the tests that validate the acceptance criteria are contained. The tests are below:

### Test validateExactName - this test should if a name from the source API matched the acceptance criteria: Name = “Carbon credits”
### Test validateCanRelist - this test should return a Boolean response for the acceptance criteria: CanRelist = true
### Test ValidatePromotionWithNameGalleryHasCorrectDescription - this test has two set variables I defined myself: “Gallery” and “Good position in category”, that is using JsonPath.params to access the promotion property with the name that I want (in this case it is name = Gallery), and then uses assertions - first to validate that the promotion exists, and then to return the promotion with the expected name.


