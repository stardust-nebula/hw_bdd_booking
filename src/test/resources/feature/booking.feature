Feature: Search on booking.com

  @Smoke
  Scenario: Search by city criteria
    Given User is looking for hotel in 'London' city
    When User does search
    Then Hotel 'Yotel London Shoreditch' should be on the first page

  Scenario Outline: Search by different cities criteria
    Given User is looking for hotel in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the page

    Examples:
      | City       | Hotel                                        |
      | London     | Yotel London Shoreditch                      |
      | Madrid     | Morar Apartments MalasañaOpens in new window |
      | Washington | citizenM Washington DC Capitol               |


  Scenario: Search by city and check rating
    Given User is looking for hotel in 'London' city
    When User does search
    Then Hotel 'Yotel London Shoreditch' should be on the first page And rating is '7.7'

  Scenario Outline: Search by city and check rating
    Given User is looking for hotel in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page And rating is '<Rating>'

    Examples:
      | City   | Hotel                                              | Rating |
      | London | The Camden Arms - Bright and Charming 2BDR Flat    | 10     |
      | London | TOP FLOOR NOTTING-HILL CENTRAL!Opens in new window | 8      |

  @Smoke
  Scenario: Search by city and check rating
    Given User is looking for hotel in 'London' city
    When User does search
    Then Hotel 'Yotel London Shoreditch' should be on the first page
    And Rating is '7.7'