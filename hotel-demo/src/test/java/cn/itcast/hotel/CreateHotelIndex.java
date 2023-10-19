package cn.itcast.hotel;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static cn.itcast.hotel.constants.EsConstants.HOTEL_CONSTANTS;

/**
 * @author zlp
 * @date 2023/10/19 12:02
 */
@SpringBootTest
public class CreateHotelIndex {
    private RestHighLevelClient client;
    @BeforeEach
    public void createClient() {
        this.client = new RestHighLevelClient(
                RestClient.builder(
                        HttpHost.create("http://192.168.88.130:9200")
                )
        );
    }
    @Test
    public void Init() {
        System.out.println(client);
    }
    @Test
    public void testCreateIndex() throws IOException {
        // 创建Request请求
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        // 准备请求的参数, DSL语句
        request.source(HOTEL_CONSTANTS, XContentType.JSON);
        // 发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @AfterEach
    public void closeClient() throws IOException {
        this.client.close();
    }
}
