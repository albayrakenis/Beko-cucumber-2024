Feature: Ana sayfa kontrolleri

  @smoke @header @televizyon @rapor
  Scenario Outline: Test04- Televizyon kategorisinde olmasi gereken basliklarin kontrolu
    When I see "HomePage" page
    Then I go to "<url>" with configuration
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    When I see "HomePage" page
    And I wait until element to be clickable and click to "Televizyon" element
    When I see "Televizyon" page
    Then I wait "Televizyon Text;4K Oled;Android TV;4K UHD;Buyuk Ekran;Smart TV;Full HD;" elements
    Then I wait "LED LCD;Ekran Boyutuna Gore TVler;Televizyon Aksesuarlari;" elements
    And I wait "Sol Panel Header Text" element


    Examples:
      | url |
      | url |

