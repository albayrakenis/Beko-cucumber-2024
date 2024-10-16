Feature: Ana sayfa kontrolleri

  @smoke @header @markalar
  Scenario Outline: Test10- Markalar kategorisinde olmasi gereken basliklarin kontrolu
    When I see "HomePage" page
    Then I go to url:"<url>"
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    When I see "HomePage" page
    And I wait until element to be clickable and click to "Markalar" element
    When I see "Markalar" page
    Then I wait "Apple;Celly;Grundig;Huawei;Hypergear;Lenovo;Philips;Samsung;" elements
    Then I sleep for 1 seconds


    Examples:
      | url                                        |
      | https://akamai-s1-astra-stage.beko.com.tr/ |

