Feature: employee

  @Post
  Scenario: Create new record in database
    When I consume the service and I send employee information
    Then I can validate the service response post

  @Get
  Scenario: Get a single employee data
    When I consume the service and send employee id
    Then I can validate the service response get


  @Put
  Scenario: Update an employee record
    When I consume the service and send the employee information and the id
    Then I can validate the service response put

  @Delete
  Scenario: Delete an employee record
    When I consume the service delete and I send employee id
    Then I can validate the service response delete

  @GetAll
  Scenario: Get all employee data
    When I consume the service get employees
    Then I can validate the service response get all