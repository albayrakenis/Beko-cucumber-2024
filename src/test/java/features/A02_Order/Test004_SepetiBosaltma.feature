Feature: Satin Alma Islemleri

  @smoke  @order @clearbasket
  Scenario Outline: Test04- Sepeti Bosaltma
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
    Then I sleep for 15 seconds
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
    Then I wait until element to be clickable and click to "Sepete At Button" element
    Then I wait until element to be clickable and click to "Sepete Git Button" element
    When I see "CartPage" page
    And I scroll until find "Sepeti Bosalt" element with action
    Then I wait until element to be clickable and click to "Sepeti Bosalt" element
    Then I check "Sepetinizde Henuz Urun Yok Text" element text is equal "Sepetinizde henüz ürün yok."





    Examples:
      | username   | password | url | urun       |
      | kullanici1 | sifre    | url | 8912281200 |
#      | kullanici1 | sifre    | url | 7966021600 |
#      | kullanici1 | sifre    | url | 7966021600 |
#      | kullanici1 | sifre    | url | 8808871200 |
      | kullanici1 | sifre    | url | 8832671200 |
      | kullanici1 | sifre    | url | 8916151200 |

