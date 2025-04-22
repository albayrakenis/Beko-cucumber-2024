Feature: Ana menü kontrolleri

  @smoke @populer @main @rapor
  Scenario Outline: Test04- Populer urunler
    When I see "HomePage" page
    Then I go to "<url>" with configuration
    Then I wait "uyelik button" element
    Then I sleep for 3 seconds
    When I see "HomePage" page
    And I scroll until find "populer urun 1" element with action
    And I wait "En Cok Satanlar" element
    And I wait until element to be clickable and click to "En Cok Satanlar" element

    And I sleep for 5 seconds



    Examples:
      | url |
      | url |

