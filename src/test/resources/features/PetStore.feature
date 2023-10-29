Feature: Verifying Pet Store REST API

  Scenario: Search new pet
    Given a new animal in Pet Store
    When the pet is consulted
    Then it is found