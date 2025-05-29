Feature: Satin Alma Islemleri

  @user2 @smoke @guestOrder @order
  Scenario Outline: Test13- Guest, Kredi Karti ile Satın Alma
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait "search box" element
    Then I wait until element to be clickable and click to "search box" element
    Then I send key to "search box text" element text:"<urunKodu>"
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
    When I see "LoginPage" page
    And I scroll until find "Uye olmadan devam et button" element with action
    Then I wait "Uye olmadan devam et button" element
    Then I wait until element to be clickable and click to "Uye olmadan devam et button" element
    And I create a mail that is start "kullaniciAdi" and end with "@gmail.com"
    Then I wait until element to be clickable and click to "Uye olmadan devam et button mail" element
    When I see "CartPage" page
    And I sleep for 15 seconds
    Then I wait until element to be clickable and click to "Teslimat adresi seciniz" element
    And I scroll until find "Yeni Adres Ekle Guest" element with action
    Then I sleep for 2 seconds
    Then I wait until element to be clickable and click to "Yeni Adres Ekle Guest" element
    When I see "AdresPage" page
    Then I check "Adres Bilgileri Text" element text is equal "Adres Bilgileri"
    Then I wait "Bireysel;Kurumsal;Ad Soyad;Telefon;il;ilce;Mahalle;Adres Detaylari;Adres Adi" elements
    Then I send key to "Ad Soyad" element text:"Enis Albayrak"
    Then I send key to "Telefon" element text:"5071552594"
    Then I send key to "Adres Detaylari" element text:"Kosova Mahallesi Veysel karani caddesi no 162"
    Given I create a adress that is start "Ev adresim" and end with number 100 between 100000
    Then I choose city "KONYA" from list
    Then I choose town "SELÇUKLU" from list
    Then I choose neighborhood "KOSOVA" from list
    Then I sleep for 2 seconds
    Then I wait until element to be clickable and click to "Adres Kaydet" element
    And I sleep for 5 seconds
#    And I send key to "Tc kimlik" element text:"49646044276"
    And I accept on bilgilendirme and satis sozlesmesi
    And I scroll until find "Kredi/Banka Karti" element with action
    Then I wait until element to be clickable and click to "Kredi/Banka Karti" element
    Then I wait until element to be clickable and click to "farkli kredi kart" element if element exist:10
    And I scroll until find "Kart Numarasi Box" element with action
    Then I send key to "Kart Numarasi Box" element text:"4796810000000002"
    And I scroll until find "CVV Box" element with action
    Then I send key to "Kart Sahibi Box" element text:"Enis Albayrak"
    Then I send key to "Kart Tarihi Box" element text:"0130"
    Then I send key to "CVV Box" element text:"030"
    When I see "CartPage" page
    And I scroll until find "footer hizmet" element with action
    Then I wait until element to be clickable and click to "alisverisi tamamla button" element
    And I send key to "otp code" element text:"201409"
    Then I wait until element to be clickable and click to "submit button" element
    #Then I wait until element to be clickable and click to "yes button" element
    Then I check "basarili siparis text" element text is equal "Bundan sonra ne olacak?"




    Examples:
      | url | urunKodu   |
#      | url | 7629810277 |
      | url | 8819111600 |

