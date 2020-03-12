package mardld.sitecrawler.configuration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebDriverConfigurationTest {

    @Test
    fun webDriver() {
        val configuration = WebDriverConfiguration(ChromeProperties(setOf("--headless")))
        val driver = configuration.webDriver()

        driver.get("http://delfi.lt")
        assertThat(driver.title).isEqualTo("DELFI Žinios - Pagrindinis naujienų portalas Lietuvoje")
    }
}
