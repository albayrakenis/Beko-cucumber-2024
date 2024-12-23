@qwe
Feature: Contact Page Tests

  Scenario: Contact page element controls
    When I go to url:"https://akamai-s1-astra-stage.beko.com.tr/iletisim"
    When I see "ContactPage" page
    Then I wait "iletisim baslik" element
    And I wait "iletisim formu" element
    And I wait "Ad Soyad" element
    And I wait "E-posta" element
    And I wait "Telefon" element
    And I wait "Mesaj" element
    And I wait "Gönder Butonu" element

  Scenario: Successful form submission
    When I go to url:"https://akamai-s1-astra-stage.beko.com.tr/iletisim"
    When I see "ContactPage" page
    And I send key to "Ad Soyad" element text:"Test User"
    And I send key to "E-posta" element text:"test@email.com"
    And I send key to "Telefon" element text:"5551234567"
    And I send key to "Mesaj" element text:"Test message content"
    And I wait until element to be clickable and click to "KVKK Onay" element
    And I wait until element to be clickable and click to "Gönder Butonu" element
    Then I wait "Başarılı Mesaj" element
    And I check "Başarılı Mesaj" element text is equal "Mesajınız başarıyla gönderildi"

  Scenario: Negative form test - Empty field control
    When I go to url:"https://akamai-s1-astra-stage.beko.com.tr/iletisim"
    When I see "ContactPage" page
    And I wait until element to be clickable and click to "Gönder Butonu" element
    Then I wait "Hata Mesajı" element
    And I check "Hata Mesajı" element text is equal "Lütfen tüm zorunlu alanları doldurunuz"

  Scenario: Negative form test - Invalid email format
    When I go to url:"https://akamai-s1-astra-stage.beko.com.tr/iletisim"
    When I see "ContactPage" page
    And I send key to "Ad Soyad" element text:"Test User"
    And I send key to "E-posta" element text:"invalid.email"
    And I send key to "Telefon" element text:"5551234567"
    And I send key to "Mesaj" element text:"Test message content"
    And I wait until element to be clickable and click to "KVKK Onay" element
    And I wait until element to be clickable and click to "Gönder Butonu" element
    Then I wait "Hata Mesajı" element
    And I check "Hata Mesajı" element text is equal "Geçerli bir e-posta adresi giriniz"
