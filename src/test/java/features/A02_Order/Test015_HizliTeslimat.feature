Feature: Satin Alma Islemleri


  @smoke @ @order @hizliTeslimat
  Scenario Outline: Test15- Hizli teslimat ile Satın Alma
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    Then I sleep for 8 seconds
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
    Then I send key to "search box text" element text:"8813101200"
    Then I wait until element to be clickable and click to "search icon" element
    Then I sleep for 3 seconds
    When I see "PLP" page
    Then I sleep for 1 seconds
    And I scroll until find "incele button" element with action
    Then I wait until element to be clickable and click to "incele button" element
    When I see "PDP" page
    Then I wait until element to be clickable and click to "Sepete At Button" element
    Then I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I scroll until find "Sepeti Bosalt" element with action
    Then I wait until element to be clickable and click to "Sepeti Bosalt" element
    Then I check "Sepetinizde Henuz Urun Yok Text" element text is equal "Sepetinizde henüz ürün yok."
    When I see "HomePage" page
    Then I wait "search box" element
    Then I wait until element to be clickable and click to "search box" element
    Then I send key to "search box text" element text:"8818501200"
    Then I wait until element to be clickable and click to "search icon" element
    Then I sleep for 3 seconds
    When I see "PLP" page
    Then I sleep for 1 seconds
    And I scroll until find "incele button" element with action
    Then I wait until element to be clickable and click to "incele button" element
    When I see "PDP" page
    Then I wait until element to be clickable and click to "Sepete At Button" element
    Then I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    Then I sleep for 3 seconds
    And I scroll until find "Sepeti Onayla Button2" element with action
    Then I wait until element to be clickable and click to "Sepeti Onayla Button2" element
    Then I sleep for 4 seconds
    And I accept on bilgilendirme and satis sozlesmesi
    And I wait until element to be clickable and click to "Magazayi kendim secmek istiyorum" element
    Then I sleep for 3 seconds
    Then I choose city "İSTANBUL" and town "BAĞCILAR" from fast delivery list
    And I wait until element to be clickable and click to "Magaza Ara Fast" element
    And I wait until element to be clickable and click to "ilk magaza" element
    And I wait until element to be clickable and click to "Uygula" element
    And I wait "Degistir" element
    And I wait "Carpi button" element
    And I scroll until find "Kredi/Banka Karti" element with action
    Then I sleep for 1 seconds
    Then I wait until element to be clickable and click to "Kredi/Banka Karti" element
    Then I wait until element to be clickable and click to "farkli kredi kart" element if element exist:5
    And I scroll until find "Kart Numarasi Box" element with action
    Then I send key to "Kart Numarasi Box" element text:"4796810000000002"
    And I scroll until find "CVV Box" element with action
    Then I send key to "Kart Sahibi Box" element text:"Enis Albayrak"
    Then I send key to "Kart Tarihi Box" element text:"0130"
    Then I send key to "CVV Box" element text:"030"
    When I see "CartPage" page
    And I scroll until find "footer hizmet" element with action
    Then I wait until element to be clickable and click to "alisverisi tamamla button" element
    And I sleep for 4 seconds
    And I send key to "otp code" element text:"201409"
    Then I wait until element to be clickable and click to "submit button" element
    #Then I wait until element to be clickable and click to "yes button" element
    Then I check "basarili siparis text" element text is equal "Bundan sonra ne olacak?"


    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |

