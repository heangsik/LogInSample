package kr.co.yhs.LogInSample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardNo;

    private String title;

    private String writer;

    @Lob
    private String content;

    @CreatedDate
    private LocalDateTime registDate;

    @LastModifiedDate
    private LocalDateTime updateDate;
}
