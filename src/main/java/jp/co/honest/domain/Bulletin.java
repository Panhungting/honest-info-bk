package jp.co.honest.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bulletin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bulletinId;
    private String category;
    private String title;
    private String content;
    private String publishDate;
    private String expiry;
    private Integer publisFlag;
    private LocalDateTime createdAt;
}