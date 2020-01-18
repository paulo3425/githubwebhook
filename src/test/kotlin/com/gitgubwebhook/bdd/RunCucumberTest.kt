package com.gitgubwebhook.bdd

import com.githubwebhook.config.AppConfig
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = ["classpath:features"], glue = ["com/gitgubwebhook/bdd/stepdef"])
class RunCucumberTest{


}