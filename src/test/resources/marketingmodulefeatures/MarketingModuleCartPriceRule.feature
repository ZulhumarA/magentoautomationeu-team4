@CartPriceRuleTest
  Feature: Marketing Manager can add ,filter,Update cart price rule

    @AddNewCartPriceRule
    Scenario: Marketing Manager can add new Cart Price rule
      Given Marketing Manager on the dashboard page
      When Marketing manager add a New cart price rule
      Then the New price rule should be added

      @FilterCartPriceRule
      Scenario: Marketing Manager can filter new Cart Price rule
        Given Marketing Manager on the dashboard page
        When Marketing Manager filter shopping cart pricing rule by id and Rule
        Then the shopping cart pricing rule should be filtered

        @UpdateCartPriceRule
        Scenario: Marketing Manager can filter new Cart Price rule
          Given Marketing Manager on the dashboard page
          When Marketing manager update the shopping cart rule
          Then Shopping cart rule should be updated
