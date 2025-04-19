@2611
Feature: Kullanici islemleri


  @user @smoke @adresSil @regresyon
  Scenario Outline: Test00- Onceki Adresleri Silme
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    #Then I sleep for 3 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    Then I sleep for 7 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "hesabim button" element
    Then I sleep for 10 seconds
    When I see "HesabimPage" page
    And  I delete saved adress


    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |


  @user @smoke @loginSuccess @regresyon
  Scenario Outline: Test01- Basarili Giris
    When I go to "<url>" with configuration
    When I see "HomePage" page
    Then I wait "uyelik button" element
    #Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    When I see "HomePage" page
    And I wait "urunler button" element
    And I sleep for 4 seconds
    And I wait "hesabim button" element


    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |


  @user @smoke @loginSuccess @regresyon
  Scenario Outline: Test01- Basarili Giris
    When I go to "<url>" with configuration
    When I see "HomePage" page
    Then I wait "uyelik button" element
    #Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    When I see "HomePage" page
    And I wait "urunler button" element
    #And I sleep for 4 seconds
    And I wait "hesabim button" element


    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |


  @user @smoke @yanlissifre2 @regresyon
  Scenario Outline: Test02- Yanlis Sifre ile Giris Denemesi

    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    #Then I sleep for 5 seconds
    And I wait until element to be clickable and click to "Cerezleri kabul et" element if element exist:1
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I send key to "username" element text:"<username>"
    Then I send key to "password" element text:"<passwordWrong>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    Then I check "login hata mesaji" element text is equal "E-posta adresiniz ya da şifreniz yanlış"


    Examples:
      | username             | passwordWrong | url |
      | kullanici1@gmail.com | Albayra41     | url |
     # | abcd@gmail.com       | Albayra41     | url |
     # | 1234@gmail.com       | Albayra41     | url |


  @user @smoke @yanlisSifre @regresyon
  Scenario Outline:Test03- Yanlis Kullanici Adi ile Giriş Denemesi
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    #Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I send key to "username" element text:"<usernameWrong>"
    Then I send key to "password" element text:"<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    Then I check "login hata mesaji" element text is equal "E-posta adresiniz ya da şifreniz yanlış"


    Examples:
      | usernameWrong         | password  | url |
      | beko.s1test@gmail.com | Albayra41 | url |
      | beko.s1test@gmail.com | 1234      | url |
      | beko.s1test@gmail.com | abcd      | url |


  @userAdres @smoke @regresyon @user
  Scenario Outline:Test04-  Adres Ekleme

    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    #Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    #Then I sleep for 7 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "hesabim button" element
    #Then I sleep for 2 seconds
    When I see "HesabimPage" page
    Then I wait "urunlerim;siparislerim;bildirimlerim;taleplerim;favorilerim;stok habercim;kuponlarim;hediye ceklerim;bilgilerim;cikis yap" elements
    #Then I sleep for 2 seconds
    And I scroll until find "yeni adres ekle button" element with action
    #Then I sleep for 2 seconds
    Then I wait until element to be clickable and click to "yeni adres ekle button" element
    When I see "AdresPage" page
    Then I check "Adres Bilgileri Text" element text is equal "Adres Bilgileri"
    Then I wait "Bireysel;Kurumsal;Ad Soyad;Telefon;il;ilce;Mahalle;Adres Detaylari;Adres Adi" elements
    Then I send key to "Ad Soyad" element text:"Enis Albayrak"
    Then I send key to "Telefon" element text:"5751552594"
    Then I send key to "Adres Detaylari" element text:"Kosova Mahallesi Veysel karani caddesi no 162"
    Given I create a adress that is start "Ev adresim" and end with number 100 between 100000
    Then I choose city "KONYA" from list
    Then I choose town "SELÇUKLU" from list
    Then I choose neighborhood "<mahalle>" from list
    #Then I sleep for 2 seconds
    Then I wait until element to be clickable and click to "Adres Kaydet" element
    #Then I sleep for 1 seconds


    Examples:
      | username   | password | url | mahalle      |
      | kullanici1 | sifre    | url | KOSOVA       |
      | kullanici1 | sifre    | url | DOKUZ        |
      | kullanici1 | sifre    | url | BOSNA HERSEK |
      | kullanici1 | sifre    | url | GAZALI       |


  @userAdres2 @smoke @regresyon @user
  Scenario Outline:Test05- Kurumsal Adres Ekleme

    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    Then I sleep for 1 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    #Then I sleep for 10 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "hesabim button" element
    #Then I sleep for 10 seconds
    When I see "HesabimPage" page
    Then I wait "urunlerim;siparislerim;bildirimlerim;taleplerim;favorilerim;stok habercim;kuponlarim;hediye ceklerim;bilgilerim;cikis yap" elements
    And I scroll until find "yeni adres ekle button" element with action
    Then I wait until element to be clickable and click to "yeni adres ekle button" element
    When I see "AdresPage" page
    Then I check "Adres Bilgileri Text" element text is equal "Adres Bilgileri"
    Then I wait "Bireysel;Kurumsal;Ad Soyad;Telefon;il;ilce;Mahalle;Adres Detaylari;Adres Adi" elements
    Then I wait until element to be clickable and click to "Kurumsal" element
    Then I send key to "Firma Adi" element text:"Albayrak AŞ"
    Then I send key to "Vergi Numarasi" element text:"3579247337"
    Then I choose taxCity "ANKARA-EVREN" from list
    Then I send key to "Telefon" element text:"5751552594"
    Then I choose city "KONYA" from list
    Then I choose town "SELÇUKLU" from list
    Then I choose neighborhood "KOSOVA" from list
    Then I send key to "Adres Detaylari" element text:"Kosova Mahallesi Veysel karani caddesi no 162"
    Given I create a adress that is start "is adresim" and end with number 100 between 100000
   # Then I sleep for 1 seconds
    Then I wait until element to be clickable and click to "Adres Kaydet" element
    #Then I sleep for 1 seconds


    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |


  @userAdres25 @smoke @regresyon @user
  Scenario Outline: Test06- Ad Soyad Güncelleme

    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait "uyelik button" element
    #Then I sleep for 1 seconds
    Then I wait until element to be clickable and click to "uyelik button" element
    When I see "LoginPage" page
    Then I wait "username" element
    Then I wait "password" element
    Then I login with "<username>" and "<password>"
    And I scroll until find "giris yap" element with action
    Then I wait until element to be clickable and click to "giris yap" element
    Then I sleep for 10 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "hesabim button" element
    #Then I sleep for 10 seconds
    When I see "HesabimPage" page
    Then I wait "uyelik bilgileri;Adiniz;Soyadiniz;Cinsiyet;Dogum Tarihi;TC no;Telefon Numarasi;Email" elements
    Then I clear "Adiniz" textbox
    Then I send key to "Adiniz" element random "name"
    And I clear "Soyadiniz" textbox
    Then I send key to "Soyadiniz" element random "surname"
    Then I scroll down until find "kisiler bilgiler onay" element
    Then I wait until element to be clickable and click to "Kaydet Button" element
    #Then I sleep for 3 seconds




    Examples:
      | username   | password | url |
      | kullanici1 | sifre    | url |



    @bildirim @smoke
    Scenario Outline: Test07- Bildirimler

      When I see "HomePage" page
      When I go to "<url>" with configuration
      Then I wait "uyelik button" element
    #Then I sleep for 1 seconds
      Then I wait until element to be clickable and click to "uyelik button" element
      When I see "LoginPage" page
      Then I wait "username" element
      Then I wait "password" element
      Then I login with "<username>" and "<password>"
      And I scroll until find "giris yap" element with action
      Then I wait until element to be clickable and click to "giris yap" element
      Then I sleep for 10 seconds
      When I see "HomePage" page
      Then I wait until element to be clickable and click to "hesabim button" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "bildirimler" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "tumunu gor" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "bildirimler" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "tumunu gor" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "bildirimler" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "tumunu gor" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "bildirimler" element
      Then I sleep for 2 seconds
      Then I wait until element to be clickable and click to "tumunu gor" element







      Examples:
        | username   | password | url |
        | kullanici1 | sifre    | url |