@DatabaseTests
  Feature: user can verify newly added objects in database


    @VerifyNewlyAddedStoreView
    Scenario: store manager should be able to verify newly added store view in the database
      Given store manager on the Dashboard page
      When store manager creates a new store view 
      Then a new store view should be created
      And store manager is able to verify the store view in the database


