Feature: Satin Alma Islemleri

  @smoke  @order @pdpAddBasket
  Scenario Outline: Test06- PDP den Sepete Urun Ekleme
    When I see "HomePage" page
    When I go to "<url>" with configuration
    And I sleep for 5 seconds
    Then I wait "uyelik button" element
    Then I sleep for 3 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    Then I sleep for 2 seconds
    When I see "HomePage" page
    And I wait until element to be clickable and click to "<kategori>" element
    When I see "PDP" page
    Then I scroll until find "Filtrele Button" element with action
    And I wait until element to be clickable and click to "Filtrele Button" element
    And I wait until element to be clickable and click to "Stok Durumu" element
    And I wait until element to be clickable and click to "Var Button" element
    And I wait until element to be clickable and click to "Uygula Button" element
    Then I sleep for 4 seconds
    And I scroll until find "Pdp ilk urun" element with action
    And I wait until element to be clickable and click to "Pdp ilk urun" element
    And I sleep for 5 seconds
    And I scroll until find "Sepete At Button" element with action
    And I wait until element to be clickable and click to "Sepete At Button" element
    And I wait "Urun sepete eklendi text" element
    And I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I wait "Sepet Title" element
    And I wait "Sepete Eklenen Urun Text" element
    Then I sleep for 4 seconds
    And I wait "Sepeti Bosalt" element
    And I wait until element to be clickable and click to "Sepeti Bosalt" element
    Then I sleep for 4 seconds





    Examples:
      | url |kategori|
      | url |Camasir Makinesi Button|
      | url |Buzdolabi Button|
      | url |Bulasik Makinesi|
      #| url |Kurutma Makinesi button|

