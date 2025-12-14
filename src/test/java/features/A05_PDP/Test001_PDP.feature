Feature: Satin Alma Islemleri

  Scenario:

  @pdp550
  Scenario Outline: Test001- PDP Kontrol
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait until element to be clickable and click to "Cerezleri kabul et" element
   # And I sleep for 3 seconds
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    When I see "HomePage" page
    And I hover "<header>" header and click "<baslik>" category
    When I see "PDP" page
    And I scroll until find "PLP Kategori Adi" element with action
    And I wait "PLP Kategori Adi" element
    And I scroll until find "Uc nokta" element with action
    And I wait until element to be clickable and click to "Uc nokta" element
   #And I wait until element to be clickable and click to "Favorilerime ekle" element
    And I wait until element to be clickable and click to "Popup kapatma" element
    And I scroll until find "Filtrele Button" element with action
    And I wait "Sirala button" element
    And I wait until element to be clickable and click to "Filtrele Button" element
    And I wait until element to be clickable and click to "Stok Durumu" element
    And I sleep for 3 seconds
    And I scroll until find "Var Button" element with action
    And I wait until element to be clickable and click to "Var Button" element
    And I wait until element to be clickable and click to "Uygula Button" element
    And I scroll until find "Pdp ilk urun" element with action
    And I wait until element to be clickable and click to "Pdp ilk urun" element
    And I wait "Sepete At Button;Evime ne zaman ulasir;Favorilere ekle kalp" elements
    And I scroll until find "urun teknik ozellikleri" element with action
    And I wait "Genel bakis;Teknik ozellikleri;Hangi magazada var;Taksit secenekleri;Yorumlar" elements
    And I wait until element to be clickable and click to "Hangi magazada var" element
    And I wait "il;ilce;Magaza bul;En yakin" elements

    Examples:
      | header         | baslik             | url      |

      | isitma sogutma | Klima              | urlCanli |
      | isitma sogutma | Kombi              | urlCanli |
      | isitma sogutma | Termosifon         | urlCanli |
      | isitma sogutma | Elektrikli Isitici | urlCanli |
      | isitma sogutma | ic Hava Kalitesi   | urlCanli |
      | isitma sogutma | Hava Sogutucu      | urlCanli |
      | isitma sogutma | Vantilator         | urlCanli |
      | isitma sogutma | Nem Alma Cihazi    | urlCanli |
      | isitma sogutma | Tum Urunler        | urlCanli |


  @pdp55
  Scenario Outline: Test001- PDP Kontrol
    When I see "HomePage" page
    When I go to "<url>" with configuration
    Then I wait until element to be clickable and click to "Cerezleri kabul et" element
   # And I sleep for 3 seconds
    Then I wait "uyelik button" element
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    When I see "HomePage" page
    And I hover "<header>" header and click "<baslik>" category
    When I see "PDP" page
    And I scroll until find "PLP Kategori Adi" element with action
    And I wait "PLP Kategori Adi" element
    And I scroll until find "Uc nokta" element with action
    And I wait until element to be clickable and click to "Uc nokta" element
    And I sleep for 2 seconds
    And I wait until element to be clickable and click to "Popup kapatma" element
    And I scroll until find "Filtrele Button" element with action
    And I wait "Sirala button" element
    And I wait until element to be clickable and click to "Filtrele Button" element
    And I wait until element to be clickable and click to "Stok Durumu" element
    And I sleep for 3 seconds
    And I wait until element to be clickable and click to "Var Button" element
    And I wait until element to be clickable and click to "Uygula Button" element
    And I sleep for 5 seconds
    And I scroll until find "Pdp ilk urun" element with action
    And I wait until element to be clickable and click to "Pdp ilk urun" element
    And I wait "Sepete At Button;Evime ne zaman ulasir;Favorilere ekle kalp" elements
    And I scroll until find "urun teknik ozellikleri" element with action
    And I wait "Genel bakis;Teknik ozellikleri;Hangi magazada var;Taksit secenekleri;Yorumlar" elements
    And I wait until element to be clickable and click to "Hangi magazada var" element
    And I wait "il;ilce;Magaza bul;En yakin" elements

    Examples:
      | header         | baslik                     | url      |
      | Beyaz Esya     | Buzdolabi                  | urlCanli |
      | Beyaz Esya     | Derin Dondurucu            | urlCanli |
      | Beyaz Esya     | Bulasik Makinesi           | urlCanli |
      | Beyaz Esya     | Camasir Makinesi           | urlCanli |
      | Beyaz Esya     | Kurutma Makinesi           | urlCanli |
      | Beyaz Esya     | Kurutmali Camasir Makinesi | urlCanli |
      | Beyaz Esya     | Firin                      | urlCanli |
      #| Beyaz Esya     | Mikrodalga                 | urlCanli |
      #| Beyaz Esya     | Set Ustu                   | urlCanli |
      #| Beyaz Esya     | Su Sebili                  | urlCanli |
      | Beyaz Esya     | Tum Urunler beyaz esya     | urlCanli |

      | Ankastre       | Ankastre Firin             | urlCanli |
      | Ankastre       | Ankastre Mikro Dalgalar    | urlCanli |
      #| Ankastre       | Ankastre Ocaklar           | urlCanli |
      | Ankastre       | Ankastre Davlumbazlar      | urlCanli |
      #| Ankastre       | Ankastre Aspiratorler      | urlCanli |
      #| Ankastre       | Ankastre Bulasik Makinesi  | urlCanli |
      | Ankastre       | Ankastre Buzdolabi         | urlCanli |
      #| Ankastre       | Tum Urunler ankastre       | urlCanli |

      #| Televizyon     | 4K OLED TV                 | urlCanli |
      | Televizyon     | Google TV                  | urlCanli |
      | Televizyon     | Android TV                 | urlCanli |
      | Televizyon     | 4K UHD TV                  | urlCanli |
      #| Televizyon     | Buyuk Ekran TV             | urlCanli |
      | Televizyon     | Smart TV                   | urlCanli |
      | Televizyon     | Full HD TV                 | urlCanli |
      | Televizyon     | LED & LCD TV               | urlCanli |
      | Televizyon     | Tum Urunler televizyon     | urlCanli |

      #| Elektronik     | Cep Telefonu               | urlCanli |
      #| Elektronik     | Cep Telefonu Aksesuarlar   | urlCanli |
      | Elektronik     | Giyilebilir Teknoloji      | urlCanli |
      #| Elektronik     | Bilgisayar                 | urlCanli |
      #| Elektronik     | Goruntu Sistemleri         | urlCanli |
      | Elektronik     | Odeme Sistemleri           | urlCanli |
      #| Elektronik     | Hobi - Oyun                | urlCanli |
      | Elektronik     | Tum Urunler elektronik     | urlCanli |



      | isitma sogutma | Kombi                      | urlCanli |
      #| isitma sogutma | Termosifon                 | urlCanli |
      ##| isitma sogutma | Elektrikli Isitici         | urlCanli |
      #| isitma sogutma | ic Hava Kalitesi           | urlCanli |
      #| isitma sogutma | Hava Sogutucu              | urlCanli |
      #| isitma sogutma | Vantilator                 | urlCanli |
      #| isitma sogutma | Nem Alma Cihazi            | urlCanli |
      #| isitma sogutma | Tum Urunler isitma sogutma | urlCanli |



      #| KEA            | Elektrikli Supurge         | urlCanli |
      #| KEA            | Utu                        | urlCanli |
      #| KEA            | Kahve Makinesi             | urlCanli |
      #| KEA            | Cay Makinesi               | urlCanli |
      #| KEA            | Semaver                    | urlCanli |
     # | KEA            | Kettle                     | urlCanli |
    #  | KEA            | Kati Meyve Sikacagi        | urlCanli |
     # | KEA            | Narenciye Sikacagi         | urlCanli |
     # | KEA            | Karistirici Dograyici      | urlCanli |
     # | KEA            | Pisirici                   | urlCanli |
      #| KEA            | Kisisel Bakim              | urlCanli |
     # | KEA            | Uv Temizleme Cihazi        | urlCanli |
     # | KEA            | Outdoor Ekipman            | urlCanli |
     # | KEA            | Tum Urunler kea            | urlCanli |


  @pdp2
  Scenario Outline: Test001- PDP Kontrol
    When I see "HomePage" page
    When I go to "<url>" with configuration
    And I sleep for 5 seconds
    Then I wait "uyelik button" element
    Then I sleep for 3 seconds
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "urunler button" element
    Then I sleep for 5 seconds
    When I see "HomePage" page
    And I hover "<header>" header and click "<baslik>" category
    When I see "PDP" page
    And I scroll until find "Uc nokta" element with action
    And I wait until element to be clickable and click to "Uc nokta" element
   #And I wait until element to be clickable and click to "Favorilerime ekle" element
    And I wait until element to be clickable and click to "Popup kapatma" element
    And I scroll until find "Filtrele Button" element with action
    And I wait until element to be clickable and click to "Filtrele Button" element
    And I wait until element to be clickable and click to "Stok Durumu" element
    And I wait until element to be clickable and click to "Var Button" element
    And I wait until element to be clickable and click to "Uygula Button" element
    And I sleep for 4 seconds
    And I scroll until find "Pdp ilk urun" element with action
    And I wait until element to be clickable and click to "Pdp ilk urun" element
    And I wait "Sepete At Button;Evime ne zaman ulasir;Favorilere ekle kalp" elements
    And I scroll until find "urun teknik ozellikleri" element with action
    #And I wait "Genel bakis;Teknik ozellikleri;Hangi magazada var;Taksit secenekleri;Yorumlar" elements
    #And I wait until element to be clickable and click to "Hangi magazada var" element
    #And I wait "il;ilce;Magaza bul;En yakin" elements

    Examples:
      | header         | baslik                     | url |
      | Beyaz Esya     | Buzdolabi                  | url |
      | Beyaz Esya     | Derin Dondurucu            | url |
      | Beyaz Esya     | Bulasik Makinesi           | url |
      | Beyaz Esya     | Camasir Makinesi           | url |
      | Beyaz Esya     | Kurutma Makinesi           | url |
      | Beyaz Esya     | Kurutmali Camasir Makinesi | url |
      | Beyaz Esya     | Firin                      | url |
      | Beyaz Esya     | Mikrodalga                 | url |
      | Beyaz Esya     | Set Ustu                   | url |
      | Beyaz Esya     | Su Sebili                  | url |
      | Beyaz Esya     | Tum Urunler beyaz esya     | url |
      | Ankastre       | Ankastre Firin             | url |
      | Ankastre       | Ankastre Mikro Dalgalar    | url |
      | Ankastre       | Ankastre Ocaklar           | url |
      | Ankastre       | Ankastre Davlumbazlar      | url |
      | Ankastre       | Ankastre Aspiratorler      | url |
      | Ankastre       | Ankastre Bulasik Makinesi  | url |
      | Ankastre       | Ankastre Buzdolabi         | url |
      | Ankastre       | Tum Urunler ankastre       | url |
      | Televizyon     | 4K OLED TV                 | url |
      | Televizyon     | Google TV                  | url |
      | Televizyon     | Android TV                 | url |
      | Televizyon     | 4K UHD TV                  | url |
      | Televizyon     | Buyuk Ekran TV             | url |
      | Televizyon     | Smart TV                   | url |
      | Televizyon     | Full HD TV                 | url |
      | Televizyon     | LED & LCD TV               | url |
      | Televizyon     | QLED                       | url |
      | Televizyon     | Tum Urunler televizyon     | url |
      | Elektronik     | Cep Telefonu               | url |
      | Elektronik     | Cep Telefonu Aksesuarlar   | url |
      | Elektronik     | Giyilebilir Teknoloji      | url |
      | Elektronik     | Bilgisayar                 | url |
      | Elektronik     | Goruntu Sistemleri         | url |
      | Elektronik     | Odeme Sistemleri           | url |
      | Elektronik     | Hobi - Oyun                | url |
      | Elektronik     | Tum Urunler elektronik     | url |
      | isitma sogutma | Klima                      | url |
      | isitma sogutma | Kombi                      | url |
      | isitma sogutma | Termosifon                 | url |
      | isitma sogutma | Elektrikli Isitici         | url |
      | isitma sogutma | ic Hava Kalitesi           | url |
      | isitma sogutma | Hava Sogutucu              | url |
      | isitma sogutma | Vantilator                 | url |
      | isitma sogutma | Nem Alma Cihazi            | url |
      | isitma sogutma | Tum Urunler isitma sogutma | url |
      | KEA            | Elektrikli Supurge         | url |
      | KEA            | Utu                        | url |
      | KEA            | Kahve Makinesi             | url |
      | KEA            | Cay Makinesi               | url |
      | KEA            | Semaver                    | url |
      | KEA            | Kettle                     | url |
      | KEA            | Kati Meyve Sikacagi        | url |
      | KEA            | Narenciye Sikacagi         | url |
      | KEA            | Karistirici Dograyici      | url |
      | KEA            | Pisirici                   | url |
      | KEA            | Kisisel Bakim              | url |
      | KEA            | Uv Temizleme Cihazi        | url |
      | KEA            | Outdoor Ekipman            | url |
      | KEA            | Tum Urunler kea            | url |



