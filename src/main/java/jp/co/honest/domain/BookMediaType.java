package jp.co.honest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookMediaType {
    
    PAPER_BOOK(0, "紙の本"),
    E_BOOK(1, "電子書籍");

    private int code;
    private String label;

    public static BookMediaType valueOf(int code) {
        for (BookMediaType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}