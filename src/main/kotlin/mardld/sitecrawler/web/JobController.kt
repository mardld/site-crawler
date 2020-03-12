package mardld.sitecrawler.web

import com.jayway.jsonpath.JsonPath
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.openqa.selenium.WebDriver
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class JobController(
        private val driver: WebDriver
) {

    @GetMapping("/title")
    fun getTitle(@RequestParam url: String): String {
        driver.get(url)
        return driver.title
    }

    @GetMapping("/requested-domains")
    fun getRequestedDomains(@RequestParam url: String): Set<String> {
        driver.get(url)
        return driver.manage().logs()["performance"].all
                .asSequence()
                .map { JsonPath.parse(it.message) }
                .filter { "Network.requestWillBeSent" == it.read("$['message'].method") }
                .map { it.read("$['message']['params']['request'].url") as String }
                .map { it.toHttpUrlOrNull() }
                .filterNotNull()
                .map { it.host }
                .toSet()
    }

}
