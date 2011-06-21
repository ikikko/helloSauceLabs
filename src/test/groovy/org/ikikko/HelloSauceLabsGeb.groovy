package org.ikikko

import geb.junit4.GebTest

import org.ikikko.pages.DashboardPage
import org.ikikko.pages.LoginPage
import org.ikikko.pages.ProjectPage
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

@RunWith(JUnit4)
class HelloSauceLabsGeb extends GebTest {

	final def USERNAME = 'XXXXXXXX'
	final def ACCESS_KEY = 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'

	@Override
	WebDriver createDriver() {
		def dc = new DesiredCapabilities([
					browserName: 'firefox',
					version: '3.6.',
					platform: Platform.WINDOWS,

					username: USERNAME,
					accessKey: ACCESS_KEY,
					name: "Hello, Sauce OnDemand with Geb!",
				])

		new RemoteWebDriver(new URL('http://ondemand.saucelabs.com:80/wd/hub'), dc)
	}

	// @Afterだと、このメソッドが呼び出された後にsuperclassの@Afterが呼び出されてdriverでNPEが発生する
	@Override
	void clearBrowserCookies() {
		super.clearBrowserCookies()

		browser.driver.quit()
	}

	@Test
	void "ログインして1番目のプロジェクトの最新課題にコメントする"() {

		// ログインページ
		to LoginPage
		assert at(LoginPage)
		userId = 'demo'
		password = 'demo'
		submit.click()

		// ダッシュボードページ
		waitFor { at(DashboardPage) }
		firstProject.click()

		// プロジェクトページ
		waitFor { at(ProjectPage) }
		//		firstIssue.click()

		// 課題ページ
		//		waitFor { at(IssuePage) }
		//		comment.value("Test for SauceLab with Geb! : ${new Date()}")
		//		submit.click()

	}

}
