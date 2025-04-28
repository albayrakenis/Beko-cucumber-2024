Feature: Satin Alma Islemleri

  @smoke  @order @deleteProduct
  Scenario Outline: Test09- Sepette Urun Sayisi Azaltma
    When I see "HomePage" page
    When I go to "<url>" with configuration
    And I sleep for 5 seconds
    Then I wait "uyelik button" element
    Then I sleep for 3 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    Then I sleep for 5 seconds
    When I see "HomePage" page
    And I wait until element to be clickable and click to "Buzdolabi Button" element
    When I see "PDP" page
    And I scroll until find "Filtrele Button" element with action
    And I wait until element to be clickable and click to "Filtrele Button" element
    And I wait until element to be clickable and click to "Stok Durumu" element
    And I wait until element to be clickable and click to "Var Button" element
    And I wait until element to be clickable and click to "Uygula Button" element
    And I scroll until find "Pdp ilk urun" element with action
    And I wait until element to be clickable and click to "Pdp ilk urun" element
    And I wait until element to be clickable and click to "Sepete At Button" element
    And I wait "Urun sepete eklendi text" element
    And I sleep for 3 seconds
    And I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I wait "Sepet Title" element
    And I wait "sepetteki urun sayisi text" element
    And I wait "arti button" element
    And I wait until element to be clickable and click to "arti button" element
    And I wait "Sepete Eklenen Urun Text" element
    And I wait "Sepeti Bosalt" element
    Then I sleep for 4 seconds
    And I wait "sepetteki urun sayisi text2" element
    Then I sleep for 3 seconds
    And I wait "eksi button" element
    And I wait until element to be clickable and click to "eksi button" element
    And I wait "sepetteki urun sayisi text" element
    Then I sleep for 3 seconds





    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |

