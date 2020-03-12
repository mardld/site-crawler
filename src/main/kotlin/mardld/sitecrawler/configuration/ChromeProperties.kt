package mardld.sitecrawler.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties("chrome")
@Component
data class ChromeProperties(
        var options: Set<String>
)
