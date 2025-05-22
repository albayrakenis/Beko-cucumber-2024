Feature: Satin Alma Islemleri


  @user2 @smoke @collect @order
  Scenario Outline: Test05- Click and Collect ile Satın Alma
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    Then I sleep for 3 seconds
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
    Then I send key to "search box text" element text:"8818761600"
    #Then I send key to "search box text" element text:"8914691200"
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
    And I scroll until find "Sepeti Onayla Button" element with action
    Then I wait until element to be clickable and click to "Sepeti Onayla Button" element
    Then I sleep for 7 seconds
    Then I wait until element to be clickable and click to "Magazadan Teslim Al" element
    Then I wait until element to be clickable and click to "Seciniz" element
    Then I wait "Teslim Alinabilecek Magazalar" element
    Then I sleep for 3 seconds
    Then I choose city "İSTANBUL" from list for click and collect
    Then I sleep for 3 seconds
    Then I choose town "BAĞCILAR" from list for click and collect
    Then I sleep for 3 seconds
    Then I wait until element to be clickable and click to "Magaza Ara" element
    Then I wait until element to be clickable and click to "Sec" element
    Then I sleep for 3 seconds
    And I wait "Fatura Adresi" element
    Then I sleep for 3 seconds
    And I wait until element to be clickable and click to "Fatura Adresi" element
    And I wait until element to be clickable and click to "Fatura Adresi Secme" element
    Then I sleep for 5 seconds
    When I see "CartPage" page
    Then I sleep for 3 seconds
    And I scroll until find "Kredi/Banka Karti" element with action
    Then I wait until element to be clickable and click to "Kredi/Banka Karti" element
    And I scroll until find "Farkli kredi karti ile ode" element with action
#    Then I wait until element to be clickable and click to "farkli kredi kart" element
    Then I wait until element to be clickable and click to "farkli kredi kart" element if element exist:10
    And I scroll until find "Kart Numarasi Box" element with action
    Then I send key to "Kart Numarasi Box" element text:"4796810000000002"
    And I scroll until find "CVV Box" element with action
    Then I send key to "Kart Sahibi Box" element text:"Enis Albayrak"
    Then I send key to "Kart Tarihi Box" element text:"0130"
    Then I send key to "CVV Box" element text:"030"
    And I accept on bilgilendirme and satis sozlesmesi
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
