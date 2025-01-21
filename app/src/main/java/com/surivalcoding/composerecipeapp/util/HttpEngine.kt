import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}

class ApiClient(engine: HttpClientEngine = CIO.create()) {
    private val httpClient = HttpClient(engine) {
    }

    fun create(): HttpClient {
        return httpClient
    }
}


