@PlaceOrder
Feature: User wants to place an order

Scenario: Search item
Given User is on Home Page
When User search an Item "Parry Hotter"
Then Item must be listed

Scenario: Add Item to Cart
Given Item must be listed
When User Add item
Then Item should be added to cart

Scenario: Checkout
Given Item should be added to cart
When user do the checkout
Then Should display checkout page

