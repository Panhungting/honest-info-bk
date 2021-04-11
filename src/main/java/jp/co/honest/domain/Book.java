package jp.co.honest.domain;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bookId;
    private String title;
    private String price;
    private String summary;
}