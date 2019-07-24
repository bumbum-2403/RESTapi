Feature: Rest Calculate Operation
	Scenario: Doing addition
		Given a Rest Api "http://localhost:8080/addition?firstOperand=20&secondOperand=20"
		When invoking the rest API
		Then give result as 40.0
		
