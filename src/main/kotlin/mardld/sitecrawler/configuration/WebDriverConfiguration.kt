package mardld.sitecrawler.configuration

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.logging.Level


@Configuration
class WebDriverConfiguration(
        val chromeProperties: ChromeProperties
) {

    @Bean
    fun webDriver(): WebDriver {
        val options = ChromeOptions()
        options.addArguments(chromeProperties.options.toList())
        options.setCapability("goog:loggingPrefs", getLoggingPreferences())
        return ChromeDriver(options)
    }

    private fun getLoggingPreferences(): LoggingPreferences {
        val preferences = LoggingPreferences()
        preferences.enable(LogType.PERFORMANCE, Level.ALL)
        return preferences
    }

}
