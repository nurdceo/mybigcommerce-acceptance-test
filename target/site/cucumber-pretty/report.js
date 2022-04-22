$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OrderManagement.feature");
formatter.feature({
  "line": 2,
  "name": "OrderManagement",
  "description": "",
  "id": "ordermanagement",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@orderManagement"
    },
    {
      "line": 1,
      "name": "@SmokeTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Create an Order as Guest",
  "description": "",
  "id": "ordermanagement;create-an-order-as-guest",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@CreateOrderGuest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I have a \"\u003cproduct\u003e\" in my cart",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I complete the checkout process with default details",
  "rows": [
    {
      "cells": [
        "testuser@example.com",
        "Test",
        "User",
        "101 Love All Street",
        "London",
        "NT11 2TQ",
        "07100000000",
        "N/A"
      ],
      "line": 11
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I enter my payment detail \"\u003ccardNumber\u003e\" \"\u003cnameOnCard\u003e\" \"\u003cexpiry\u003e\" \"\u003ccvv\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I am presented with a purchase confirmation page for my order",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "ordermanagement;create-an-order-as-guest;",
  "rows": [
    {
      "cells": [
        "product",
        "cardNumber",
        "nameOnCard",
        "expiry",
        "cvv"
      ],
      "line": 16,
      "id": "ordermanagement;create-an-order-as-guest;;1"
    },
    {
      "cells": [
        "Ceramic Sugar",
        "4111 1111 1111 1111",
        "Test User",
        "0526",
        "458"
      ],
      "line": 17,
      "id": "ordermanagement;create-an-order-as-guest;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "My Web app is displayed successfully with title equals \"Cornerstone Demo\"",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 17,
  "name": "Create an Order as Guest",
  "description": "",
  "id": "ordermanagement;create-an-order-as-guest;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@orderManagement"
    },
    {
      "line": 7,
      "name": "@CreateOrderGuest"
    },
    {
      "line": 1,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I have a \"Ceramic Sugar\" in my cart",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I complete the checkout process with default details",
  "rows": [
    {
      "cells": [
        "testuser@example.com",
        "Test",
        "User",
        "101 Love All Street",
        "London",
        "NT11 2TQ",
        "07100000000",
        "N/A"
      ],
      "line": 11
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I enter my payment detail \"4111 1111 1111 1111\" \"Test User\" \"0526\" \"458\"",
  "matchedColumns": [
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I am presented with a purchase confirmation page for my order",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});