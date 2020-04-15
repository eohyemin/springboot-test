package com.demo.community;

import com.demo.community.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class BookJsonTest {
    @Autowired
    private JacksonTester<Book> json;

    @Test
    public void json_Test() throws Exception {
        Book book = Book.builder().title("테스트").build();
        String content = "{\"title\":\"테스트\"}";

        // 문자열을 객체로 변환해 테스트
        assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
        assertThat(this.json.parseObject(content).getPublishedAt()).isNull();

        // 객체를 문자열로 변환, 각 필드를 변환한 문자열이 test.json 파일과 일치하는지 확인
        assertThat(this.json.write(book)).isEqualToJson("/test.json");
        assertThat(this.json.write(book)).hasJsonPathStringValue("title");
        assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");
    }
}
