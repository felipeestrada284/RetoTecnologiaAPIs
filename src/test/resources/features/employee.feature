Feature: employee

  @Post
  Scenario: Create new record in database
    When I consume the service and I send employee information
    Then I can validate the service response message

  @Get
  Scenario: Get a single employee data
    When I consume the service and send employee id
    Then I can validate the service response message

  @Put
  Scenario: Update an employee record
    When I consume the service and I send employee information
    Then I can validate the service response message

  @Delete
  Scenario: Delete an employee record
    When I consume the service and I send employee information
    Then I can validate the service response message