Feature: Ana sayfa kontrolleri

  @smoke @header @beraber
  Scenario Outline: Test12- Beraber Secelim

    Then I go to "<url>" with configuration
    When I see "HomePage" page
    And I sleep for 2 seconds
    And I scroll until find "Beraber Secelim" element with action
    And I check "Beraber Secelim Text" element text is equal "Beraber Seçelim"
    And I check "Beraber Secelim Kucuk Text" element text is equal "Hangi kategoride ürün arıyorsunuz?"
    And I scroll until find "Beraber Secelim" element with action
    And I sleep for 5 seconds
    Then I wait until element to be clickable and click to "Beraber Secelim" element
    And I change the frame
    And I sleep for 6 seconds
    When I see "BeraberSecelim" page
    And I wait until element to be clickable and click to "BS Beyaz esya" element
    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "BS Derin dondurucu" element
    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "BS cekmeceli" element
    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "BS onemli degil" element
    And I sleep for 5 seconds
    And I scroll until find "BS emin degilim" element with action
    And I sleep for 2 seconds
    And I wait until element to be clickable and click to "BS emin degilim" element
    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "BS devam" element
    And I sleep for 8 seconds
    And I wait until element to be clickable and click to "BS Henuz karar vermedim" element

    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "BS donduruculari getir" element
    And I sleep for 5 seconds
    And I switch to window
    And I sleep for 5 seconds
    And I wait until element to be clickable and click to "Cerezleri kabul et" element
    And I wait "BS Sonuc Sayfasi Derin Dondurucu" element
    And I wait "BS Sonuc Sayfasi Derin Dondurucu Sol Panel" element
    And I sleep for 4 seconds


    Examples:
      | url |
      | url |

