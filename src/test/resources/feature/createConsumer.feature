Feature: Validate All Enrollment API With positive Scenario.

  @startEnrollment
  Scenario Outline: Verify the create consumer API response
    Given Register a consumer with partner 'Partner' using consumer details '<fname>', '<lname>', '<gmail>', and '<phoneNumber>'.
    When send the "createConsumerAPI" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"
    And Extract "accessToken" and "publicKey" from response

    Examples: 
      | fname  | lname | gmail          | phoneNumber  | message                                                                                                       |
      | _      | _     | _              | 789-963-4855 | Enrollment status available.                                                                                  |

  @continueEnrollment
  Scenario: Verify the continueEnrollment API response
    Given Continue Enrollment with other basic details
    When send the "continueEnrollmentAPI" request with "POST" method
    Then response status code should be "200"
    And response message should be "Account created."

  @PostToWebhookOnIAVExit
  Scenario: Verify the PostToWebhookOnIAVExit API response
    Given Exit IAV and continue Enrollment with CDW
    When send the "PostToWebhookOnIAVExitAPI" request with "POST" method
    Then response status code should be "200"
    And response message should be "true"

  @cdwMatchEnrollment
  Scenario Outline: Verify the cdwMatchEnrollment API response
    Given Adding "<AccountNumber>" and "<RoutingNumber>" continue Enrollment
    When send the "cdwMatchEnrollmentAPI" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"

    Examples: 
      | AccountNumber   | RoutingNumber | message                                               |
      | 74737357357353 |     121000358 | Account number and routing number added successfully. |

  @confirmCdw
  Scenario Outline: Verify the confirmCdw API response
    Given Adding "<DepositAmount>" and "<WithdrawalAmount>" complete Enrollment
    When send the "confirmCdwAPI" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"
    And Notification should be "enrollment_complete"

    Examples: 
      | DepositAmount | WithdrawalAmount | message                                        |
      |          0.09 |             0.08 | Deposit and Withdrawal match values on record. |
