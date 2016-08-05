import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.java.*
import java.io.FileInputStream
import java.util.*

val repos = repos()

fun versionFor(directory: String): String {
	val p = Properties().apply { FileInputStream("${directory}/test.properties").use { fis -> load(fis) } }
	return p.getProperty("version", "")
}
	
	
val example = project {

    name = "example"
    group = "com.example"
    artifactId = name
    version = versionFor(directory)

    sourceDirectories {
        path("src/main/java")
    }

    sourceDirectoriesTest {
        path("src/test/java")
    }

    dependencies {
//        compile("com.beust:jcommander:1.48")
    }

    dependenciesTest {
        compile("org.testng:testng:")

    }

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.Main"
    }
}

val example2 = project {

    directory = "example2"
    name = "example2"
    group = "com.example"
    artifactId = name
    version = versionFor(directory)

    sourceDirectories {
        path("src/main/java")
    }

    sourceDirectoriesTest {
        path("src/test/java")
    }

    dependencies {
//        compile("com.beust:jcommander:1.48")
    }

    dependenciesTest {
        compile("org.testng:testng:")

    }

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.Main"
    }
}
