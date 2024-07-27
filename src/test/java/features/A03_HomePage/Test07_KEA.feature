Feature: Ana sayfa kontrolleri

  @smoke @header @kea
  Scenario Outline: Test07- KEA kategorisinde olmasi gereken basliklarin kontrolu
    When I see "HomePage" page
    Then I go to url:"<url>"
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    When I see "HomePage" page
    And I wait until element to be clickable and click to "KEA" element
    When I see "KEA" page
    Then I wait "KEA Text;Icecek Hazirlama;Karistirici Dograyici;Pisirici;Supurge" elements
    Then I wait "Kahve Makinesi Aksesuarlari;Yogurt Makinesi;Utu" elements
    And I wait "Sol Panel Header Text" element
    Then I sleep for 2 seconds


    Examples:
      | url                                        |
      | https://akamai-s1-astra-stage.beko.com.tr/ |

