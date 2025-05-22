Feature: Satin Alma Islemleri


  @smoke  @order @mainMenuAddBasket
  Scenario Outline: Test07- Main Menuden Sepete Urun Ekleme
    When I see "HomePage" page
    When I go to "<url>" with configuration
    And I sleep for 5 seconds
    Then I wait "uyelik button" element
    Then I sleep for 8 seconds
    When I see "HomePage" page
    And I scroll until find "Anasayfa kahve makinesi" element with action
    And I wait until element to be clickable and click to "Anasayfa kahve makinesi" element
    When I see "PDP" page
    And I wait until element to be clickable and click to "Sepete At Button" element
    And I wait "Urun sepete eklendi text" element
    And I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I wait "Sepet Title" element
    And I wait "Sepete Eklenen Urun Text" element
    And I check "Sepete Eklenen Urun Text" element text is equal "CEG 7304 X CaffeExperto® Tam Otomatik"
    And I wait "Sepeti Bosalt" element
    Then I sleep for 10 seconds





    Examples:
      | url                                        |
      | url |
