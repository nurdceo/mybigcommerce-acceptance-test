@orderManagement @SmokeTest
Feature: OrderManagement

  Background:
    Given My Web app is displayed successfully with title equals "Cornerstone Demo"

  @CreateOrderGuest
  Scenario Outline: Create an Order as Guest
    Given I have a "<product>" in my cart
    When I complete the checkout process with default details
      | testuser@example.com | Test | User | 101 Love All Street | London | NT11 2TQ | 07100000000 | N/A |
    And I enter my payment detail "<cardNumber>" "<nameOnCard>" "<expiry>" "<cvv>"
    Then I am presented with a purchase confirmation page for my order

    Examples:
      | product       | cardNumber          | nameOnCard | expiry | cvv |
      | Ceramic Sugar | 4111 1111 1111 1111 | Test User  | 0526   | 458 |
