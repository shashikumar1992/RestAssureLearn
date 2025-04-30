Feature: Validate All Enrollment APIs with Positive Scenarios.

  #As a user, I want to validate all the enrollment APIs with positive scenarios.
  # So that I can ensure the APIs are working as expected.
  @startEnrollment
  Scenario Outline: Verify the create consumer API response

    Given Register a consumer with partner 'Partner' using details '<fname>', '<lname>', '<gmail>', and '<phoneNumber>'.
    When send the "CREATE_CONSUMER_API" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"
    And Extract "accessToken" and "publicKey" from response


    Examples:
      | fname | lname | gmail | phoneNumber  | message                      |
      | _     | _     | _     | 789-963-4855 | Enrollment status available. |

  @ContinueEnrollment
  Scenario: Verify the continueEnrollment API response
    Given Continue Enrollment with other basic details
    When send the "CONTINUE_ENROLLMENT_API" request with "POST" method
    Then response status code should be "200"
    And response message should be "Account created."

  @PostToWebhookOnIAVExit
  Scenario: Verify the PostToWebhookOnIAVExit API response
    # IAV: Instant Account Verification, CDW: Consumer Data Warehouse
    Given Exit IAV and continue Enrollment with CDW
    When send the "POST_TO_WEBHOOK_ON_IAV_EXIT_API" request with "POST" method
    Then response status code should be "200"
    And response message should be "true"

  @cdwMatchEnrollment
  Scenario Outline: Verify the cdwMatchEnrollment API response
    Given Add account '<AccountNumber>' and routing '<RoutingNumber>' to continue Enrollment
    When send the "CDW_MATCH_ENROLLMENT_API" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"

    Examples:
      | AccountNumber  | RoutingNumber | message                                               |
      | 74737357357353 | 121000358     | Account number and routing number added successfully. |

  @ConfirmCdw
  Scenario Outline: Verify the confirmCdw API response
    Given Add deposit '<DepositAmount>' and withdrawal '<WithdrawalAmount>' to complete Enrollment
    When send the "CONFIRM_CDW_API" request with "POST" method
    Then response status code should be "200"
    And response message should be "<message>"
    # The "enrollment_complete" notification indicates that the enrollment process has been successfully completed.
    And Notification should be "enrollment_complete"

    Examples:
      | DepositAmount | WithdrawalAmount | message                                        |
      | 0.09          | 0.08             | Deposit and Withdrawal match values on record. |



