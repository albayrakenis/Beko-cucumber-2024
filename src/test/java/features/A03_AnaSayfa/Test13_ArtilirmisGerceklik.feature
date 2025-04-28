Feature: Ana sayfa kontrolleri

  @smoke @header @AR
  Scenario Outline: Test13- Artırılmis Gerceklik


    Then I go to "<url>" with configuration
    When I see "HomePage" page
    And I sleep for 2 seconds
    Then I wait "search box" element
    Then I wait until element to be clickable and click to "search box" element
    Then I send key to "search box text" element text:"<urun kodu>"
    Then I wait until element to be clickable and click to "search icon" element
    When I see "PLP" page
    Then I sleep for 1 seconds
    And I scroll until find "incele button" element with action
    Then I wait until element to be clickable and click to "incele button" element
    When I see "HomePage" page
    And I wait "360 image" element
#    And I wait until element to be clickable and click to "360 image" element
#    And I sleep for 2 seconds
#    And I wait "360 image active" element
#    And I wait until element to be clickable and click to "360 image active" element
    And I scroll until find "AR text" element with action
    And I check "AR text" element text is equal "Artırılmış Gerçeklik (AR) deneyimine hoş geldiniz!"
    And I check "AR aciklama" element text is equal "Artırılmış Gerçeklik özelliği sayesinde Beko ürünlerini bulunduğunuz ortamda sanal olarak görüntüleyebilirsiniz. (AR) ile görüntülemek için cep telefonunuzdan siteye giris yapmanız gerekmektedir."



    Examples:
      | url | urun kodu  |
      | url | 7757189237 |
      | url | 7778220274 |
      | url | 7779420224 |
      | url | 8818991200 |
      | url | 8818601200 |