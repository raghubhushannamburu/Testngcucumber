package com.automation.stepdef;

import com.automation.base.Base;
import com.automation.implementaion.Implementation;
import com.automation.utils.Elements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDef {
	Implementation impl=new Implementation();
	Elements element=new Elements();
	
	@Given("I navigate and login to internet herokuapp website$")
	public void i_NavigateToApplication() throws Throwable {
		Base.navigatetoautomationanywhere();
	}
	
	@And("I click A/BTesting link$")
	public void IclickABTestinglink(){
		impl.IclickABTestinglink();
	}


	@Then("^I click on dropdown link$")
	public void Iclickondropdownlink() {
		impl.Iclickondropdownlink();
	}


	@Then("^I click on frames$")
	public void Iclickonframes()  {
         impl.Iclickonframes();
	}




	
	
	
	
	

}
