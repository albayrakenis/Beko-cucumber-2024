Feature: Satin Alma Islemleri


  @masterpass
  Scenario Outline: Test016- Masterpass
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    Then I sleep for 6 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    Then I sleep for 9 seconds
    When I see "HomePage" page
    Then I wait "search box" element
    Then I wait until element to be clickable and click to "search box" element
    Then I send key to "search box text" element text:"<urun>"
    Then I wait until element to be clickable and click to "search icon" element
    Then I sleep for 3 seconds
    When I see "PLP" page
    Then I sleep for 1 seconds
    And I scroll until find "incele button" element with action
    Then I wait until element to be clickable and click to "incele button" element
    When I see "PDP" page
    Then I sleep for 2 seconds
    And I scroll until find "Sepete At Button" element with action
    Then I wait until element to be clickable and click to "Sepete At Button" element
    Then I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I scroll until find "Sepeti Onayla Button" element with action
    Then I wait until element to be clickable and click to "Sepeti Onayla Button" element
    Then I sleep for 7 seconds
    And I accept on bilgilendirme and satis sozlesmesi
    And I scroll until find "Kredi/Banka Karti" element with action
    Then I sleep for 1 seconds
    Then I wait until element to be clickable and click to "Kredi/Banka Karti" element
    #Then I wait until element to be clickable and click to "farkli kredi kart" element if element exist:10
    And I scroll until find "Masterpass button" element with action
     And I wait until element to be clickable and click to "Masterpass button" element
    When I see "CartPage" page
    And I scroll until find "footer hizmet" element with action
    Then I wait until element to be clickable and click to "alisverisi tamamla button" element
    And I sleep for 4 seconds
    And I send key to "otp code" element text:"201409"
    Then I wait until element to be clickable and click to "submit button" element
    #Then I wait until element to be clickable and click to "yes button" element
    Then I check "basarili siparis text" element text is equal "Bundan sonra ne olacak?"


    Examples:
      | username   | password | url | urun       |
      | kullanici2 | sifre    | url | 8914111200 |
      | kullanici2 | sifre    | url | 8818041200 |
      | kullanici2 | sifre    | url | 7254140210 |

