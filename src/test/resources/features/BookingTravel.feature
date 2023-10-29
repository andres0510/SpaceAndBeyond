Feature: Booking speace travel on Space & Beyond

  Scenario Outline: Book a travel on Space and Beyond using a filter
    Given a group of travelers logged on Space and Beyond
    When the journey information is entered
    And destination is selected by using "<filter>" filter
    Then the travel is successfully scheduled
    Examples:
    |filter|
    |launch|
    |color |
    |price |
