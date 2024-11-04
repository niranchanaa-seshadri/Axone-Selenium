Feature: Verify product is added to cart
  As a user
  I need to be able to purchase a product
  So I need to add it to cart

  Background: pre-requisites
    Given The user has navigated to "http://seleniumpractice.axone-tech.uk/index.php"
    And has logged in with email as "axone.selenium@gmail.com" and password as "password"
    Then There is a saved address under My account -> My addresses


  Scenario: Select a white blouse from New Products (under footer menu) -> Blouses section and add to cart
    Given The user clicks on New products in the footer menu
    And the user clicks on Blouse
    And in the right hand pane, the user selects "white" under colour
    And adds to cart
    Then the product is successfully added to cart

  Scenario: User adds a product to cart and the product is present in the shopping-cart summary page
    Given The user clicks on New products in the footer menu
    And the user clicks on Blouse
    And in the right hand pane, the user selects "white" under colour
    And adds to cart
    When the user clicks on Proceed to checkout in the popup page
    Then the product added is present in the shopping-cart summary page

    Scenario: User adds a product to cart and checks out.
    The My order -> address page is pre-populated with the address
      Given The user clicks on New products in the footer menu
      And the user clicks on Blouse
      And in the right hand pane, the user selects "white" under colour
      And adds to cart
      When the user clicks on Proceed to checkout in the popup page
      And the user clicks on Proceed to checkout in the shopping-cart summary page
      Then the address is automatically populated in the My order - address page

    Scenario: User adds a product to cart and checks out. The shipping details page is populated
      Given The user clicks on New products in the footer menu
      And the user clicks on Blouse
      And in the right hand pane, the user selects "white" under colour
      And adds to cart
      When the user clicks on Proceed to checkout in the popup page
      And the user clicks on Proceed to checkout in the shopping-cart summary page
      And the user clicks on Proceed to checkout in the My order - address page
      Then the user is taken to the shipping details page populated with shipping options

    Scenario: User adds a product to cart and checks out, selects the pay by check option and places order.
    The order reference number shows up correctly in the order history page
      Given The user clicks on New products in the footer menu
      And the user clicks on Blouse
      And in the right hand pane, the user selects "white" under colour
      And adds to cart
      When the user clicks on Proceed to checkout in the popup page
      And the user clicks on Proceed to checkout in the shopping-cart summary page
      And the user clicks on Proceed to checkout in the My order - address page
      Then the user is taken to the shipping details page populated with shipping options
      When the user agrees on terms and conditions and proceeds to checkout
      Then The user is taken to payment page where user clicks on pay by cheque option
      When The user selects "Pound" in the dropdown menu and clicks on I confirm my order
      Then The order confirmation page appears with the order reference number
      When the user clicks on View your order history link in the order confirmation page
      Then the order history page shows up with the correct order reference number

