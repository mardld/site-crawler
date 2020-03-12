package mardld.sitecrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SiteCrawlerApplication

fun main(args: Array<String>) {
    runApplication<SiteCrawlerApplication>(*args)
}
