#Author:/*@author Chindhu Babu*/
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Unscramble word
  Scenario Outline: Unscramble the given word
    Given a word to unscramble is given <scrambleword>
    When find all combinations
    And check word using dictionary
    Then unscramble word combination resultset
    Examples:
     | scrambleword  |
     | "Work"  |
     | "Rock"  |
     | "Socks" |
     | "glass" |
     | "Working" |
      
